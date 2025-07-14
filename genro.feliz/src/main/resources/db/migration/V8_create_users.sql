CREATE SEQUENCE users_id_seq;

CREATE TABLE users (
                       id BIGINT DEFAULT nextval('users_id_seq') PRIMARY KEY,
                       login VARCHAR(255),
                       password VARCHAR(255),
                       role VARCHAR(50),
                       firstName VARCHAR(255),
                       lastName VARCHAR(255),
                       cpf VARCHAR(50),
                       dataNascimento VARCHAR(50)
);