create table confirmation
(
    confirmation_id     bigint primary key not null auto_increment,
    confirmation_status boolean,
    user_id             bigint,
    CONSTRAINT `fk_user_confirmation`
        FOREIGN KEY (user_id)
            REFERENCES `heroku_e4cf55d430b5608`.`user` (id)
);