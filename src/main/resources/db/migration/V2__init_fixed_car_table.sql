CREATE TABLE `fixed_car`
(
    id         BIGINT   NOT NULL AUTO_INCREMENT,
    fixed_date date     NOT NULL,
    car_id     BIGINT   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_car_fixed_car`
        FOREIGN KEY (car_id)
            REFERENCES `car_service`.`broken_car` (id)
);