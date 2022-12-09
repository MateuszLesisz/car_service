
create table broken_car
(
    id                 bigint primary key auto_increment,
    user_id            bigint not null,
    registration_number VARCHAR(100) not null,
    name               VARCHAR(100) not null,
    color              VARCHAR(100) not null,
    year_of_production int not null,
    date_of_add_car    date not null,
    is_fixed           boolean not null,
    fixed_date         date,
    CONSTRAINT `fk_user_broken_car`
        FOREIGN KEY (user_id)
            REFERENCES `heroku_e4cf55d430b5608`.`user` (id)
);