CREATE TABLE `fixed_car`
(
    id         BIGINT   NOT NULL AUTO_INCREMENT,
    fixed_date date     NOT NULL,
    car_id     BIGINT   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_car_fixed_car`
        FOREIGN KEY (car_id)
            REFERENCES `heroku_e4cf55d430b5608`.`broken_car` (id)
);