DROP DATABASE IF EXISTS RENT_SYSTEM;
CREATE DATABASE RENT_SYSTEM; 
USE RENT_SYSTEM;

DROP TABLE IF EXISTS ACCOUNTS;
CREATE TABLE ACCOUNTS (
	AccountID		int not null auto_increment,
	Name			varchar(25) not null,
	Email			varchar(320) not null,
    Username		varchar(50) not null,
    Password		varchar(128) not null,
    AccountType	    varchar(50),
	primary key (AccountID)
);

INSERT INTO ACCOUNTS (AccountID, Name, Email, Username, Password, AccountType)
VALUES
(1,	'Bear',		'bear@gmail.com',	'bear01', 	'12345', 'RegRenter'),
(2,	'Turtle',	'turtle@gmail.com',	'turtle01', '12345', 'Landlord'),
(3,	'Fox',		'fox@gmail.com',	'fox01', 	'12345', 'Manager'),
(4,	'Cow',		'cow@gmail.com',	'cow01', 	'12345', 'RegRenter');


DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
	HouseID			int not null,
    LandlordID	    int not null,
    RenterID		int default null,
    State			varchar(20),
    Address			varchar(200),
	Type			varchar(25),
    BedroomNo		integer,
    BathroomNo		double,
    Furnished		varchar(25),
    CityQuad		char(2),
    Cost			double,
    DateListed	    date,
    DateRented		date default null,
    FeeDueDate		date,
	primary key (HouseID),
	foreign key (LandlordID) references ACCOUNTS(AccountID) ON UPDATE CASCADE,
    foreign key (RenterID) references ACCOUNTS(AccountID) ON UPDATE CASCADE
);

INSERT INTO PROPERTY (HouseID, LandlordID, RenterID, State, Address, Type, BedroomNo, BathroomNo, Furnished, CityQuad, Cost, DateListed, DateRented, FeeDueDate)
VALUES
(111,	1,	null,	'Active',	'242 Rainbow Road', 'Apartment',	3,	2.5, true, 'NW', 250000, '2021-12-01', null, '2022-01-30');

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

