CREATE SEQUENCE health_plan_id_seq;

CREATE TABLE health_plan (
                             id BIGINT DEFAULT nextval('health_plan_id_seq') PRIMARY KEY,
                             descricao VARCHAR(255),
                             telefone VARCHAR(20),
                             valor FLOAT
);