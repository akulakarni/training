create table person(
user_id number(4),
user_name varchar(10),
first_name varchar(10),
last_name varchar(10)
);

create table RoleMap(
user_id number(4),
role_id number(4)
);
drop table RoleMap;

create table UserRole(
role_id number(4),
role_name varchar(20)
);


alter table person add constraint  person_pk primary key(user_id);
alter table RoleMap add constraint role_ck primary key(user_id,role_id);
alter table UserRole add constraint userRole_pk primary key(role_id);
alter table RoleMap add constraint role_fk foreign key(user_id) references person(user_id);
alter table RoleMap add constraint userRole_fk foreign key(role_id) references UserRole(role_id); 
 


alter table UserRole drop constraint userRole_pk;
