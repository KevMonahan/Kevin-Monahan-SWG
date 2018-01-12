drop database if exists SuperHeroSightings;

create database SuperHeroSightings;

use SuperHeroSightings;

create table hero (
`heroId` int(10) unsigned auto_increment not null,
`name` varchar(30) not null,
`description` varchar(100) not null,
`superPower` varchar(30) not null,
primary key (heroId)
);

create table organization (
`organizationId` int(10) unsigned not null auto_increment,
`name` varchar(30) not null,
`description` varchar(100) not null,
`address` varchar(100) null,
`state` varchar(20) null,
`zipCode` varchar(20) null,
primary key (organizationId)
);

create table location (
`locationId` int (10) unsigned not null auto_increment,
`name` varchar(50) not null,
`address` varchar(50) null,
`state` varchar(50) null,
`zipCode` varchar (20) null,
`description` varchar(100) not null,
`latitude` decimal (8,6) not null,
`longitude` decimal (8,5) not null,
primary key (locationId)
);

create table sighting (
`sightingId` int (10) unsigned not null auto_increment,
`location_locationId` int (10) unsigned not null,
`date` date not null,
primary key (sightingId),
foreign key (location_locationId) references location (locationId)
);

create table hero_sightings (
`hero_heroId` int (10) unsigned not null,
`sighting_sightingID` int(10) unsigned not null,
primary key(hero_heroId, sighting_sightingId),
foreign key(hero_heroId) references hero(heroId),
foreign key(sighting_sightingID) references sighting(sightingId)
);

create table Hero_Organization (
`hero_heroId` int(10) unsigned not null,
`organization_organizationId` int (10) unsigned not null,
primary key (hero_heroId, organization_organizationId),
foreign key (hero_heroId) references hero (heroId),
foreign key (organization_organizationId) references organization(organizationId)
)