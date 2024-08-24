create database library;
use library;
CREATE TABLE books (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    available BOOLEAN DEFAULT TRUE
);
INSERT INTO books (isbn, title, author) VALUES
('9780321356680', 'Clean Code', 'Robert C. Martin'),
('9780596007126', 'Head First Java', 'Kathy Sierra'),
('9780132350884', 'The Pragmatic Programmer', 'Andrew Hunt'),
('9780201633610', 'Design Patterns', 'Erich Gamma'),
('9780134685991', 'Effective Java', 'Joshua Bloch'),
('9780321125217', 'Improving the Design of Existing Code', 'Martin Fowler'),
('9781118009249', 'Java Concurrency in Practice', 'Brian Goetz'),
('9780321558237', 'Java Performance: The Definitive Guide', 'Scott Oaks'),
('9781119335000', 'Modern Java in Action', 'Mario Fusco'),
('9780134689333', 'Java 8 Lambdas', 'Richard Warburton'),
('9780135712033', 'Core Java Volume I--Fundamentals', 'Cay S. Horstmann'),
('9780135166307', 'Core Java Volume II--Advanced Features', 'Cay S. Horstmann'),
('9780134442585', 'Core Java SE 9 for the Impatient', 'Cay S. Horstmann'),
('9780134852486', 'Core Java SE 10 for the Impatient', 'Cay S. Horstmann'),
('9780134852837', 'Core Java SE 11 for the Impatient', 'Cay S. Horstmann'),
('9780136529873', 'Java Cookbook', 'Ian F. Darwin'),
('9780321717296', 'Java Generics and Collections', 'Philip Wadler'),
('9780596009205', 'Java Network Programming', 'Elliotte Rusty Harold'),
('9781449363352', 'Java Network Programming: Developing Networked Applications', 'Elliotte Rusty Harold'),
('9781449370176', 'JavaFX: Building Rich Client Applications', 'Paul Anderson'),
('9780137081073', 'JavaFX 2.0: Introduction by Example', 'Carl Dea'),
('9781430264721', 'Beginning Java 8 APIs, Extensions and Libraries', 'Kishori Sharan'),
('9781430246275', 'Java EE 7 Essentials', 'Arun Gupta'),
('9781788293037', 'Hands-On Java 10 Programming with JShell', 'Rafal Leszko'),
('9781788627908', 'Java 11 Quick Syntax Reference', 'Mikael Olsson');
select * from books;
set SQL_SAFE_UPDATES=0;
DELETE FROM books;
INSERT INTO books (isbn, title, author) VALUES
('9780321356680', 'Clean Code', 'Ramesh Menon'),
('9780596007126', 'Head First Java', 'Kavitha Singh, Bharat Gupta'),
('9780132350884', 'The Pragmatic Programmer', 'Devendra Kumar'),
('9780201633610', 'Design Patterns', 'Neha Gupta'),
('9780134685991', 'Effective Java', 'Rahul Jain'),
('9780321125217', 'Refactoring: Improving the Design of Existing Code', 'Anjali Desai'),
('9781118009249', 'Java Concurrency in Practice', 'Siddharth Reddy'),
('9780321558237', 'Java Performance: The Definitive Guide', 'Aditya Kapoor'),
('9781119335000', 'Modern Java in Action', 'Varun Gupta'),
('9780134689333', 'Java 8 Lambdas', 'Neha Verma'),
('9780135712033', 'Core Java Volume I--Fundamentals', 'Aarav Singh'),
('9780135166307', 'Core Java Volume II--Advanced Features', 'Shreya Sharma'),
('9780134442585', 'Core Java SE 9 for the Impatient', 'Rohan Gupta'),
('9780134852486', 'Core Java SE 10 for the Impatient', 'Kavya Patel'),
('9780134852837', 'Core Java SE 11 for the Impatient', 'Rohit Kumar'),
('9780136529873', 'Java Cookbook', 'Anjali Deshmukh'),
('9780321717296', 'Java Generics and Collections', 'Aryan Gupta, Priya Sharma'),
('9780596009205', 'Java Network Programming', 'Rahul Desai'),
('9781449363352', 'Java Network Programming: Developing Networked Applications', 'Tanvi Reddy'),
('9781449370176', 'JavaFX: Building Rich Client Applications', 'Aarav Shah'),
('9780137081073', 'JavaFX 2.0: Introduction by Example', 'Ananya Singh'),
('9781430264721', 'Beginning Java 8 APIs, Extensions and Libraries', 'Pranav Verma'),
('9781430246275', 'Java EE 7 Essentials', 'Sneha Singh'),
('9781788293037', 'Hands-On Java 10 Programming with JShell', 'Vivek Kumar'),
('9781788627908', 'Java 11 Quick Syntax Reference', 'Neha Verma');
CREATE TABLE usertable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);
INSERT INTO usertable (username, password) VALUES ('harini_2003', 'harini03'); 
INSERT INTO usertable (username, password) VALUES ('hari_1998', 'hari98'); 
INSERT INTO usertable (username, password) VALUES ('mani_1972', 'mani72'); 
INSERT INTO usertable (username, password) VALUES ('yashu_21', 'yashu21'); 
select * from user;
