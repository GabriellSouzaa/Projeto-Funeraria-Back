CREATE SEQUENCE coffin_id_seq;

CREATE TABLE coffin (
                        id BIGINT DEFAULT nextval('coffin_id_seq') PRIMARY KEY,
                        material VARCHAR(255),
                        cor VARCHAR(255),
                        comprimento VARCHAR(50),
                        modelo VARCHAR(255),
                        preco FLOAT
);