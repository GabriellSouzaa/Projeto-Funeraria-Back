CREATE SEQUENCE cliente_id_seq;

CREATE TABLE cliente (
                         id BIGINT DEFAULT nextval('cliente_id_seq') PRIMARY KEY,
                         nome VARCHAR(255),
                         data_nascimento DATE,
                         cidade_nascimento VARCHAR(255),
                         email VARCHAR(255),
                         rg VARCHAR(20),
                         cpf VARCHAR(14),
                         profissao VARCHAR(255),
                         religiao VARCHAR(255),
                         estado_civil VARCHAR(50),
                         ativo VARCHAR(1),
                         telefone BIGINT,
                         CONSTRAINT fk_funeral_plan FOREIGN KEY (id) REFERENCES funeral_plan(id) ON DELETE CASCADE
);