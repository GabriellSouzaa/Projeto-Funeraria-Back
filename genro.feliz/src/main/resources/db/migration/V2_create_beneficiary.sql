CREATE SEQUENCE beneficiary_id_seq;

CREATE TABLE beneficiary (
                             id BIGINT DEFAULT nextval('beneficiary_id_seq') PRIMARY KEY,
                             client_id BIGINT,
                             nome VARCHAR(255),
                             data_nascimento DATE,
                             adicional FLOAT,
                             ativo VARCHAR(1),
                             email VARCHAR(255),
                             CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES cliente(id) ON DELETE CASCADE
);