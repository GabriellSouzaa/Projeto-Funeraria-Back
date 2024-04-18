ALTER TABLE users ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE cliente ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE endereco_cliente ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE funeral_plan ALTER COLUMN id INT AUTO_INCREMENT;

insert into users (email, senha) values ('souza@gmail.com', '1234');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Residencial São Cristovão', 'Luiza', 'Assis', '19820-000', 'Sp');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua das Flores', 'Centro', 'São Paulo', '01000-000', 'SP');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. dos Coqueiros', 'Praia de Iracema', 'Fortaleza', '60060-000', 'CE');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua dos Girassóis', 'Jardim Botânico', 'Curitiba', '80210-000', 'PR');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. das Palmeiras', 'Centro', 'Brasília', '70000-000', 'DF');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua dos Ipês', 'Centro', 'Porto Alegre', '90000-000', 'RS');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. das Mangueiras', 'Boa Viagem', 'Recife', '51020-000', 'PE');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua dos Pinheiros', 'Batel', 'Curitiba', '80420-000', 'PR');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. dos Jasmins', 'Parque das Nações', 'Manaus', '69000-000', 'AM');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua das Orquídeas', 'Jurunas', 'Belém', '66000-000', 'PA');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. das Rosas', 'Aldeota', 'Fortaleza', '60150-000', 'CE');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua dos Cravos', 'Centro', 'Porto', '40000-000', 'Portugal');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. das Acácias', 'Pituba', 'Salvador', '40140-000', 'BA');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Rua das Violetas', 'Candelária', 'Natal', '59000-000', 'RN');

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado)
values ('Av. das Tulipas', 'Centro', 'Florianópolis', '88000-000', 'SC');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Gabriel Souza', '2003-03-07', 'Assis', '27815852271', '29985158258', 'Caminhoneiro', 'Catolico', 'Casado', 18996829186, 1);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Maria Silva', '1995-09-15', 'São Paulo', '354879621', '48561247895', 'Enfermeira', 'Espírita', 'Solteira', '11987654321', 2);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Pedro Oliveira', '1988-05-20', 'Rio de Janeiro', '589632147', '12345678901', 'Advogado', 'Ateu', 'Divorciado', '21976543210', 3);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Ana Santos', '1977-12-10', 'Salvador', '785412369', '98765432101', 'Professora', 'Budista', 'Viúva', '71894563210', 4);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Lucas Pereira', '2000-02-28', 'Brasília', '963258741', '32145698701', 'Estudante', 'Cristão', 'Solteiro', '61987456321', 5);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Carla Costa', '1992-07-03', 'Porto Alegre', '147258369', '45612378901', 'Contadora', 'Judaísmo', 'Casada', '51879632514', 6);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Marcos Oliveira', '1985-10-18', 'Recife', '369852147', '78965412301', 'Engenheiro', 'Católico', 'Casado', '81965423789', 7);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Larissa Rodrigues', '1998-04-05', 'Curitiba', '258741369', '65478932101', 'Estudante', 'Agnóstico', 'Solteira', '41963258741', 8);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Gustavo Almeida', '1980-11-30', 'Manaus', '369852147', '14725836901', 'Médico', 'Ateu', 'Divorciado', '92987456321', 9);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Amanda Lima', '1990-01-25', 'Belém', '123456789', '98765432101', 'Psicóloga', 'Cristão', 'Solteira', '91987456325', 10);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Rafaela Sousa', '1982-08-12', 'Fortaleza', '963852741', '45678912301', 'Farmacêutica', 'Budista', 'Casada', '85987456321', 11);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Fernando Martins', '1975-03-17', 'Porto', '789456123', '32165498701', 'Empresário', 'Católico', 'Casado', '35198745632', 12);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Mariana Oliveira', '1993-06-08', 'Salvador', '852741963', '98732165401', 'Designer', 'Ateu', 'Solteira', '71895463210', 13);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('João Santos', '1987-09-23', 'Natal', '369852147', '65498732101', 'Analista de Sistemas', 'Cristão', 'Casado', '84963217548', 14);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone, endereco_id)
values ('Isabela Costa', '1996-02-14', 'Florianópolis', '147852369', '98765432101', 'Arquiteta', 'Judaísmo', 'Casada', '48963217548', 15);

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
