create table users_role
(
    user_id   bigint not null ,
    role_id  bigint not null,
    CONSTRAINT `fk_user_users_role`
        FOREIGN KEY (user_id)
            REFERENCES `heroku_e4cf55d430b5608`.`user` (id),
    CONSTRAINT `fk_role_users_role`
        FOREIGN KEY (role_id)
            REFERENCES `heroku_e4cf55d430b5608`.`role` (id)
);