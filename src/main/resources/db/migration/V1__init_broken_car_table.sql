
create table car
(
    id                 bigint primary key auto_increment,
    registrationNumber varchar(100) not null,
    name               varchar(100) not null,
    color              varchar(100) not null,
    yearOfProduction   int          not null,
    dateOfAddCar       datetime     not null,
    isFixed            bit          not null,
    fixedDate          datetime
);