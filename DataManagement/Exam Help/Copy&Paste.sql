-- This is a copy and paste document for DM exam

-- DROP TABLE
DROP TABLE IF EXISTS table_name CASCADE;

-- DROP DATABASE
DROP DATABASE IF EXISTS database_name;

-- Reset public schema
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;

-- Creating and Altering Tables
CREATE TABLE my_table(
    id serial PRIMARY KEY,
    my_attribute VARCHAR (50) UNIQUE NOT NULL
);
ALTER TABLE my_table ADD COLUMN my_new_coulmn TIMESTAMP;
ALTER TABLE my_table ALTER COLUMN my_new_coulmn TYPE varchar(50);
ALTER TABLE my_table DROP COLUMN my_new_coulmn;
DROP TABLE my_table;

--region CRUD Commands:
    --Create:
        CREATE TABLE account(
            username VARCHAR (50) UNIQUE NOT NULL,
            password VARCHAR (50) NOT NULL,
            email VARCHAR (50) UNIQUE NOT NULL,
            created_on TIMESTAMP
        );

        INSERT INTO account (username, password, email, created_on)
        VALUES ('John', 'myPassW0rd', 'john@acme.com', NOW());
        INSERT INTO account (username, password, email, created_on)
        VALUES ('Anne', 'myPassW0rd', 'anne@acme.com', NOW());

    --Read:
        SELECT * FROM account;
        SELECT username, created_on FROM account WHERE email = 'john@acme.com';
        SELECT username, created_on FROM account WHERE email LIKE '%anne%';

    --Update:
        UPDATE account SET password = 'newPassW0rd' WHERE username = 'Anne';

    --Delete
        DELETE FROM account WHERE email = 'john@acme.com';

        --BEWARE of doing this:
        DELETE FROM account;
--endregion

--region Nested Queries
    /*Nested queries, or subqueries, are SQL queries embedded
    within another query to perform operations that
    rely on the results of the inner query.*/
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    department_id INT,
    salary DECIMAL(10, 2),
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);
-- Find employees with salary above the average salary of their department
SELECT first_name, last_name, department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
    WHERE department_id = e.department_id
);

-- Find the department with the highest number of employees and list those employees
SELECT first_name, last_name, department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.department_id = (
    SELECT department_id
    FROM (
        SELECT department_id, COUNT(employee_id) AS employee_count
        FROM employees
        GROUP BY department_id
        ORDER BY employee_count DESC
        LIMIT 1
    ) AS subquery
);

--endregion

--region procedure
CREATE OR REPLACE PROCEDURE TransferMoney(
    from_account INT,
    to_account INT,
    amount NUMERIC(10, 2)
)
AS $$
BEGIN
    -- Check if the from_account has enough balance
    IF (SELECT balance FROM accounts WHERE account_id = from_account) < amount THEN
        RAISE EXCEPTION 'Insufficient funds in account %', from_account;
    END IF;

    -- Deduct the amount from the from_account
    UPDATE accounts
    SET balance = balance - amount
    WHERE account_id = from_account;

    -- Add the amount to the to_account
    UPDATE accounts
    SET balance = balance + amount
    WHERE account_id = to_account;

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback the transaction in case of an error
        ROLLBACK;
        RAISE;
END;
$$;
CALL TransferMoney(1, 2, 200.00);

--endregion
--region Trigger
CREATE OR REPLACE FUNCTION TransferMoneyTrigger()
RETURNS TRIGGER AS $$
BEGIN
    -- Check if the from_account has enough balance
    IF (SELECT balance FROM accounts WHERE account_id = NEW.from_account) < NEW.amount THEN
        RAISE EXCEPTION 'Insufficient funds in account %', NEW.from_account;
    END IF;

    -- Deduct the amount from the from_account
    UPDATE accounts
    SET balance = balance - NEW.amount
    WHERE account_id = NEW.from_account;

    -- Add the amount to the to_account
    UPDATE accounts
    SET balance = balance + NEW.amount
    WHERE account_id = NEW.to_account;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
--endregion

--region index
    CREATE INDEX idx_department ON employees(department);
    SELECT * FROM employees WHERE department = 'HR';
--endregion

--region function
CREATE OR REPLACE FUNCTION total_sales(item_name VARCHAR)
RETURNS NUMERIC AS $$
DECLARE
    total NUMERIC;
BEGIN
    SELECT SUM(quantity * price) INTO total
    FROM sales
    WHERE item = item_name;

    RETURN total;
END;
$$ LANGUAGE plpgsql;
SELECT total_sales('Laptop');
--endregion








--region more examples of triggers and functions
CREATE TABLE employees_audit (
    id SERIAL PRIMARY KEY,
    emp_id INT,
    operation VARCHAR(10),
    old_name VARCHAR(100),
    old_salary NUMERIC,
    new_name VARCHAR(100),
    new_salary NUMERIC,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION audit_employee_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'UPDATE' THEN
        INSERT INTO employees_audit (emp_id, operation, old_name, old_salary, new_name, new_salary)
        VALUES (OLD.id, TG_OP, OLD.name, OLD.salary, NEW.name, NEW.salary);
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO employees_audit (emp_id, operation, old_name, old_salary)
        VALUES (OLD.id, TG_OP, OLD.name, OLD.salary);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_audit_employee_changes
AFTER UPDATE OR DELETE ON employees
FOR EACH ROW EXECUTE FUNCTION audit_employee_changes();

-- next one
CREATE OR REPLACE FUNCTION enforce_balance_check()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.balance < 0 THEN
        RAISE EXCEPTION 'Insufficient funds';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_enforce_balance_check
BEFORE UPDATE ON accounts
FOR EACH ROW EXECUTE FUNCTION enforce_balance_check();

-- next one
CREATE OR REPLACE FUNCTION update_last_modified()
RETURNS TRIGGER AS $$
BEGIN
    NEW.last_modified = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_last_modified
BEFORE UPDATE ON my_table
FOR EACH ROW EXECUTE FUNCTION update_last_modified();

-- next one
CREATE OR REPLACE FUNCTION cascade_delete()
RETURNS TRIGGER AS $$
BEGIN
    DELETE FROM child_table WHERE parent_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_cascade_delete
AFTER DELETE ON parent_table
FOR EACH ROW EXECUTE FUNCTION cascade_delete();

--endregion

--region more examples of functions
CREATE OR REPLACE PROCEDURE update_employee_salaries(increase_percent NUMERIC)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE employees
    SET salary = salary + (salary * increase_percent / 100)
    WHERE department = 'Sales';
END;
$$;

-- Call the procedure
CALL update_employee_salaries(5);

-- next one

CREATE OR REPLACE PROCEDURE transform_and_insert_data()
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO transformed_data (id, name, salary)
    SELECT id, UPPER(name), salary * 1.1
    FROM source_data
    WHERE salary > 50000;
END;
$$;

-- Call the procedure
CALL transform_and_insert_data();

--next one

CREATE OR REPLACE PROCEDURE generate_monthly_sales_report(month DATE)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO sales_report (report_month, total_sales, total_customers)
    SELECT month, SUM(amount), COUNT(DISTINCT customer_id)
    FROM sales
    WHERE DATE_TRUNC('month', sale_date) = month;
END;
$$;

-- Call the procedure
CALL generate_monthly_sales_report('2023-05-01');

--next one
CREATE OR REPLACE PROCEDURE insert_employee(
    emp_id INT, emp_name VARCHAR, emp_salary NUMERIC)
LANGUAGE plpgsql
AS $$
BEGIN
    IF emp_salary < 0 THEN
        RAISE EXCEPTION 'Salary cannot be negative';
    ELSIF emp_name IS NULL OR emp_name = '' THEN
        RAISE EXCEPTION 'Employee name cannot be empty';
    ELSE
        INSERT INTO employees (id, name, salary)
        VALUES (emp_id, emp_name, emp_salary);
    END IF;
END;
$$;

-- Call the procedure
CALL insert_employee(101, 'John Doe', 70000);

--endregion

--region more examples of transactions
BEGIN;

-- Deduct from sender's account
UPDATE accounts
SET balance = balance - 100
WHERE account_id = 1;

-- Add to recipient's account
UPDATE accounts
SET balance = balance + 100
WHERE account_id = 2;

-- Check for any errors before committing
IF (SELECT balance FROM accounts WHERE account_id = 1) < 0 THEN
    ROLLBACK;
    RAISE EXCEPTION 'Insufficient funds';
ELSE
    COMMIT;
END IF;

--next one
BEGIN;

-- Insert customer record
INSERT INTO customers (name, email)
VALUES ('Alice', 'alice@example.com')
RETURNING id INTO customer_id;

-- Insert order record linked to the customer
INSERT INTO orders (customer_id, order_date, amount)
VALUES (customer_id, CURRENT_DATE, 150);

-- Insert order items linked to the order
INSERT INTO order_items (order_id, product_id, quantity)
VALUES (currval('orders_id_seq'), 1, 2),
       (currval('orders_id_seq'), 2, 1);

-- Commit the transaction
COMMIT;

--one more
BEGIN;

-- Reduce inventory count for ordered products
UPDATE inventory
SET quantity = quantity - 1
WHERE product_id = 1 AND quantity > 0;

UPDATE inventory
SET quantity = quantity - 2
WHERE product_id = 2 AND quantity > 0;

-- Check for inventory availability
IF NOT FOUND THEN
    ROLLBACK;
    RAISE EXCEPTION 'Insufficient inventory for one or more products';
ELSE
    -- Insert order record
    INSERT INTO orders (customer_id, order_date, amount)
    VALUES (123, CURRENT_DATE, 300);

    COMMIT;
END IF;

--one more
BEGIN;

-- Perform complex validations
DO $$
BEGIN
    IF EXISTS (SELECT 1 FROM employees WHERE id = 101 AND salary < 0) THEN
        RAISE EXCEPTION 'Salary cannot be negative';
    END IF;

    IF EXISTS (SELECT 1 FROM employees WHERE id = 101 AND name IS NULL) THEN
        RAISE EXCEPTION 'Employee name cannot be null';
    END IF;
END;
$$;

-- Update employee record
UPDATE employees
SET salary = 75000, name = 'John Smith'
WHERE id = 101;

-- Commit the transaction
COMMIT;