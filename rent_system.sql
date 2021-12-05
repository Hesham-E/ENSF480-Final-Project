DROP DATABASE IF EXISTS RENT_SYSTEM;
CREATE DATABASE RENT_SYSTEM; 
USE RENT_SYSTEM;

DROP TABLE IF EXISTS ACCOUNTS;
CREATE TABLE ACCOUNTS (
	AccountID		char(9) not null,
	Name			varchar(25) not null,
	Email			varchar(320) not null,
    Username		varchar(50) not null,
    Password		varchar(128) not null,
    AccountType	    varchar(50),
	primary key (AccountID)
);

INSERT INTO ACCOUNTS (AccountID, Name, Email, Username, Password, AccountType)
VALUES
('A00000001',	'Bear',		'bear@gmail.com',	'bear01', 	'12345', 'RegRenter'),
('A00000002',	'Turtle',	'turtle@gmail.com',	'turtle01', '12345', 'Landlord'),
('A00000003',	'Fox',		'fox@gmail.com',	'fox01', 	'12345', 'Manager'),
('A00000004',	'Cow',		'cow@gmail.com',	'cow01', 	'12345', 'RegRenter');


DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
	HouseID			int not null,
    LandlordID	    varchar(9) not null,
    RenterID		varchar(9) default null,
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
(111,	'A00000002',	null,	'Active',	'242 Rainbow Road', 'Apartment',	3,	2.5, true, 'NW', 250000, '2021-12-01', null, '2022-01-30');

DROP TABLE IF EXISTS MESSAGE;
CREATE TABLE MESSAGE (
	MessageID		char(9) not null,
	RenterID		char(9),
	LandlordID		char(9),
    Message			varchar(1000),
    DateSent	    date,
	primary key (MessageID)
);

INSERT INTO MESSAGE (MessageID, RenterID, LandlordID, Message, DateSent)
VALUES
('M00000001',	'A00000001',	'A00000002',	'Hello, I am interested in renting your property.', 	'2021-12-03');

