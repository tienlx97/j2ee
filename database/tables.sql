SHOW DATABASES;
DROP DATABASE IF EXISTS J2EE;
CREATE DATABASE IF NOT EXISTS J2EE;
USE J2EE;

DROP TABLE IF EXISTS j2_category;
CREATE TABLE j2_category (
	cat_id 				varchar(64) 	not null ,
	cat_parent_id		varchar(64),
    cat_name 			varchar(30)	    not null,
	cat_description 	text			not null,
    
    cat_created_at		timestamp 		not null,
    cat_updated_at 		timestamp		not null,    
    constraint fk_category primary key(cat_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_product;
CREATE TABLE j2_product (
	prd_id 					varchar(64) 		not null,
--    prd_sku 				varchar(20) 		not null, 
    prd_name				varchar(100)		not null,
    prd_description 		text,
    prd_status				integer 			default 0,
    prd_price				decimal(18,4) 		default 0,
	prd_purchase_price		decimal(18,4) 		default 0,
    prd_quantity			integer				default 0,
--    prd_taxabled			bool				default false,
	prd_image				text, 
	prd_image_gallery		text,     
    
    prd_created_at		timestamp 		not null,
    prd_updated_at 		timestamp		not null,
    
    constraint fk_product primary key(prd_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_product_category;
CREATE TABLE j2_product_category (
	cat_id 				varchar(64) 	not null,
    prd_id 				varchar(64)		not null,

    prc_created_at		timestamp 		not null,
    prc_updated_at 		timestamp		not null,
    
    constraint fk_product_category primary key(cat_id,prd_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*
DROP TABLE IF EXISTS j2_tag;
CREATE TABLE j2_tag (
	tag_id 				bigint(20) 		not null auto_increment, 
    tag_name 			varchar(50)		not null,
    tag_created_at		timestamp 		not null,
    tag_updated_at 		timestamp		not null,
    
	constraint fk_tag primary key(tag_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_product_tag;
CREATE TABLE j2_product_tag (
	tag_id 				bigint(20) 		not null,
	prd_id				bigint(20)		not null, 		
    prt_created_at		timestamp 		not null,
    prt_updated_at 		timestamp		not null,
    constraint fk_product_tag primary key (tag_id,prd_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
*/

DROP TABLE IF EXISTS j2_city;
CREATE TABLE j2_city (
	cit_id				bigint(20) 	not null auto_increment,
    cit_name			varchar(20)	not null,
    constraint fk_city primary key(cit_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_ward;
CREATE TABLE j2_ward (
	war_id				bigint(20) 		not null auto_increment,
    war_name			varchar(20)		not null,
	constraint fk_ward primary key(war_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_district;
CREATE TABLE j2_district (
	dis_id				bigint(20) 		not null auto_increment,
    dis_name			varchar(20)		not null,
	constraint fk_district primary key(dis_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_address;
CREATE TABLE j2_address (
	add_id 				bigint(20) 		not null auto_increment,
    cit_id 				bigint(20)		not null, 
    dis_id 				bigint(20)		not null, 
    war_id				bigint(20)		not null, 
    add_address			varchar(100)	not null,
    
    constraint fk_address primary key(add_id),
    constraint fk_city_a FOREIGN KEY(cit_id) references j2_city(cit_id),
    constraint fk_district_a FOREIGN KEY(dis_id) references j2_district(dis_id),
	constraint fk_ward_a FOREIGN KEY(war_id) references j2_ward(war_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_customer;
CREATE TABLE j2_customer (
	cus_id 				bigint(20) 		not null auto_increment,
	cus_email			varchar(50)	not null,
    cus_username		varchar(15)		not null,
    cus_password 		varchar(255)	not null,
    cus_firstname		nvarchar(20)	not null,
    cus_lastname		nvarchar(20)	not null,    
    cus_dob				date			not null,
	cus_image			varchar(100)	default 'url image',     
    cus_gender			bit				default 0,
    cus_phone 			varchar(11)		not null,
    cus_status			integer			default 0,
    
    add_id				bigint(20)			not null, /**/
    
	cus_created_at		timestamp 		not null,
    cus_updated_at 		timestamp		not null,
    
    constraint fk_customer primary key(cus_id),
    constraint fk_address_c foreign key (add_id) references j2_address(add_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*DROP TABLE IF EXISTS CUTOMER_LOG;
CREATE TABLE CUSTOMER_LOG(
	id 				integer			not null auto_increment,
	customerId 		integer 			not null,
    formName		enum('1','2','3') not null,
    action			nvarchar(100)	not null,
    
	createdAt		timestamp 		not null,
    updatedAt 		timestamp		not null,
        
    constraint fk_customer_log primary key(id, customerId) 
); */

DROP TABLE IF EXISTS j2_order_product;
CREATE TABLE j2_order_product(
	orp_id 				bigint(20)		not null auto_increment,
    cus_id				bigint(20)		not null, /**/
    orp_total			decimal(18,4)	default 0,
	orp_is_delivery		bit				default 0,
    orp_delivery_at		timestamp		not null,
    
    orp_createdAt		timestamp 		not null,
    orp_updatedAt 		timestamp		not null,
    
    constraint fk_product primary key(orp_id),
    constraint fk_customer_op foreign key(cus_id) references j2_customer(cus_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_order_detail;
CREATE TABLE j2_order_detail(
	ord_id 				bigint(20)		not null auto_increment,
    orp_id				bigint(20)		not null, /**/
    prd_id				bigint(20)		not null, /**/
    ord_quantity		int(5)			default 1, 
    
    ord_created_at		timestamp 		not null,
    ord_updated_at 		timestamp		not null,
    
    constraint fk_order_detail primary key(ord_id),
    constraint fk_order_od foreign key(orp_id) references j2_order_product(orp_id),
    constraint fk_product_od foreign key(prd_id) references j2_product(prd_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_employee;
CREATE TABLE j2_employee(
	emp_id 				bigint(20)		not null auto_increment,
	add_id				bigint(20)		not null, /**/
    
    emp_username		varchar(15)		default null,
    emp_password		varchar(255)	default null,
	emp_firstname		varchar(20)		default null,
    emp_lastname		varchar(20)		default null,    
    emp_dob				date			default null,
	emp_image			varchar(100)	default 'url image',     
    emp_gender			bit				default 0,
    emp_phone 			varchar(11)		default null,
    emp_status			integer			default 0,
        
	emp_created_at		timestamp 		not null,
    emp_updated_at 		timestamp		not null,
    
    constraint fk_employee primary key(emp_id),
    constraint fk_address_e foreign key (add_id) references j2_address(add_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_role;
CREATE TABLE j2_role(
	rol_id 				bigint(20)		not null auto_increment,
    rol_name			varchar(50)	    not null,
    
    rol_created_at		timestamp 		not null,
    rol_updated_at 		timestamp		not null,
    
    constraint fk_role primary key (rol_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS j2_employee_role;
CREATE TABLE j2_employee_role(
	rol_id 				bigint(20)		not null,
    emp_id				bigint(20)	    not null,
    
    emr_created_at		timestamp 		not null,
    emr_updated_at 		timestamp		not null,
    
	constraint fk_employee_role primary key (rol_id, emp_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

