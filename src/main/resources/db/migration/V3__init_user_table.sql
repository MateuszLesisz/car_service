
create table user
(
    id                 bigint primary key auto_increment,
    username           varchar(100) not null,
    email              varchar(100) not null,
    password           varchar(100) not null,
    phone_number       int not null,
    active             boolean not null,
    UNIQUE (email)
);