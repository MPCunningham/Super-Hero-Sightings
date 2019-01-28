drop database if exists SuperHeroSightings;

create database SuperHeroSightings;

use SuperHeroSightings;

create table Supers
(SuperId int primary key auto_increment,
Name varchar(30) not null,
Description varchar(45) null);

create table Powers
(PowerId int primary key auto_increment,
Name varchar(30) not null,
Description varchar(45) null);

create table Super_Powers
(SuperId int not null,
PowerId int not null,
primary key (SuperId, PowerId),
foreign key (SuperId) references Supers (SuperId),
foreign key (PowerId) references Powers (PowerId));

create table Organizations
(OrganizationId int primary key auto_increment,
Name varchar(30) not null,
Description varchar(45) null,
Address varchar(45) null,
PhoneNumber varchar(15) null); 

create table Super_Organizations
(SuperId int not null,
OrganizationId int not null,
primary key (SuperId, OrganizationId),
foreign key (SuperId) references Supers (SuperId),
foreign key (OrganizationId) references Organizations (OrganizationId));

create table Locations
(LocationId int primary key auto_increment,
Name varchar(30) not null,
Description varchar(45) null,
Address varchar(45) not null,
Latitude double not null,
Longitude double not null);

create table Sightings
(SightingId int primary key auto_increment,
Date date not null,
SuperId int not null,
LocationId int not null,
foreign key (SuperId) references Supers (SuperId),
foreign key (LocationId) references Locations (LocationId));   