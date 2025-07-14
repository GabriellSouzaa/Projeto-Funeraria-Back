CREATE SEQUENCE seller_salles_id_seq;

CREATE TABLE seller_salles (
                               id BIGINT DEFAULT nextval('seller_salles_id_seq') PRIMARY KEY,
                               seller_id BIGINT,
                               qtd_venda BIGINT,
                               tipo_venda VARCHAR(255),
                               data_venda DATE,
                               CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES seller(id) ON DELETE CASCADE
);