CREATE SEQUENCE funeral_plan_id_seq;

CREATE TABLE funeral_plan (
                              id BIGINT DEFAULT nextval('funeral_plan_id_seq') PRIMARY KEY,
                              data_envio TIMESTAMP,
                              valor FLOAT,
                              pago_esse_mes VARCHAR(1),
                              data_pagamento DATE,
                              data_pagamento_efetuado DATE,
                              client_id BIGINT,
                              CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES cliente(id) ON DELETE CASCADE
);