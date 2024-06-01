begin;
CREATE TABLE employee
(
    username varchar (50) PRIMARY KEY,
    password varchar(50) NOT NULL,
    email varchar (50) NOT NULL UNIQUE
);
commit;
rollback;

CREATE TABLE department
(
    id integer PRIMARY KEY,
    name varchar(50) NOT NULL UNIQUE,
    number_of_members integer
);

CREATE TABLE member_of
(
    employee_username varchar(50) REFERENCES employee(username),
    department_id integer references department(id)
);