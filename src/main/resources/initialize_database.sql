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

insert into visits(visitId, date, time, doctorId)
values
(1, '2023-01-24', '12:00:00', 2),
(2, '2023-01-24', '12:30:00', 2),
(3, '2023-01-24', '13:00:00', 2),
(4, '2023-01-24', '13:30:00', 2);

insert into visits(visitId, date, time, doctorId)
values
    (5, '2023-01-24', '15:00:00', 3),
    (6, '2023-01-24', '15:30:00', 3),
    (7, '2023-01-24', '16:00:00', 3),
    (8, '2023-01-24', '16:30:00', 3);


alter table doctors
add work_for time;

alter table doctors
add work_to time;

insert into users(userID, login, password, name, surname) VALUES (6, 'jeleń', 'dupa', 'marcin', 'jeleń');
insert into doctors(userID, specialization, work_for, work_to, work_hours) values (6, 'dermatolog', '8:00', '16:00', subtime(work_to, work_for)/10000);

alter table doctors
add work_hours int;

select * from doctors;

delete from doctors where specialization='' OR specialization IS NULL;

delete from patients where userID = 4;
delete from users where userID = 4;
delete from users where name='' OR name IS NULL;

alter table doctors
drop column work_hours;



