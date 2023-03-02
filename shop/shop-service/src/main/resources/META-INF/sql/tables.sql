create table SHOP_ElectroEmployee (
	employeeId LONG not null,
	eTypeId LONG not null,
	primary key (employeeId, eTypeId)
);

create table SHOP_ElectroType (
	id_ LONG not null primary key,
	name VARCHAR(75) null
);

create table SHOP_Electronics (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	eTypeId LONG,
	price LONG,
	count INTEGER,
	isInStock BOOLEAN,
	isArchive BOOLEAN,
	description VARCHAR(75) null
);

create table SHOP_Employee (
	id_ LONG not null primary key,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	patronymic VARCHAR(75) null,
	birthDate DATE null,
	gender BOOLEAN,
	positionId LONG
);

create table SHOP_PositionType (
	id_ LONG not null primary key,
	name VARCHAR(75) null
);

create table SHOP_Purchase (
	id_ LONG not null primary key,
	purchaseDate DATE null,
	eTypeId LONG,
	employeeId LONG,
	electroId LONG
);

create table SHOP_PurchaseType (
	id_ LONG not null primary key,
	name VARCHAR(75) null
);