drop database if exists hotelSchema;

create database hotelSchema;

use hotelSchema;

create table Franchise (
FranchiseID smallint(10) unsigned not null auto_increment,
FranchiseName varchar(45) not null,
primary key (FranchiseID)
);

create table Hotel (
HotelID mediumint(10) unsigned not null auto_increment,
Franchise_FranchiseID smallint(10) unsigned not null,
primary key (HotelID),
foreign key (Franchise_FranchiseID)
references Franchise (FranchiseID)
);

CREATE TABLE RoomType
(
RoomTypeID SMALLINT(10) unsigned NOT NULL auto_increment,
RoomType VARCHAR(20) NOT NULL,
PRIMARY KEY(RoomTypeID)
);


CREATE TABLE Room (
RoomID INT(10) unsigned NOT NULL auto_increment,
RoomNumber SMALLINT(10) NOT NULL,
Floor SMALLINT(10) NOT NULL,
OccupancyLimit SMALLINT(10) NOT NULL,
RoomType_RoomTypeID SMALLINT(10) unsigned NOT NULL,
Hotel_HotelID mediumint(10) unsigned,
PRIMARY KEY(RoomID),
FOREIGN KEY(RoomType_RoomTypeID)
references RoomType(RoomTypeID),
FOREIGN KEY(Hotel_HotelID) 
references Hotel(HotelID)
);

CREATE TABLE RoomRate
(
RoomRateID BIGINT(20) NOT NULL auto_increment,
Rate Decimal(12,2) NOT NULL,
StartDate date NOT NULL,
EndDate date NOT NULL,
RoomType_RoomTypeID SMALLINT(10) unsigned NOT NULL,
PRIMARY KEY(RoomRateID),
FOREIGN KEY(RoomType_RoomTypeID) references RoomType(RoomTypeID)
);

create table Amenity (
AmenityID smallint(10) unsigned not null auto_increment,
AmenityName varchar(45),
primary key (AmenityID)
);

create table RoomAmenity (
Room_RoomID int(10) unsigned not null,
Amenity_AmenityID smallint(10) unsigned not null,
AmenityQuantity tinyint(5) unsigned not null,
foreign key (Room_RoomID)
references Room (RoomID),
foreign key (Amenity_AmenityID)
references Amenity (AmenityID)
);

create table AmenityRate (
AmenityRateID bigint(20) unsigned not null auto_increment,
Rate decimal(12,2) unsigned not null,
StartDate date not null,
EndDate date,
Amenity_AmenityID smallint(10) unsigned not null,
primary key (AmenityRateID),
foreign key (Amenity_AmenityID)
references Amenity (AmenityID)
);

create table Guest (
GuestID bigint(20) unsigned not null auto_increment,
FirstName varchar(45) not null,
LastName varchar(45) not null,
BirthDate date,
primary key (GuestID)
);

create table Email (
EmailID bigint(20) unsigned not null auto_increment,
EmailAddress varchar(100) not null,
Guest_GuestID bigint(20) unsigned,
primary key (EmailID),
foreign key (Guest_GuestID)
references Guest (GuestID)
);

create table PhoneType (
PhoneTypeID tinyint(10) unsigned not null auto_increment,
`Type` varchar(30) not null,
primary key (PhoneTypeID)
);

create table Phone (
PhoneID bigint(20) unsigned not null auto_increment,
PhoneType_PhoneTypeID tinyint(10) unsigned,
PhoneNumber varchar(20) not null,
Guest_GuestID bigint(20) unsigned,
primary key (PhoneID),
foreign key (Guest_GuestID)
references Guest (GuestID),
foreign key (PhoneType_PhoneTypeID)
references PhoneType (PhoneTypeID)
);


create table Address (
AddressID bigint(20) unsigned not null auto_increment,
AddressLine1 varchar(45) not null,
AddressLine2 varchar(45) null,
ZipCode tinyint(5) unsigned not null,
Guest_GuestID bigint(20) unsigned,
primary key (AddressID),
foreign key (Guest_GuestID)
references Guest (GuestID)
);

create table Reservation (
ReservationID bigint(20) unsigned not null auto_increment,
Guest_GuestID bigint(20) unsigned not null,
TotalBeforeTax decimal(12,2) unsigned,
Tax decimal(12,2) unsigned,
primary key (ReservationID),
foreign key (Guest_GuestID)
references Guest (GuestID)
);

create table RoomReservation (
RoomReservationID bigint(20) unsigned not null auto_increment,
Room_RoomID int(10) unsigned not null,
Reservation_ReservationID bigint(20) unsigned not null,
StartDate date not null,
EndDate date,
primary key (RoomReservationID), -- this bridge table uses a single primary key for simplicity since it is used as a foreign key in various tables
foreign key (Room_RoomID)
references Room (RoomID),
foreign key (Reservation_ReservationID)
references Reservation (ReservationID)
);

create table RoomReservationGuest (
Guest_GuestID bigint(20) unsigned not null,
RoomReservation_RoomReservationID bigint(20) unsigned not null,
primary key (Guest_GuestID, RoomReservation_RoomReservationID),
foreign key (Guest_GuestID)
references Guest (GuestID),
foreign key (RoomReservation_RoomReservationID)
references RoomReservation (RoomReservationID)
);

create table AddOn (
AddOnID smallint(20) unsigned not null auto_increment,
AddOnType varchar(30) not null,
primary key (AddOnID)
);

create table AddOnRate (
AddOnRateID bigint(20) unsigned not null auto_increment,
Rate decimal(12,2) unsigned not null,
StartDate date not null,
EndDate date,
AddOn_AddOnID smallint(20) unsigned not null,
primary key (AddOnRateID),
foreign key (AddOn_AddOnID)
references AddOn (AddOnID)
);

create table RoomReservationAddOn (
RoomReservationAddOnID bigint(20) unsigned not null auto_increment,  -- this bridge table does not have a composite key because it allows multiple add-ons of the same type for the same room
RoomReservation_RoomReservationID bigint(20) unsigned not null,
AddOn_AddOnID smallint(20) unsigned not null,
primary key (RoomReservationAddOnID),
foreign key (RoomReservation_RoomReservationID)
references RoomReservation (RoomReservationID),
foreign key (AddOn_AddOnID)
references AddOn (AddOnID)
);

create table Promo (
PromoID bigint(20) unsigned not null auto_increment,
PromoCode varchar(20) not null,
Description varchar(45) not null,
DollarDiscount smallint(10) unsigned,
PercentDiscount tinyint(10) unsigned,
StartDate date not null,
EndDate date,
RoomType_RoomTypeID smallint(10) unsigned,
Amenity_AmenityID smallint(10) unsigned,
AddOn_AddOnID smallint(20) unsigned,
primary key (PromoID),
foreign key (RoomType_RoomTypeID)
references RoomType (RoomTypeID),
foreign key (Amenity_AmenityID)
references Amenity (AmenityID),
foreign key (AddOn_AddOnID)
references AddOn (AddOnID)
);

create table ReservationDetail (
ReservationDetailID bigint(20) unsigned not null auto_increment,
Reservation_ReservationID bigint(20) unsigned not null,
RoomReservation_RoomReservationID bigint(20) unsigned not null,
RoomReservationAddOn_RoomReservationAddOnID bigint(20) unsigned,
Description varchar(45),
Rate decimal(12,2) unsigned not null,
primary key (ReservationDetailID),
foreign key (Reservation_ReservationID)
references Reservation (ReservationID),
foreign key (RoomReservation_RoomReservationID)
references RoomReservation (RoomReservationID),
foreign key (RoomReservationAddOn_RoomReservationAddOnID)
references RoomReservationAddOn (RoomReservationAddOnID)
);

create table ReservationPromo (
Promo_PromoID bigint(20) unsigned not null,
Reservation_ReservationID bigint(20) unsigned not null,
primary key (Promo_PromoID, Reservation_ReservationID),
foreign key (Promo_PromoID)
references Promo (PromoID),
foreign key (Reservation_ReservationID)
references Reservation (ReservationID)
);
