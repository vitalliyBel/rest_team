CREATE DATABASE my_db;

USE my_db;

CREATE TABLE employees (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  datetime varchar(25),
  task varchar(255),
  PRIMARY KEY (id)
) ;

INSERT INTO my_db.employees (name, surname, department, datetime,task)
VALUES
	('Виталий', 'Белинский', 'IT', '15.05.2022','Сдлеать основную структуру'),
    ('Анатолий', 'Епифанов', 'Sales', '15.05.2022','Сдлеать exception'),
    ('Александр', 'Волошин', 'HR', '15.05.2022','Сдлеать restcontroller'),
    ('Никита', 'Миронов', 'Sales', '15.05.2022','покрыть код тестами'),
    ('Дмитрий', 'Верлыго', 'IT', '15.05.2022','Сдлеать dao');






USE my_db;

CREATE TABLE users (
                       username varchar(15),
                       password varchar(100),
                       enabled tinyint(1),
                       PRIMARY KEY (username)
) ;

CREATE TABLE authorities (
                             username varchar(15),
                             authority varchar(25),
                             FOREIGN KEY (username) references users(username)
) ;

INSERT INTO my_db.users (username, password, enabled)
VALUES
    ('anatoli', '{noop}anatoli', 1),
    ('vitaliy', '{noop}vitaliy', 1),
    ('nikita', '{noop}nikita', 1),
    ('dmitry', '{noop}dmitry', 1),
    ('aleksandr', '{noop}aleksandr', 1);

INSERT INTO my_db.authorities (username, authority)
VALUES
    ('anatoli', 'ROLE_EMPLOYEE'),
    ('vitaliy', 'ROLE_HR'),
    ('nikita', 'ROLE_HR'),
    ('dmitry', 'ROLE_HR'),
    ('aleksandr', 'ROLE_MANAGER');



