ALTER TABLE users ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE cliente ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE funeral_plan ALTER COLUMN id INT AUTO_INCREMENT;

insert into users( login, password, role) values ('souza@gmail.com', 'teste', 'ADMIN');


INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Sergio Eduardo de Souza', '2003-03-07', 'Assis', '27815852271', '29985158258', 'Caminhoneiro', 'Catolico', 'Casado', 18996829186, 'vitordelantonia@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Maria Silva', '1995-09-15', 'São Paulo', '354879621', '48561247895', 'Enfermeira', 'Espírita', 'Solteira', '11987654321', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Pedro Oliveira', '1988-05-20', 'Rio de Janeiro', '589632147', '12345678901', 'Advogado', 'Ateu', 'Divorciado', '21976543210', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Ana Santos', '1977-12-10', 'Salvador', '785412369', '98765432101', 'Professora', 'Budista', 'Viúva', '71894563210', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Lucas Pereira', '2000-02-28', 'Brasília', '963258741', '32145698701', 'Estudante', 'Cristão', 'Solteiro', '61987456321', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Carla Costa', '1992-07-03', 'Porto Alegre', '147258369', '45612378901', 'Contadora', 'Judaísmo', 'Casada', '51879632514', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Marcos Oliveira', '1985-10-18', 'Recife', '369852147', '78965412301', 'Engenheiro', 'Católico', 'Casado', '81965423789', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Larissa Rodrigues', '1998-04-05', 'Curitiba', '258741369', '65478932101', 'Estudante', 'Agnóstico', 'Solteira', '41963258741', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Gustavo Almeida', '1980-11-30', 'Manaus', '369852147', '14725836901', 'Médico', 'Ateu', 'Divorciado', '92987456321', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Amanda Lima', '1990-01-25', 'Belém', '123456789', '98765432101', 'Psicóloga', 'Cristão', 'Solteira', '91987456325', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Rafaela Sousa', '1982-08-12', 'Fortaleza', '963852741', '45678912301', 'Farmacêutica', 'Budista', 'Casada', '85987456321', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Fernando Martins', '1975-03-17', 'Porto', '789456123', '32165498701', 'Empresário', 'Católico', 'Casado', '35198745632', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Mariana Oliveira', '1993-06-08', 'Salvador', '852741963', '98732165401', 'Designer', 'Ateu', 'Solteira', '71895463210', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('João Santos', '1987-09-23', 'Natal', '369852147', '65498732101', 'Analista de Sistemas', 'Cristão', 'Casado', '84963217548', 'matheusxmg2@gmail.com');

INSERT INTO cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, email)
VALUES ('Isabela Costa', '1996-02-14', 'Florianópolis', '147852369', '98765432101', 'Arquiteta', 'Judaísmo', 'Casada', '48963217548', 'matheusxmg2@gmail.com');

INSERT INTO funeral_plan (data_envio, valor, client_id, pago_esse_mes, data_pagamento, data_pagamento_efetuado) VALUES
                                                                                                               ('2024-04-18 10:00:00', 2300.75, 1, 'N', '2024-04-10', NULL),
                                                                                                               ('2024-04-18 12:30:00', 1800.50, 2, 'N', '2024-04-15', NULL),
                                                                                                               ('2024-04-18 15:45:00', 1950.00, 3, 'N', '2024-04-12', NULL),
                                                                                                               ('2024-04-18 18:20:00', 2100.30, 4, 'S', '2024-04-20', NULL),
                                                                                                               ('2024-04-18 20:00:00', 1600.20, 5, 'N', '2024-04-20', NULL),
                                                                                                               ('2024-04-19 08:30:00', 2200.00, 6, 'S', '2024-04-25', NULL),
                                                                                                               ('2024-04-19 10:15:00', 2400.75, 7, 'N', '2024-04-25', NULL),
                                                                                                               ('2024-04-19 12:00:00', 1500.85, 8, 'N', '2024-04-25', NULL),
                                                                                                               ('2024-04-19 14:50:00', 2600.90, 9, 'S', '2024-04-25', NULL),
                                                                                                               ('2024-04-19 16:35:00', 1750.40, 10, 'N', '2024-04-25', NULL),
                                                                                                               ('2024-04-19 18:45:00', 1900.55, 11, 'N', '2024-04-25', NULL),
                                                                                                               ('2024-04-20 08:00:00', 2050.70, 12, 'S', '2024-04-30', NULL),
                                                                                                               ('2024-04-20 09:25:00', 1650.80, 13, 'N', '2024-04-30', NULL),
                                                                                                               ('2024-04-20 11:40:00', 1450.60, 14, 'N', '2024-04-30', NULL),
                                                                                                               ('2024-04-20 14:30:00', 2500.00, 15, 'S', '2024-04-30', NULL);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Madeira', 'Marrom', '2m', 'Modelo A', 500.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Metal', 'Preto', '2.2m', 'Modelo B', 750.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Fibra de vidro', 'Branco', '1.8m', 'Modelo C', 650.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Madeira', 'Vermelho', '2.1m', 'Modelo D', 800.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Metal', 'Cinza', '2m', 'Modelo E', 900.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Madeira', 'Preto', '2.3m', 'Modelo F', 550.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Fibra de vidro', 'Azul', '2m', 'Modelo G', 700.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Metal', 'Verde', '2.2m', 'Modelo H', 650.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Madeira', 'Cinza', '2.1m', 'Modelo I', 600.00);

INSERT INTO coffin (material, cor, comprimento, modelo, preco)
VALUES ('Fibra de vidro', 'Preto', '2m', 'Modelo J', 750.00);

INSERT INTO funeral_parlor (descricao, valor)
VALUES ('Sala de Velório Principal', 1500.00);

INSERT INTO funeral_parlor (descricao, valor)
VALUES ('Sala de Velório Secundária', 1200.00);

INSERT INTO funeral_parlor (descricao, valor)
VALUES ('Sala de Velório VIP', 2000.00);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (1, 'Ana Souza', '2005-06-15', 100.50);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (1, 'João Souza', '2008-12-20', 150.00);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (2, 'Carlos Silva', '2010-05-30', 200.75);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (2, 'Marta Silva', '2011-07-15', 180.30);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (3, 'Lucas Oliveira', '2007-03-10', 250.00);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (3, 'Sofia Oliveira', '2013-01-25', 170.20);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (4, 'Juliana Santos', '2006-09-10', 300.00);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (5, 'Mariana Pereira', '2012-01-25', 220.15);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (5, 'Pedro Pereira', '2014-06-17', 190.40);

INSERT INTO beneficiary (client_id, nome, data_nascimento, adicional)
VALUES (6, 'Roberto Costa', '2007-04-15', 210.60);

INSERT INTO patient_death (funeral_parlor_id, client_id, coffin_id, chemical_conservation, description_death)
VALUES
    (1, 1, 1, 'S', 'Explosão de sobremesa'),
    (2, 2, 2, 'N', 'Escorregou em uma casca de banana'),
    (3, 3, 3, 'S', 'Ataque de risadas incontroláveis');

INSERT INTO seller (nome, cargo) VALUES ('José Almeida', 'Vendedor Ambulante');
INSERT INTO seller (nome, cargo) VALUES ('Carla Dias', 'Atendente');
INSERT INTO seller (nome, cargo) VALUES ('Ana Santos', 'Vendedor Ambulante');


INSERT INTO seller_salles(seller_id, qtd_venda, tipo_venda, data_venda) VALUES (1, 2, 'Caixão', '2024-06-01');
INSERT INTO seller_salles(seller_id, qtd_venda, tipo_venda, data_venda) VALUES (2, 2, 'Plano Funeral', '2024-06-02');
INSERT INTO seller_salles(seller_id, qtd_venda, tipo_venda, data_venda) VALUES (3, 2, 'Caixão', '2024-07-02');

INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (1, 1, '2024-05-01');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (2, 2, '2024-05-02');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (3, 3, '2024-05-03');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (3, 1, '2024-06-04');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (3, 2, '2024-05-05');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (1, 3, '2024-06-06');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (2, 4, '2024-05-07');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (3, 4, '2024-05-08');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (3, 5, '2024-05-09');
INSERT INTO coffin_salles (seller_id, coffin_id, data_venda) VALUES (3, 5, '2024-06-10');

INSERT INTO funeral_parlor_usages (funeral_parlor_id, uso, data_uso)
VALUES (1,'1 dia', '2024-06-06');

INSERT INTO funeral_parlor_usages (funeral_parlor_id, uso, data_uso)
VALUES (2,'2 dias', '2024-06-06');

INSERT INTO funeral_parlor_usages (funeral_parlor_id, uso, data_uso)
VALUES (3,'3 dias', '2024-06-06');

INSERT INTO health_plan (descricao, telefone, valor) VALUES ('Consulta Médica', '11987654321', 100.00);
INSERT INTO health_plan (descricao, telefone, valor) VALUES ('Plano Odontológico', '11976543210', 150.00);
INSERT INTO health_plan (descricao, telefone, valor) VALUES ('Consulta Psiquiátrica', '11965432109', 200.00);
INSERT INTO health_plan (descricao, telefone, valor) VALUES ('Exames Laboratoriais', '11954321098', 250.00);
INSERT INTO health_plan (descricao, telefone, valor) VALUES ('Terapia Física', '11943210987', 300.00);