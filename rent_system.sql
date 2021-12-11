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
('thomasr',		'12345',	'Thomas Ross',			'thomas.r@gmail.com',	 'REGISTEREDRENTER'),
('taylern',		'12345',	'Tayler Nielsen',		'tayler.n@gmail.com',	 'REGISTEREDRENTER'),
('maureenr',	'12345',	'Maureen Reed',			'maureen.r@gmail.com',	 'LANDLORD'),
('joannm',		'12345',	'Joann Merritt',		'joann.m@gmail.com',	 'LANDLORD'),
('lucash',		'12345',	'Lucas Hughes',			'lucas.h@gmail.com',	 'LANDLORD'),
('sophiav',		'12345',	'Sophia Villalobos',	'sohpia.v@gmail.com',	 'LANDLORD'),
('jamalc',		'12345',	'Jamal Cope',			'jamal.c@gmail.com',	 'LANDLORD'),
('aryaanr',		'12345',	'Aryaan Rhodes',		'aryaan.r@gmail.com',	 'MANGER');


DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
	HouseID					int not null auto_increment,
    LandlordUsername	    varchar(50) not null,
    State					varchar(20),
    Address					varchar(200),
	Type					varchar(25),
    BedroomNo				integer,
    BathroomNo				integer,
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
(1,		'jamalc',	'SUSPENDED',	'242 Rainbow Road', 	'House',		4,	4, false, 	'NW', 2050, 	'2021-12-01', null, 		'2022-01-30'),
(2,		'sophiav',	'SUSPENDED',	'39 Silver Street', 	'Condo',		2,	2, false, 	'NW', 1350, 	'2021-12-01', null, 		'2022-01-30'),
(4,		'lucash',	'SUSPENDED',	'64 Wallow Way', 		'Duplex',		3,	1, false, 	'NW', 1400, 	'2021-12-01', null, 		'2022-01-30'),
(5,		'joannm',	'CANCELLED',	'64 Wallow Way', 		'Duplex',		2,	2, false, 	'NW', 900, 		'2021-12-01', null, 		'2022-01-30'),
(6,		'maureenr',	'CANCELLED',	'21 Butter Blvd', 		'Basement',		2,	4, false, 	'NW', 650, 		'2021-12-01', null, 		'2022-01-30'),
(7,		'jamalc',	'RENTED',		'773 Rainbow Road', 	'Apartment',	2,	1, false, 	'NW', 1550, 	'2021-12-01', '2021-12-07', null),
(8,		'sophiav',	'RENTED',		'3304 Wallow Way', 		'Apartment',	2,	2, false, 	'NW', 1195, 	'2021-12-01', '2022-12-06', null),
(9,		'lucash',	'ACTIVE',		'463 Button Blvd', 		'Apartment',	1,	1, true, 	'NW', 790, 	  	'2021-12-01', null, 		'2022-01-30'),
(10,	'joannm',	'ACTIVE',		'362 Silver Street', 	'Loft',	        3,	1, true, 	'NE', 1250, 	'2021-12-01', null, 		'2022-01-30'),
(11,	'maureenr',	'ACTIVE',		'3626 Rocky Road', 		'Apartment',	2,	1, true, 	'SW', 1680,   	'2021-12-01', null, 		'2022-01-30'),
(12,	'jamalc',	'ACTIVE',		'463 Waffer Way', 		'Condo',		2,	1, true, 	'SE', 1400, 	'2021-12-01', null, 		'2022-01-30'),
(13,	'sophiav',	'ACTIVE',		'463 Butter Blvd', 		'Apartment',	2,	1, false, 	'NW', 1050,	  	'2021-12-01', null, 		'2022-01-30'),
(14,	'lucash',	'ACTIVE',		'63 Button Blvd', 		'House',		5,	4, false, 	'NW', 2995,		'2021-12-01', null, 		'2022-01-30'),
(15,	'joannm',	'ACTIVE',		'82 Silver Street', 	'House',		3,	2, false, 	'NE', 1600, 	'2021-12-01', null, 		'2022-01-30'),
(16,	'maureenr',	'ACTIVE',		'15 Rocky Road', 		'Basement',		1,	1, false, 	'SW', 600, 		'2021-12-01', null, 		'2022-01-30'),
(17,	'lucash',	'ACTIVE',		'63 Button Blvd', 		'Duplex',		4,	2, false, 	'NW', 1800,		'2021-12-01', null, 		'2022-01-30'),
(18,	'joannm',	'ACTIVE',		'82 Silver Street', 	'Duplex',		3,	1, false, 	'NE', 1250, 	'2021-10-08', null, 		'2021-12-07'),
(19,	'maureenr',	'ACTIVE',		'15 Rocky Road', 		'Basement',		2,	1, false, 	'SW', 750, 		'2021-10-08', null, 		'2021-12-07'),
(20,	'jamalc',	'ACTIVE',		'459 Button Blvd', 		'House',		3,	2, false, 	'SE', 1400, 	'2021-10-08', null,		    '2021-12-07');
	
DROP TABLE IF EXISTS MESSAGE;
CREATE TABLE MESSAGE (
	MessageID		int not null auto_increment,
	LandlordEmail	varchar(320),
    Message			varchar(1000),
	primary key (MessageID)
);

INSERT INTO MESSAGE (MessageID, LandlordEmail, Message)
VALUES
(1, 'jamal.c@gmail.com',	'Hello, I am interested in renting the condo at 459 Button Blvd SE. Please email me back at jaredf@yahoo.com'),
(2, 'jamal.c@gmail.com',	'Hey, I am interested in renting the condo at 459 Button Blvd SE. Please email me back at lucyj@yahoo.com');

DROP TABLE IF EXISTS SUBSCRIBE;
CREATE TABLE SUBSCRIBE (
	RenterEmail		        varchar(320),
    Type					varchar(25),
    BedroomNo				integer,
    BathroomNo				integer,
    Furnished				varchar(25),
    CityQuad				char(2),
    primary key(RenterEmail)
);

INSERT INTO SUBSCRIBE (RenterEmail, Type, BedroomNo, BathroomNo, Furnished, CityQuad)
VALUES
('thomas.r@gmail.com', 'Condo', 2, 1, false, 'NW');

