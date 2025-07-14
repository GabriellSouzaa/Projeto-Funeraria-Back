CREATE SEQUENCE coffin_sales_id_seq;

CREATE TABLE coffin_salles (
                               id BIGINT DEFAULT nextval('coffin_sales_id_seq') PRIMARY KEY,
                               seller_id BIGINT,
                               coffin_id BIGINT,
                               data_venda DATE,
                               client_id BIGINT,
                               CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES seller(id) ON DELETE CASCADE,
                               CONSTRAINT fk_coffin FOREIGN KEY (coffin_id) REFERENCES coffin(id) ON DELETE CASCADE,
                               CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES cliente(id) ON DELETE CASCADE
);