CREATE TABLE customers
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(50)  NOT NULL UNIQUE,
    email      VARCHAR(355) NOT NULL UNIQUE,
    created_on TIMESTAMP,
    last_login TIMESTAMP
);

CREATE TABLE products
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(50) NOT NULL,
    price REAL     NOT NULL
);

CREATE TABLE orders
(
    id           SERIAL PRIMARY KEY,
    order_number CHAR(10) NOT NULL UNIQUE,
    customer_id  INTEGER  NOT NULL REFERENCES customers (id)
);

create table order_lines
(
    id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL REFERENCES orders(id),
    product_id INTEGER NOT NULL REFERENCES products(id),
    amount INTEGER NOT NULL
);

INSERT INTO customers(username, password, email)
VALUES ('John', 'myPassWOrd', 'john@acme.com'),
       ('Anne', 'SomePassword', 'anne@acme.com');

INSERT INTO products(name, price)
VALUES ('Samsung Galaxy S20', 7799.95),
       ('Samsung Galaxy S20 - Leather Cover', 799.95),
       ('iPhone 11 pro', 8899),
       ('iPhone 11 pro - Leather Cover', 399.5),
       ('Huawei P30 Lite', 1664.5),
       ('Huawei P30 - Leather cover', 1664.5);

INSERT INTO orders(order_number, customer_id)
VALUES ('DA-0001234', 1),
       ('DA-0001235', 1),
       ('DE-0001236', 2),
       ('DE-0001237', 2);

INSERT INTO order_lines(order_id, product_id, amount)
VALUES (1, 1, 2),
       (1, 2, 2),
       (1, 5, 1),
       (3, 3, 2),
       (3, 4, 1),
       (4, 1, 1);

ALTER TABLE products
    ADD COLUMN manufacturer VARCHAR(250);

CREATE VIEW AllProductsBoughtView AS
SELECT orders.order_number,
       customers.email,
       products.name,
       order_lines.amount
FROM orders
         JOIN
     customers ON orders.customer_id = customers.id
         JOIN
     order_lines ON orders.id = order_lines.order_id
         JOIN
     products ON order_lines.product_id = products.id;

SELECT * FROM allproductsboughtview;

CREATE VIEW ProductsSold AS
SELECT products.name,
       sum(order_lines.amount) OVER (PARTITION BY products.id) AS units_sold,
       sum(cast(order_lines.amount as real) * products.price) OVER (PARTITION by products.id) AS total_revenue
FROM products
         JOIN
       order_lines ON products.id = order_lines.product_id;
 SELECT * from ProductsSold;

SELECT * FROM AllProductsBoughtView where order_number = 'DA-0001234';

