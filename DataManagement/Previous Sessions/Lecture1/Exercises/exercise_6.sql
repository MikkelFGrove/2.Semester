BEGIN;
CREATE TABLE Employee
(
    username varchar primary key,
    password varchar not null,
    email varchar not null unique,
    number_of_colleagues int
);

CREATE TABLE Department
(
    name varchar unique,
    number_of_members int
);

CREATE TABLE member_of
(
    employee_name varchar not null,
    department_number varchar not null,
    foreign key (employee_name) references Employee(username),
    foreign key (department_number) references Department(name)
);
SAVEPOINT my_savepoint;

CREATE INDEX ON Employee(email);

CREATE OR REPLACE PROCEDURE update_department_size(dep_id INTEGER)
AS $$
DECLARE
    number_of_department_members INTEGER := 0;
BEGIN
    SELECt COUNT(*) INTO number_of_department_members
    FROM member_of WHERE department_number = dep_id;

    UPDATE Department SET number_of_members = number_of_department_members
    WHERE name = dep_id;

END; $$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_all_department_sizes_trigger()
RETURNS TRIGGER
AS $$
BEGIN
    CALL update_department_size();
    RETURN NEW;
END; $$
LANGUAGE plpgsql;

CREATE TRIGGER update_number_of_department_members_trigger
    AFTER INSERT OR DELETE ON member_of
    EXECUTE PROCEDURE update_all_department_sizes_trigger();

INSERT INTO member_of(employee_name, department_number) values (1,'HR');


INSERT INTO Employee(username, password, email) VALUES ('1','abc','abc@gmail.com');
INSERT INTO Employee(username, password, email) VALUES ('2','123','123@gmail.com');
INSERT INTO Employee(username, password, email) VALUES ('3','xyz','xyz@gmail.com');

INSERT INTO Department(name) values ('Legal');
INSERT INTO Department(name) values ('HR');


COMMIT;