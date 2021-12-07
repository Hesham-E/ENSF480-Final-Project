DROP DATABASE IF EXISTS RENT_SYSTEM;
CREATE DATABASE RENT_SYSTEM; 
USE RENT_SYSTEM;

DROP TABLE IF EXISTS ACCOUNTS;
CREATE TABLE ACCOUNTS (
    Username		varchar(50) not null,
    Password		varchar(128) not null,
	Name			varchar(25) not null,
	Email			varchar(320) not null,
    AccountType	    varchar(50),
	primary key (Username)
);

INSERT INTO ACCOUNTS (Username, Password, Name, Email, AccountType)
VALUES
('bear01',		'12345',	'Bear',		'bear@gmail.com',	 'RegRenter'),
('turtle01',	'12345',	'Turtle',	'turtle@gmail.com',	 'Landlord'),
('fox01',		'12345',	'Fox',		'fox@gmail.com',	 'Manager'),
('cow01',		'12345',	'Cow',		'cow@gmail.com',	 'RegRenter');


DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
	HouseID					int not null auto_increment,
    LandlordUsername	    varchar(50) not null,
    State					varchar(20),
    Address					varchar(200),
	Type					varchar(25),
    BedroomNo				integer,
    BathroomNo				double,
    Furnished				varchar(25),
    CityQuad				char(2),
    Cost					double,
    DateListed	    		date,
    DateRented				date default null,
    FeeDueDate				date,
	primary key (HouseID),
	foreign key (LandlordUsername) references ACCOUNTS(Username) ON UPDATE CASCADE
);

INSERT INTO PROPERTY (HouseID, LandlordUsername, State, Address, Type, BedroomNo, BathroomNo, Furnished, CityQuad, Cost, DateListed, DateRented, FeeDueDate)
VALUES
(1,	'bear01',	'Active',	'242 Rainbow Road', 'Apartment',	3,	2.5, true, 'NW', 250000, '2021-12-01', null, '2022-01-30');

DROP TABLE IF EXISTS MESSAGE;
CREATE TABLE MESSAGE (
	MessageID		int not null auto_increment,
	LandlordEmail	varchar(320),
    Message			varchar(1000),
	primary key (MessageID)
);

INSERT INTO MESSAGE (MessageID, LandlordEmail, Message)
VALUES
(1, "lan@gmail.com",	'Hello, I am interested in renting your property.');

