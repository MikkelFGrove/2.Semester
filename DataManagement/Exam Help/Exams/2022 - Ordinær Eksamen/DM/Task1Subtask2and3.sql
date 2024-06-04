CREATE TABLE license_types
(
    type            VARCHAR(255) PRIMARY KEY,
    file_types      VARCHAR[] NOT NULL,
    computer_amount INTEGER   NOT NULL
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    email        VARCHAR(50)  NOT NULL UNIQUE,
    license_type VARCHAR(255) REFERENCES license_types (type)
);

--ASSUMPTION: Two computers can have the same name
CREATE TABLE computer
(
    id          INTEGER UNIQUE NOT NULL,
    device_name VARCHAR(255)   NOT NULL,
    user_id     INTEGER REFERENCES users (id),
    PRIMARY KEY (user_id, id)
);

CREATE TABLE filetype
(
    type VARCHAR(10) PRIMARY KEY
);

CREATE TABLE files
(
    number   SERIAL PRIMARY KEY,
    filetype VARCHAR(10) REFERENCES filetype (type),
    --Only used by the user
    name     VARCHAR(255) NOT NULL
);

CREATE TABLE updated_files
(
    original_file_number INTEGER NOT NULL REFERENCES files (number),
    version_number       INTEGER NOT NULL,
    PRIMARY KEY (original_file_number, version_number)
);

CREATE TABLE folders
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    owner_id      INTEGER REFERENCES users (id),
    parent_folder INTEGER REFERENCES folders (id)
);

CREATE TABLE shared_files
(
    expiration_date TIMESTAMP NOT NULL,
    file_number     INTEGER REFERENCES files (number),
    shared_with     INTEGER REFERENCES users (id),
    PRIMARY KEY (file_number, shared_with)
);

INSERT INTO license_types (type, file_types, computer_amount)
VALUES
    ('TypeA', ARRAY['txt', 'doc'], 2),
    ('TypeB', ARRAY['jpg', 'png'], 3);

-- Insert data into users
INSERT INTO users (name, password, email, license_type)
VALUES
    ('John Doe', 'password123', 'john@example.com', 'TypeA'),
    ('Jane Smith', 'securepassword', 'jane@example.com', 'TypeB');

-- Insert data into computer
INSERT INTO computer (id, device_name, user_id)
VALUES
    (1, 'Computer1', 1),
    (2, 'Computer2', 1),
    (3, 'Laptop1', 2);

-- Insert data into filetype
INSERT INTO filetype (type)
VALUES
    ('txt'),
    ('doc');

-- Insert data into files
INSERT INTO files (filetype, name)
VALUES
    ('txt', 'file1.txt'),
    ('doc', 'file2.doc');

-- Insert data into updated_files
INSERT INTO updated_files (original_file_number, version_number)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);

-- Insert data into folders
INSERT INTO folders (name, owner_id, parent_folder)
VALUES
    ('RootFolder', 1, NULL),
    ('SubFolder1', 1, 1),
    ('SubFolder2', 2, 1);

-- Insert data into shared_files
INSERT INTO shared_files (expiration_date, file_number, shared_with)
VALUES
    ('2024-12-31 23:59:59', 1, 2),
    ('2024-12-31 23:59:59', 2, 1);

SELECT name, email from users JOIN license_types lt ON lt.type = users.license_type
where license_type = 'TypeA';

