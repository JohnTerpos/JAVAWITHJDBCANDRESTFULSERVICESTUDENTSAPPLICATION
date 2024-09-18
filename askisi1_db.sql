DROP DATABASE askisi1_db IF EXISTS;
CREATE DATABASE askisi1_db;
USE askisi1_db;
CREATE TABLE students(
      firstname VARCHAR(20), lastname VARCHAR(20),
	  department VARCHAR(20), semester INT(3), passed_lessons INT(3)
    );