DROP DATABASE IF EXISTS bookstore;
CREATE DATABASE bookstore;

\c bookstore

CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(40) NOT NULL,
    lastname VARCHAR(40) NOT NULL
);

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    publisher VARCHAR(60),
    publishedyear INT,
    author_id INT,
    CONSTRAINT fk_author FOREIGN KEY(author_id) REFERENCES author(id) ON DELETE CASCADE
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255) NOT NULL
);

-- INSERT SOME DATA

INSERT INTO author(firstname, lastname)
VALUES ('Leo', 'Tolstoy'),
	('Camilla', 'Lackberg'),
	('Fyodor', 'Dostoevsky'),
	('James', 'Patterson');
	
INSERT INTO book(isbn, title, publisher, publishedyear, author_id)
VALUES ('9789604460151', 'Anna Karenina', 'Agra', '1878', 1),
	   ('9789604469987', 'War and Peace', 'Gobosty', '1867', 1),
	   ('9781681772097', 'The Drowling', 'Metechmio', '2007', 2),
	   ('9789137134093', 'The Lost Boy', 'Metechmio', '2009', 2),
	   ('9789604462162', 'Crime and Punishment', 'Gobosty', '1866', 3),
	   ('9789604462193', 'Demons', 'Gobosty', '1872', 3),
	   ('9789604508495', '1 To Die', 'Bell', '2001', 4),
	   ('9780316211291', 'Unlucky 13', 'Bell', '2014', 4);

INSERT INTO users(id, username, password)
VALUES (1, 'antonis', '$2a$10$L5rDWxMiANwzPTMosuG1cObKWsF65tCv1deBJvto1M.HRj/ek0frm'),
(2, 'eleni', '$2a$10$hEPMxUE7O3/JVQ4fsw9LBexKFMcmVkVhwaxRUs1.SBOozAP3mpODi');