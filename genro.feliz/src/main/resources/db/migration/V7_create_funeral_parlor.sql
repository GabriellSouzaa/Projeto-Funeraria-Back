CREATE SEQUENCE funeral_parlor_id_seq;

CREATE TABLE funeral_parlor (
                                id BIGINT DEFAULT nextval('funeral_parlor_id_seq') PRIMARY KEY,
                                descricao VARCHAR(255),
                                valor FLOAT
);