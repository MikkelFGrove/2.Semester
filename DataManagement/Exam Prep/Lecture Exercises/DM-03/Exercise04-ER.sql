CREATE TABLE club_person
(
    id        INTEGER PRIMARY KEY,
    sex       CHAR(1)     NOT NULL,
    name      VARCHAR(50) NOT NULL,
    email     VARCHAR(50) NOT NULL UNIQUE,
    address   VARCHAR(50) NOT NULL,
    birthdate VARCHAR(50) NOT NULL,
    phone     INTEGER     NOT NULL UNIQUE
);

CREATE TABLE members
(
    id            INTEGER REFERENCES club_person (id) PRIMARY KEY,
    member_number INTEGER NOT NULL UNIQUE,
    password      VARCHAR(50)
);

CREATE TABLE workers
(
    id       INTEGER REFERENCES club_person (id) PRIMARY KEY,
    ssn      INTEGER     NOT NULL UNIQUE,
    position VARCHAR(50) NOT NULL
);

CREATE TABLE events
(
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    responsible INTEGER     NOT NULL REFERENCES members (id)
);

CREATE TABLE helpers
(
    PRIMARY KEY (events_id, member_id),
    events_id INTEGER REFERENCES events (id),
    member_id INTEGER NOT NULL UNIQUE REFERENCES members (id)
);

CREATE TABLE registered
(
    PRIMARY KEY (events_id, member_id),
    events_id INTEGER REFERENCES events (id),
    member_id INTEGER NOT NULL UNIQUE REFERENCES members (id)
);

CREATE TABLE boat_berth
(
    location     VARCHAR(4) PRIMARY KEY,
    availability BOOLEAN NOT NULL
);

CREATE TABLE rentable_boats
(
    id         INTEGER PRIMARY KEY,
    boat_berth VARCHAR NOT NULL UNIQUE REFERENCES boat_berth (location)
);

CREATE TABLE rental_timeslot
(
    start_time TIMESTAMP NOT NULL,
    end_time   TIMESTAMP NOT NULL,
    boat_id    INTEGER NOT NULL REFERENCES rentable_boats (id),
    id         INTEGER PRIMARY KEY
);

CREATE TABLE non_club_person
(
    email varchar (50) PRIMARY KEY
);

CREATE TABLE newsletter_signup
(
    type varchar(50) NOT NULL PRIMARY KEY
);

CREATE TABLE members_newsletter
(
    member_id integer PRIMARY KEY REFERENCES members(id),
    type varchar NOT NULL references newsletter_signup(type)
);

CREATE TABLE workers_newsletter
(
    member_id integer PRIMARY KEY REFERENCES workers(id),
    type varchar NOT NULL references newsletter_signup(type)
);

-- Data for club_person
INSERT INTO club_person (id, sex, name, email, address, birthdate, phone) VALUES
(1, 'M', 'John Doe', 'john.doe@example.com', '123 Maple St', '1980-01-15', 1234567890),
(2, 'F', 'Jane Smith', 'jane.smith@example.com', '456 Oak St', '1990-02-20', 1234567891),
(3, 'M', 'Tom Brown', 'tom.brown@example.com', '789 Pine St', '1985-03-25', 1234567892),
(4, 'F', 'Alice Johnson', 'alice.johnson@example.com', '101 Birch St', '1992-04-30', 1234567893);

-- Data for members
INSERT INTO members (id, member_number, password) VALUES
(1, 1001, 'password123'),
(2, 1002, 'password456');

-- Data for workers
INSERT INTO workers (id, ssn, position) VALUES
(3, 987654321, 'Manager'),
(4, 987654322, 'Coach');

-- Data for events
INSERT INTO events (id, name, responsible) VALUES
(1, 'Annual Meeting', 1),
(2, 'Summer Festival', 2);

-- Data for helpers
INSERT INTO helpers (events_id, member_id) VALUES
(1, 2);

-- Data for registered
INSERT INTO registered (events_id, member_id) VALUES
(2, 1);

-- Data for boat_berth
INSERT INTO boat_berth (location, availability) VALUES
('A1', TRUE),
('B2', FALSE);

-- Data for rentable_boats
INSERT INTO rentable_boats (id, boat_berth) VALUES
(1, 'A1'),
(2, 'B2');

-- Data for rental_timeslot
INSERT INTO rental_timeslot (start_time, end_time, boat_id, id) VALUES
('2024-06-01 10:00:00', '2024-06-01 12:00:00', 1, 1),
('2024-06-01 13:00:00', '2024-06-01 15:00:00', 2, 2);

-- Data for non_club_person
INSERT INTO non_club_person (email) VALUES
('guest@example.com');

-- Data for newsletter_signup
INSERT INTO newsletter_signup (type) VALUES
('Monthly Update'),
('Event Notification');

-- Data for members_newsletter
INSERT INTO members_newsletter (member_id, type) VALUES
(1, 'Monthly Update');

-- Data for workers_newsletter
INSERT INTO workers_newsletter (member_id, type) VALUES
(3, 'Event Notification');