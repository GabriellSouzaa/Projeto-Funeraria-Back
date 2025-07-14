CREATE SEQUENCE patient_death_id_seq;

CREATE TABLE patient_death (
                               id BIGINT DEFAULT nextval('patient_death_id_seq') PRIMARY KEY,
                               funeral_parlor_id BIGINT,
                               client_id BIGINT,
                               coffin_id BIGINT,
                               chemical_conservation VARCHAR(255),
                               description_death TEXT,
                               CONSTRAINT fk_funeral_parlor FOREIGN KEY (funeral_parlor_id) REFERENCES funeral_parlor(id) ON DELETE CASCADE,
                               CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES cliente(id) ON DELETE CASCADE,
                               CONSTRAINT fk_coffin FOREIGN KEY (coffin_id) REFERENCES coffin(id) ON DELETE CASCADE
);