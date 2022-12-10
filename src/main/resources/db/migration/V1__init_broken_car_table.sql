
create table broken_car
(
    id                 bigint primary key auto_increment,
    registration_number VARCHAR(100) not null,
    name               VARCHAR(100) not null,
    color              VARCHAR(100) not null,
    year_of_production int not null,
    date_of_add_car    date not null,
    is_fixed           boolean not null,
    fixed_date         date
);