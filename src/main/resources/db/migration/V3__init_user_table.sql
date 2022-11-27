
create table user
(
    id                 bigint primary key auto_increment,
    name               varchar(100) not null,
    last_name          varchar(100) not null,
    email              varchar(100) not null,
    password           varchar(100) not null,
    city               varchar(100) not null,
    street             varchar(100) not null,
    house_number       int not null,
    zip_code           varchar(100) not null,
    UNIQUE (email)
);