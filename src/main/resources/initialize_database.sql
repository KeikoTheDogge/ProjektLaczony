drop database nfz;

create database nfz;

use nfz;

create table users (
    userID int primary key auto_increment,
    login varchar(20),
    password varchar(20),
    name varchar(20),
    surname varchar(20)
);

drop database nfz;


create table patients (
    userID int,
    adres varchar(20),
    foreign key (userID) references users(userID)
);

create table doctors (
    userID int,
    specialization varchar(20),
    foreign key (userID) references users(userID)
);

create table visits (
    visitId int primary key auto_increment,
    date date,
    time_from time,
    time_to time,
    type varchar(50),
    doctorId int not null,
    patientId int,
    foreign key (doctorId) references users(userID),
    foreign key (patientId) references users(userID)
);

drop table visits;

insert into users(userID, login, password, name, surname) VALUES (1, 'kowal', 'dupa', 'Jan', 'Kowalski');
insert into patients(userID, adres) VALUES (1, 'Dupna 123');
insert into users(userID, login, password, name, surname) VALUES (2, 'malina', 'dupa', 'Adam', 'Malina');
insert into doctors(userID, specialization) VALUES (2, 'kardiolog');
insert into users(userID, login, password, name, surname) VALUES (3, 'gorzala', 'dupa', 'Marian', 'Gorzala');
insert into doctors(userID, specialization) VALUES (3, 'chirurg');



select * from doctors;

delete from doctors where specialization='' OR specialization IS NULL;

delete from patients where userID = 4;
delete from users where userID = 4;
delete from users where name='' OR name IS NULL;






