CREATE DATABASE bd_hotel;

USE bd_hotel;

CREATE TABLE setor(
cod_setor TINYINT UNIQUE NOT NULL AUTO_INCREMENT,
setor VARCHAR(25) UNIQUE NOT NULL,
salario INT NOT NULL,
PRIMARY KEY(cod_setor)
);

CREATE TABLE funcionario(
id_funcionario BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(15) NOT NULL, 
sobrenome VARCHAR(30) NOT NULL, 
login VARCHAR(20) UNIQUE NOT NULL,
senha VARCHAR(15) NOT NULL,
cpf VARCHAR(14) NOT NULL,
telefone VARCHAR(12) NOT NULL,
cod_setor TINYINT NOT NULL,
PRIMARY KEY(id_funcionario),
FOREIGN KEY(cod_setor) REFERENCES setor(cod_setor)
);

CREATE TABLE categoria(
id_categoria TINYINT UNIQUE NOT NULL AUTO_INCREMENT,
tipo VARCHAR(15) UNIQUE NOT NULL,
descricao VARCHAR(100),
valor_diaria DOUBLE NOT NULL,
PRIMARY KEY(id_categoria)
);

CREATE TABLE quarto(
id_quarto SMALLINT UNIQUE NOT NULL AUTO_INCREMENT,
disponivel TINYINT NOT NULL,
limpo TINYINT NOT NULL,
id_categoria TINYINT NOT NULL,
PRIMARY KEY(id_quarto),
FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE limpeza(
cod_limpeza BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
data_hora DATETIME NOT NULL,
descricao VARCHAR(100),
id_funcionario BIGINT NOT NULL,
id_quarto SMALLINT NOT NULL,
PRIMARY KEY(cod_limpeza),
FOREIGN KEY(id_funcionario) REFERENCES funcionario(id_funcionario),
FOREIGN KEY(id_quarto) REFERENCES quarto(id_quarto)
);

CREATE TABLE cliente(
id_cliente BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
nome VARCHAR(15) NOT NULL, 
sobrenome VARCHAR(30) NOT NULL, 
login VARCHAR(20) UNIQUE NOT NULL,
senha VARCHAR(15) NOT NULL,
cpf VARCHAR(14) NOT NULL,
telefone VARCHAR(12) NOT NULL,
PRIMARY KEY(id_cliente)
);

CREATE TABLE reserva(
id_reserva BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
data_entrada DATE NOT NULL, 
data_saida DATE NOT NULL,
id_quarto SMALLINT NOT NULL,
id_cliente BIGINT NOT NULL,
PRIMARY KEY(id_reserva),
FOREIGN KEY(id_quarto) REFERENCES quarto(id_quarto),
FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE pagamento(
cod_pagamento BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
valor_entrada DOUBLE,
valor_total DOUBLE NOT NULL,
PRIMARY KEY(cod_pagamento)
);

INSERT INTO categoria (id_categoria, tipo, descricao, valor_diaria) VALUES (null, 'teste', 'descricao teste', 300.00);
INSERT INTO quarto (id_quarto, disponivel, limpo, id_categoria) VALUES (null, true, true, 1);
