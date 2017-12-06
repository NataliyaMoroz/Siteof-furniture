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


insert INTO bed(price, brand, wood_variety, size) VALUES (50, 'IKEA', 'good', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (60, 'MOON', 'bad', 'small');
insert INTO bed(price, brand, wood_variety, size) VALUES (70, 'LOOL', 'middle', 'middle');
insert INTO bed(price, brand, wood_variety, size) VALUES (30, 'IKEA', 'very-very', 'small');
insert INTO bed(price, brand, wood_variety, size) VALUES (66, 'EST', 'good', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (54, 'POL', 'good', 'middle');
insert INTO bed(price, brand, wood_variety, size) VALUES (34, 'POZ', 'bad', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (66, 'POZ', 'good', 'small');
insert INTO bed(price, brand, wood_variety, size) VALUES (123, 'EST', 'bad', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (555, 'IKEA', 'good', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (122, 'IKEA', 'good', 'middle');
insert INTO bed(price, brand, wood_variety, size) VALUES (123, 'IKEA', 'amazing', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (512, 'MOON', 'good', 'big');
insert INTO bed(price, brand, wood_variety, size) VALUES (12, 'IKEA', 'cool', 'small');

insert INTO mattress(price, brand, kind, max_weight) VALUES (40, 'IKEA', 'kind', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (50, 'IKEA', 'bad', 200);
insert INTO mattress(price, brand, kind, max_weight) VALUES (20, 'MOON', 'good', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (430, 'IKEA', 'kind', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (455, 'IKEA', 'kind', 300);
insert INTO mattress(price, brand, kind, max_weight) VALUES (56, 'BAD', 'kind', 300);
insert INTO mattress(price, brand, kind, max_weight) VALUES (123, 'IKEA', 'type', 444);
insert INTO mattress(price, brand, kind, max_weight) VALUES (40, 'EST', 'kind', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (40, 'IKEA', 'kind', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (123, 'POZ', 'idea', 50);
insert INTO mattress(price, brand, kind, max_weight) VALUES (40, 'IKEA', 'kind', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (66, 'POL', 'kind', 30);
insert INTO mattress(price, brand, kind, max_weight) VALUES (40, 'POL', 'lol', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (434, 'POL', 'kind', 234);
insert INTO mattress(price, brand, kind, max_weight) VALUES (120, 'IKEA', 'bb', 122);
insert INTO mattress(price, brand, kind, max_weight) VALUES (430, 'POZ', 'kind', 3333);
insert INTO mattress(price, brand, kind, max_weight) VALUES (40, 'IKEA', 'kind', 66);
insert INTO mattress(price, brand, kind, max_weight) VALUES (4120, 'POZ', 'sdf', 120);
insert INTO mattress(price, brand, kind, max_weight) VALUES (403, 'IKEA', 'kind', 122);

insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'IKEA','YES', 200);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (123, 'IKEA','NO', 2);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'EST','MAYBE', 3);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (123, 'IKEA','YES', 1);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'EST','MAYBE', 4);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (443, 'IKEA','GOOD', 2);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'BRAND','YES', 2);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (34, 'IKEA','YES', 3);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'IKEA','YES', 4);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'BRAND','BAD', 5);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (223, 'IKEA','YES', 6);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (223, 'IKEA','YES', 7);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'IKEA','WOW', 2);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (2, 'LOL','YES', 3);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (22, 'IKEA','YES', 4);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (422, 'EST','HI', 2);
insert INTO sofa (price, brand, armrest, num_of_seats) VALUES (56, 'IKEA','YES', 2);