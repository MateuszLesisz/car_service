
create table broken_Car (
id int primary key auto_increment,
registrationNumber varchar(100) not null,
name varchar(100) not null,
color varchar(100) not null,
yearOfProduction int not null,
today date not null,
fixed bit not null
);