CREATE TABLE IF NOT EXISTS users
(
    id       bigserial PRIMARY KEY,
    username varchar(50)  NOT NULL,
    password varchar(80) NOT NULL,
    enabled  boolean      NOT NULL
);
INSERT INTO users(username, password, enabled)
VALUES ('admin', '$2a$12$N15KWQWuA4jy6IbxZTYAEOPQfZh6CWN2Op0rqpIEtVUeleBCAMW2y', true),
       ('user1', '$2a$12$N15KWQWuA4jy6IbxZTYAEOPQfZh6CWN2Op0rqpIEtVUeleBCAMW2y', true),
       ('user2', '$2a$12$N15KWQWuA4jy6IbxZTYAEOPQfZh6CWN2Op0rqpIEtVUeleBCAMW2y', true);

CREATE TABLE IF NOT EXISTS roles
(
    id      bigserial PRIMARY KEY,
    name    varchar(50) NOT NULL,
    enabled boolean     NOT NULL
);
INSERT INTO roles(name, enabled)
VALUES ('ROLE_ADMIN', true),
       ('ROLE_USER', true);

CREATE TABLE IF NOT EXISTS authorities
(
    user_id bigint NOT NULL REFERENCES users (id),
    role_id bigint NOT NULL REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);
INSERT INTO authorities
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 2);
