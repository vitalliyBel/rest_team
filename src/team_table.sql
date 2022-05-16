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


