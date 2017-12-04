DROP DATABASE IF EXISTS shop;
create database shop;
use shop;
create table user (id INT NOT NULL AUTO_INCREMENT, email VARCHAR(30) NOT NULL, hash_password VARCHAR(100) NOT NULL, name VARCHAR(50) NOT NULL,  region VARCHAR(30) NOT NULL, role ENUM('admin', 'user'), PRIMARY KEY (id));
create table booking (id INT NOT NULL AUTO_INCREMENT, id_user INT NOT NULL, id_furniture INT NOT NULL, category VARCHAR(30) NOT NULL, PRIMARY KEY (id));
create table mattress (id INT NOT NULL AUTO_INCREMENT, price int not null, brand varchar(30) not null, kind varchar(30) not null, max_weight int not null,  PRIMARY KEY (id));
create table bed (id INT NOT NULL AUTO_INCREMENT, price int not null, brand varchar(30) not null, wood_variety varchar(30) not null, size varchar(30) not null,  PRIMARY KEY (id));
create table sofa (id INT NOT NULL AUTO_INCREMENT, price int not null, brand varchar(30) not null, armrest varchar(30), num_of_seats int not null,  PRIMARY KEY (id));

show tables;

# password - 1234
insert INTO user(email, hash_password, name, region, role) VALUES ('admin@admin.com', '$2a$10$5RhehnDP.gL2W5sYP9vcdu8G0k63Lj9zWri6bBlrZHQ0hDZiiMsOS',	'Natasha',	'Poznan',	'admin');

