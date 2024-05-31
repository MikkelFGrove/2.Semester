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
    SELECT username, email, created_by
    FROM (SELECT *
        FROM blog_entries.created_by = account.id)
    AS result_set WHERE created_by = 2;

--endregion

