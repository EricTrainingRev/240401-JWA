drop table if exists users, planets, moons;

create table users(
	user_id serial primary key,
	user_username varchar(30) unique,
	user_password varchar(30)
);

create table planets(
	planet_id serial primary key,
	planet_name varchar(30) unique,
	owner_id int references users(user_id) on delete cascade
);

create table moons(
	moon_id serial primary key,
	moon_name varchar(30) unique,
	owner_id int references planets(planet_id) on delete cascade
);

insert into users values (default, 'login','user');

insert into planets values (default, 'getPlanet', 1);

insert into moons values (default, 'getMoon', 1);