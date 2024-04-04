ALTER TABLE users ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE cliente ALTER COLUMN id INT AUTO_INCREMENT;
ALTER TABLE endereco_cliente ALTER COLUMN id INT AUTO_INCREMENT;

insert into users (email, senha) values ('souza@gmail.com', '1234');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Gabriel Souza',  '2003-03-07', 'Assis', '27815852271', '29985158258', 'Caminhoneiro', 'Catolico', 'Casado', 18996829186);

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Maria Silva', '1995-09-15', 'São Paulo', '354879621', '48561247895', 'Enfermeira', 'Espírita', 'Solteira', '11987654321');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Pedro Oliveira', '1988-05-20', 'Rio de Janeiro', '589632147', '12345678901', 'Advogado', 'Ateu', 'Divorciado', '21976543210');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Ana Santos', '1977-12-10', 'Salvador', '785412369', '98765432101', 'Professora', 'Budista', 'Viúva', '71894563210');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Lucas Pereira', '2000-02-28', 'Brasília', '963258741', '32145698701', 'Estudante', 'Cristão', 'Solteiro', '61987456321');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Carla Costa', '1992-07-03', 'Porto Alegre', '147258369', '45612378901', 'Contadora', 'Judaísmo', 'Casada', '51879632514');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Marcos Oliveira', '1985-10-18', 'Recife', '369852147', '78965412301', 'Engenheiro', 'Católico', 'Casado', '81965423789');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Larissa Rodrigues', '1998-04-05', 'Curitiba', '258741369', '65478932101', 'Estudante', 'Agnóstico', 'Solteira', '41963258741');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Gustavo Almeida', '1980-11-30', 'Manaus', '369852147', '14725836901', 'Médico', 'Ateu', 'Divorciado', '92987456321');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Amanda Lima', '1990-01-25', 'Belém', '123456789', '98765432101', 'Psicóloga', 'Cristão', 'Solteira', '91987456325');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Rafaela Sousa', '1982-08-12', 'Fortaleza', '963852741', '45678912301', 'Farmacêutica', 'Budista', 'Casada', '85987456321');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Fernando Martins', '1975-03-17', 'Porto', '789456123', '32165498701', 'Empresário', 'Católico', 'Casado', '35198745632');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Mariana Oliveira', '1993-06-08', 'Salvador', '852741963', '98732165401', 'Designer', 'Ateu', 'Solteira', '71895463210');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('João Santos', '1987-09-23', 'Natal', '369852147', '65498732101', 'Analista de Sistemas', 'Cristão', 'Casado', '84963217548');

insert into cliente (nome, data_nascimento, cidade_nascimento, rg, cpf, profissao, religiao, estado_civil, telefone)
values ('Isabela Costa', '1996-02-14', 'Florianópolis', '147852369', '98765432101', 'Arquiteta', 'Judaísmo', 'Casada', '48963217548');


insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Residencial São Cristovão', 'Luiza', 'Assis', '19820-000', 'Sp', 1);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua das Flores', 'Centro', 'São Paulo', '01000-000', 'SP', 2);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. dos Coqueiros', 'Praia de Iracema', 'Fortaleza', '60060-000', 'CE', 3);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua dos Girassóis', 'Jardim Botânico', 'Curitiba', '80210-000', 'PR', 4);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. das Palmeiras', 'Centro', 'Brasília', '70000-000', 'DF', 5);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua dos Ipês', 'Centro', 'Porto Alegre', '90000-000', 'RS', 6);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. das Mangueiras', 'Boa Viagem', 'Recife', '51020-000', 'PE', 7);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua dos Pinheiros', 'Batel', 'Curitiba', '80420-000', 'PR', 8);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. dos Jasmins', 'Parque das Nações', 'Manaus', '69000-000', 'AM', 9);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua das Orquídeas', 'Jurunas', 'Belém', '66000-000', 'PA', 10);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. das Rosas', 'Aldeota', 'Fortaleza', '60150-000', 'CE', 11);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua dos Cravos', 'Centro', 'Porto', '40000-000', 'Portugal', 12);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. das Acácias', 'Pituba', 'Salvador', '40140-000', 'BA', 13);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Rua das Violetas', 'Candelária', 'Natal', '59000-000', 'RN', 14);

insert into endereco_cliente( endereco_residencial, bairro, cidade, cep, estado, cliente_id)
values ('Av. das Tulipas', 'Centro', 'Florianópolis', '88000-000', 'SC', 15);