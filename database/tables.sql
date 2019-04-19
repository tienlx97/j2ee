SHOW DATABASES;
DROP DATABASE IF EXISTS J2EE;
CREATE DATABASE IF NOT EXISTS J2EE;
USE J2EE;

ALTER DATABASE j2ee CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS CATEGORIES;
CREATE TABLE CATEGORIES (
	id 				serial 			not null primary key,
    name 			varchar(254)	not null,
    parentId		integer			,
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null
) ;

DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
	id 				serial 			not null primary key,
    sku 			varchar(20) 	not null, 
    name			varchar(255)	not null,
    description 	text					,
    status			enum ('0','1','2') default '0',
    price			numeric 		default 0,
    discountPrice 	numeric 		default 0,
    quantity		integer			default 0,
    taxabled		bool			default false,
	image			varchar(100)	default 'url image',     
	detailImages	varchar(1000)	default 'url image',     
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null
);

DROP TABLE IF EXISTS PRODUCT_CATEGORIES;
CREATE TABLE PRODUCT_CATEGORIES (
	categoriesId 	integer 		not null primary key,
    productId 		integer			not null primary key,
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null
);

DROP TABLE IF EXISTS TAG;
CREATE TABLE TAG (
	id 				serial 			not null primary key, 
    name 			varchar(255)	not null,
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null
);

DROP TABLE IF EXISTS PRODUCT_TAG;
CREATE TABLE PRODUCT_TAG (
	tagId 			integer 			not null,
	productId		integer			not null, 		
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    primary key (tagId,productId)
);

DROP TABLE IF EXISTS CITY;
CREATE TABLE CITY (
	id				serial 			not null primary key,
    name			varchar(20)	not null
);

DROP TABLE IF EXISTS WARD;
CREATE TABLE WARD (
	id				serial 			not null primary key,
    name			varchar(20)	not null
);

DROP TABLE IF EXISTS DISTRICT;
CREATE TABLE DISTRICT (
	id				serial 			not null primary key,
    name			varchar(20)	not null
);

DROP TABLE IF EXISTS ADDRESS1;
CREATE TABLE ADDRESS1 (
	id 				integer 	not null primary key,
    cityId 			integer		not null FOREIGN KEY REFERENCES CITY(id), 
    districtId 		integer		not null foreign references DISTRICT(id), 
    wardId			integer		not null foreign references WARD(id), 
    address			varchar(100)	not null,
);

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER (
	id 				serial 			not null,
	email			varchar(255)	not null,
    username		varchar(20)		not null,
    password 		varchar(255)	not null,
    firstname		nvarchar(20)	not null,
    lastname		nvarchar(20)	not null,    
    dob				date			not null,
	image			varchar(100)	default 'url image',     
    gender			enum('0','1','2')	default '2',
    phone 			varchar(11)		not null,
    status			enum('0','1')	not null,
    
    addressId		integer			not null, /**/
    
	createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    primary key(id),
    foreign key (addressId) references ADDRESS(id)
);

DROP TABLE IF EXISTS CUTOMER_LOG;
CREATE TABLE CUSTOMER_LOG(
	id 				serial			not null,
	customerId 		serial 			not null,
    formName		enum('1','2','3') not null,
    action			nvarchar(100)	not null,
    
	createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
        
    primary key(id, customerId) 
);

DROP TABLE IF EXISTS ORDER_PRODUCT;
CREATE TABLE ORDER_PRODUCT(
	id 				serial			not null,
    customerId		serial			not null, /**/
    total			numeric			not null,
	isDelivery		bool			default false,
    deliveryAt		date			not null,
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    primary key(id),
    foreign key(customerId) references CUSTOMER(id)
);

DROP TABLE IF EXISTS ORDER_DETAIL;
CREATE TABLE ORDER_DETAIL(
	id 				serial			not null,
    orderId			serial			not null, /**/
    productId		numeric			not null, /**/
    quantity		int(10)			not null, 
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    primary key(id),
    foreign key(orderId) references ORDER_PRODUCT(id),
    foreign key(productId) references PRODUCT(id)
);

DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE EMPLOYEE(
	id 				serial			not null,
    username		varchar(15)		not null,
    password		varchar(100)	not null,
	firstname		varchar(20)	not null,
    lastname		varchar(20)	not null,    
    dob				date			not null,
	image			varchar(100)	default 'url image',     
    gender			enum('0','1','2')	default '2',
    phone 			varchar(11)		not null,
    status			enum('0','1')	not null,
    
    addressId		integer			not null, /**/
    
	createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    primary key(id),
    foreign key(addressId) references ADDRESS(id)
);

DROP TABLE IF EXISTS ROLES;
CREATE TABLE ROLES(
	id 				serial			not null,
    name			varchar(50)	    not null,
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    primary key (id)
);

DROP TABLE IF EXISTS EMPLOYEE_ROLES;
CREATE TABLE EMPLOYEE_ROLES(
	roleId 				serial			not null,
    employeeId			varchar(50)	    not null,
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
	primary key (roleId, employeeId)
);

