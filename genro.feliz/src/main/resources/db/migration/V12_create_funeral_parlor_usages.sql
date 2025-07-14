CREATE SEQUENCE funeral_parlor_usages_id_seq;

CREATE TABLE funeral_parlor_usages (
                                       id BIGINT DEFAULT nextval('funeral_parlor_usages_id_seq') PRIMARY KEY,
                                       funeral_parlor_id BIGINT,
                                       uso VARCHAR(255),
                                       data_uso DATE,
                                       CONSTRAINT fk_funeral_parlor FOREIGN KEY (funeral_parlor_id) REFERENCES funeral_parlor(id) ON DELETE CASCADE
);