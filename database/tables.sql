SHOW DATABASES;
DROP DATABASE IF EXISTS J2EE;
CREATE DATABASE IF NOT EXISTS J2EE;
USE J2EE;

DROP TABLE IF EXISTS CATEGORIES;
CREATE TABLE CATEGORIES (
	id 				integer 		not null auto_increment ,
    name 			varchar(254)	not null,
    parentId		integer			,
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    constraint fk_category primary key(id)
) ;

DROP TABLE IF EXISTS PRODUCT;
CREATE TABLE PRODUCT (
	id 				integer 		not null auto_increment,
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
    updatedAt 		timestamp		not null,
    
    constraint fk_product primary key(id)
);

DROP TABLE IF EXISTS PRODUCT_CATEGORIES;
CREATE TABLE PRODUCT_CATEGORIES (
	categoriesId 	integer 		not null,
    productId 		integer			not null,
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    constraint fk_product_category primary key(categoriesId,productId)
);

DROP TABLE IF EXISTS TAG;
CREATE TABLE TAG (
	id 				integer 		not null auto_increment, 
    name 			varchar(255)	not null,
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
	constraint fk_tag primary key(id)
);

DROP TABLE IF EXISTS PRODUCT_TAG;
CREATE TABLE PRODUCT_TAG (
	tagId 			integer 		not null,
	productId		integer			not null, 		
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    constraint fk_product_tag primary key (tagId,productId)
);

DROP TABLE IF EXISTS CITY;
CREATE TABLE CITY (
	id			integer 	not null auto_increment,
    name			varchar(20)	not null,
    constraint fk_city primary key(id)
);

DROP TABLE IF EXISTS WARD;
CREATE TABLE WARD (
	id				integer 	not null auto_increment,
    name			varchar(20)	not null,
	constraint fk_ward primary key(id)
);

DROP TABLE IF EXISTS DISTRICT;
CREATE TABLE DISTRICT (
	id				integer 	not null auto_increment,
    name			varchar(20)	not null,
	constraint fk_district primary key(id)
);

DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE ADDRESS (
	id 				integer 	not null auto_increment,
    cityId 			integer		not null, 
    districtId 		integer		not null, 
    wardId			integer		not null, 
    address			varchar(100)	not null,
    
    constraint fk_address primary key(id),
    constraint fk_city_a FOREIGN KEY(cityId) references CITY(id),
    constraint fk_district_a FOREIGN KEY(districtId) references DISTRICT(id),
	constraint fk_ward_a FOREIGN KEY(wardId) references WARD(id)
);

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER (
	id 				integer 		not null auto_increment,
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
    
    constraint fk_customer primary key(id),
    constraint fk_address_c foreign key (addressId) references ADDRESS(id)
);

DROP TABLE IF EXISTS CUTOMER_LOG;
CREATE TABLE CUSTOMER_LOG(
	id 				integer			not null auto_increment,
	customerId 		integer 			not null,
    formName		enum('1','2','3') not null,
    action			nvarchar(100)	not null,
    
	createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
        
    constraint fk_customer_log primary key(id, customerId) 
);

DROP TABLE IF EXISTS ORDER_PRODUCT;
CREATE TABLE ORDER_PRODUCT(
	id 				integer			not null auto_increment,
    customerId		integer			not null, /**/
    total			numeric			not null,
	isDelivery		bool			default false,
    deliveryAt		date			not null,
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    constraint fk_product primary key(id),
    constraint fk_customer_op foreign key(customerId) references CUSTOMER(id)
);

DROP TABLE IF EXISTS ORDER_DETAIL;
CREATE TABLE ORDER_DETAIL(
	id 				integer			not null auto_increment,
    orderId			integer			not null, /**/
    productId		integer			not null, /**/
    quantity		int(10)			not null, 
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    constraint fk_order_detail primary key(id),
    constraint fk_order_od foreign key(orderId) references ORDER_PRODUCT(id),
    constraint fk_product_od foreign key(productId) references PRODUCT(id)
);

DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE EMPLOYEE(
	id 				integer			not null auto_increment,
    username		varchar(15)		not null,
    password		varchar(100)	not null,
	firstname		varchar(20)		not null,
    lastname		varchar(20)		not null,    
    dob				date			not null,
	image			varchar(100)	default 'url image',     
    gender			enum('0','1','2')	default '2',
    phone 			varchar(11)		not null,
    status			enum('0','1')	not null,
    
    addressId		integer			not null, /**/
    
	createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    constraint fk_employee primary key(id),
    constraint fk_address_e foreign key (addressId) references ADDRESS(id)
);

DROP TABLE IF EXISTS ROLES;
CREATE TABLE ROLES(
	id 				integer			not null auto_increment,
    name			varchar(50)	    not null,
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
    constraint fk_role primary key (id)
);

DROP TABLE IF EXISTS EMPLOYEE_ROLES;
CREATE TABLE EMPLOYEE_ROLES(
	roleId 				integer			not null,
    employeeId			varchar(50)	    not null,
    
    createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
    
	constraint fk_employee_role primary key (roleId, employeeId)
);

