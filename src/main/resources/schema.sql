create table if not exists user_main(
id bigint not null primary key auto_increment,
user_id varchar(20) not null,
password varchar(100) not null,
role varchar(20),
name varchar(30),
age int,
pet_name varchar(20) ,
department varchar(20),
semester varchar(20),
gender varchar(20)
);



create table if not exists classes(
id bigint not null primary key,
course_id varchar(10) not null,
semester varchar(15) not null,
department varchar(50) not null,
course_name varchar(50) not null
);

