create table course(
	id integer not null,
	name varchar (25) not null,
	author varchar (25) not null,
	primary key (id)
);

create table user_details(
	id integer not null,
	name varchar (25) not null,
	birthdate DATE not null,
	primary key (id)
);

create table post(
	id integer not null,
	description varchar (255) not null,
	user_id integer not null,
	primary key (id)
);

insert into user_details (ID, NAME, BIRTHDATE) values (1002, 'Khushi', PARSEDATETIME('19940624000000','yyyyMMddHHmmss'));

insert into post (id, description, user_id) values (1, 'my First Post', 1002);