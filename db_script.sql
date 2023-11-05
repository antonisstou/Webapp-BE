DROP DATABASE IF NOT EXISTS company;
CREATE DATABASE company;

\c company

CREATE TABLE department (
	id SERIAL PRIMARY KEY,
	name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE employee (
	id SERIAL PRIMARY KEY,
	afm VARCHAR(9) NOT NULL UNIQUE,
	firstname varchar(20) NOT NULL,
	lastname varchar(40) NOT NULL,
	birthday DATE,
	dep_id INT,
	CONSTRAINT fk_department FOREIGN KEY(dep_id) REFERENCES department(id) ON DELETE CASCADE
);


-- INSERT SOME DATA

INSERT INTO department(name)
VALUES ('DEPARTMENT 1'),
	('DEPARTMENT 2'),
	('DEPARTMENT 3'),
	('DEPARTMENT 4');
	
INSERT INTO employee(afm, firstname, lastname, birthday, dep_id)
VALUES ('000000001', 'Antonis', 'Stournaras', '1997-11-07', 19),
	('000000002', 'Eleni', 'Stournara', '1999-02-23', 19),
	('000000003', 'Georgia', 'Stournara', '2011-01-27', 20),
	('000000004', 'Dimitris', 'Mpougas', '2000-01-17', 21);

