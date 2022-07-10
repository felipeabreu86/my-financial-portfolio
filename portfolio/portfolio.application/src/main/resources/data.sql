create table IF NOT EXISTS users(
    username varchar(50) not null primary key,
    password varchar(200) not null,
    enabled boolean not null
);

create table IF NOT EXISTS authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES('usuario', '$2a$10$cRqfrdolNVFW6sAju0eNEOE0VC29aIyXwfsEsY2Fz2axy3MnH8ZGa', 1); -- senha: pass
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES('admin', '$2a$10$cRqfrdolNVFW6sAju0eNEOE0VC29aIyXwfsEsY2Fz2axy3MnH8ZGa', 1); -- senha: pass

INSERT INTO AUTHORITIES VALUES('usuario','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('admin','ROLE_ADMIN');