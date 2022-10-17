create table fixed_car (
id int primary key auto_increment,
bc_id int not null,
fixed bit not null,
CONSTRAINT car_service
    FOREIGN KEY (bc_id)
        REFERENCES `car_service`.`broken_car` (id));
