insert into j2_role(rol_name, rol_created_at, rol_updated_at) values ('admin', current_timestamp, current_timestamp);
insert into j2_role(rol_name, rol_created_at, rol_updated_at) values ('warehouse', current_timestamp, current_timestamp);


insert into j2_employee(add_id, emp_username, emp_password,emp_firstname, emp_lastname,emp_created_at,emp_updated_at) values(0,'tienlx97','Lexuantien1997','tien', 'le xuan',current_timestamp,current_timestamp);

select * from j2_employee;
SELECT * FROM j2_role;