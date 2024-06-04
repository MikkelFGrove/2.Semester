create table supplier
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE table materials
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    price real not null,
    supplier_id integer references supplier(id) NOT null,
    --set in days
    delivery_time  integer not null
);

create table workers
(
    ssn integer PRIMARY KEY,
    position VARCHAR(255) NOT NULL,
    hourly_salary real not null,
    name varchar (255) not null
);

create table technical_drawings
(
    id serial PRIMARY KEY,
    uploaded_by integer REFERENCES workers(ssn) NOT NULL
);

create table drawing_versions
(
    original_drawing integer REFERENCES technical_drawings(id) NOT NULL,
    version_number integer NOT NULL,
    PRIMARY KEY (original_drawing,version_number)
);

create table components
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    technical_drawing_id integer REFERENCES technical_drawings(id)
);

create table consists_of
(
    component_id integer REFERENCES components(id),
    material_id integer references materials(id),
    PRIMARY KEY (component_id,material_id),
    --can either be per material or weight based therefore 'real' type
    amount real not null
);



create table constructions
(
    id serial PRIMARY KEY,
    name varchar(255) NOT NULL UNIQUE,
    technical_drawing_id integer REFERENCES technical_drawings(id)
);

create table component_construction
(
    component_id integer REFERENCES components(id),
    construction_id integer REFERENCES constructions(id),
    PRIMARY KEY (component_id,construction_id)
);

create table works_on
(
    worker_ssn integer REFERENCES workers(ssn),
    constructions_id integer REFERENCES constructions(id),
    PRIMARY KEY (worker_ssn,constructions_id),
    hours_used integer not null
);

insert into supplier (name) VALUES ('Ole_INC');

insert into materials (name, price, supplier_id, delivery_time) VALUES ('Metal',32.4,1,5);

insert into workers (ssn, position, hourly_salary, name) VALUES (0102037581,'Basic Labour',160,'Ole Hansen');

insert into technical_drawings(uploaded_by) VALUES (0102037581);

insert into drawing_versions(original_drawing, version_number) VALUES (1,1);

insert into components(name, technical_drawing_id) VALUES ('Wing', 1);

insert into consists_of(component_id, material_id, amount) VALUES (1,1,24);

insert into constructions(name, technical_drawing_id) VALUES ('A123',1);

insert into component_construction(component_id, construction_id) VALUES (1,1);

insert into works_on(worker_ssn, constructions_id, hours_used) VALUES (0102037581,1,20)
