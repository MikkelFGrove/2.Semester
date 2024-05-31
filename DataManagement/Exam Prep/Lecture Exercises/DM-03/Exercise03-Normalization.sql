CREATE TABLE designation (
    id SERIAL PRIMARY KEY,
    designation varchar (50) NOT NULL UNIQUE,
    charges INTEGER NOT NULL
);

CREATE TABLE department (
    id SERIAL PRIMARY KEY,
    department varchar (50) NOT NULL UNIQUE
);

CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    name varchar (50) NOT NULL,
    room_address varchar (10) not null,
    phone INTEGER NOT NULL UNIQUE,
    department_id INTEGER NOT NULL REFERENCES department(id),
    designation_id INTEGER NOT NULL REFERENCES designation(id)
);

CREATE TABLE patient (
    id SERIAL PRIMARY KEY,
    name varchar (50) NOT NULL,
    cpr_number char(11) NOT NULL UNIQUE,
    phone INTEGER NOT NULL UNIQUE
);

CREATE TABLE patient_doctor (
    doctor_id INTEGER NOT NULL REFERENCES doctors(id),
    patient_id INTEGER NOT NULL REFERENCES patient(id)
);

CREATE TABLE room
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(50)
);

CREATE TABLE patient_room (
    patient_id INTEGER NOT NULL REFERENCES patient(id),
    room_id INTEGER NOT NULL REFERENCES room(id)
);

CREATE TABLE bed
(
    id SERIAL PRIMARY KEY
);

CREATE TABLE patient_bed
(
    patient_id INTEGER NOT NULL REFERENCES patient (id),
    bed_id     INTEGER NOT NULL REFERENCES bed (id)
);

INSERT INTO bed DEFAULT
VALUES;
INSERT INTO bed DEFAULT
VALUES;
INSERT INTO bed DEFAULT
VALUES;
INSERT INTO bed DEFAULT
VALUES;
INSERT INTO bed DEFAULT
VALUES;

INSERT INTO patient (name, cpr_number, phone)
VALUES ('Jan', '190582-1113', 98769876),
       ('Peter', '300175-2659', 87658765),
       ('Jens', '041298-1257', 76547654),
       ('Ole', '051165-9863', 65436543),
       ('Anna', '260792-1050', 43214321),
       ('Dennis', '150893-1151', 32103210),
       ('Ahmed', '010211-7853', 10981098),
       ('Annika', '051285-8072', 98709870);

INSERT INTO patient_bed (patient_id, bed_id)
VALUES (1,1),
       (1,4),
       (2,1),
       (4,1),
       (3,2),
       (5,3),
       (8,5);

INSERT INTO room (type)
VALUES ('Normal'),
       ('Two Bed'),
       ('Special'),
       ('Special');

INSERT INTO patient_room (patient_id, room_id)
VALUES (1,2),
       (2,1),
       (3,2),
       (4,1),
       (5,2),
       (1,3),
       (8,4);

INSERT INTO department (department)
VALUES ('Neurology'),
       ('Orthopedic'),
       ('ENT/Neurology'),
       ('Skin/Orthopaedic');

INSERT INTO designation (designation, charges)
VALUES ('Professor', 5000),
       ('Assistant Professor', 3000);

INSERT INTO doctors (name, room_address, phone, department_id, designation_id)
VALUES ('Dr. Peterson','U45',12341234,1,1),
       ('Dr. Jensen','U32',23452345,2,1),
       ('Dr. Poetch','U186',34563456,3,2),
       ('Dr. Neurenheim','U150',45674567,4,2);

INSERT INTO patient_doctor (doctor_id, patient_id)
VALUES (1,1),
       (1,2),
       (1,3),
       (2,4),
       (2,3),
       (2,5),
       (3,6),
       (3,1),
       (4,7),
       (4,8);

SELECT patient.name, patient.cpr_number, patient_room.room_id, patient_bed.bed_id
FROM patient
         JOIN patient_bed ON patient.id = patient_bed.patient_id
         JOIN patient_room on patient.id = patient_room.patient_id
         JOIN patient_doctor pd ON patient.id = pd.patient_id
WHERE doctor_id = 1;

SELECT patient.name,
       patient.cpr_number,
       STRING_AGG(DISTINCT pr.room_id::TEXT, ', ') AS rooms,
       STRING_AGG(DISTINCT pb.bed_id::TEXT, ', ') AS beds
FROM patient
JOIN patient_bed pb ON patient.id = pb.patient_id
JOIN patient_room pr ON patient.id = pr.patient_id
JOIN patient_doctor pd ON patient.id = pd.patient_id
WHERE pd.doctor_id = 1
GROUP BY patient.name, patient.cpr_number;