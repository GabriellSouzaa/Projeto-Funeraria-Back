CREATE SEQUENCE seller_id_seq;

CREATE TABLE seller (
                        id BIGINT DEFAULT nextval('seller_id_seq') PRIMARY KEY,
                        nome VARCHAR(255),
                        cargo VARCHAR(255)
);