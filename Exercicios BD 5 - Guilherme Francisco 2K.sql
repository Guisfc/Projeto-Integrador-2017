CREATE DATABASE bd_loja;

USE bd_loja;

CREATE TABLE categoria(
cod_cat BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
descricao_cat VARCHAR(300) NOT NULL,
PRIMARY KEY(cod_cat)
);

CREATE TABLE marca(
cod_mar BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
nome_mar VARCHAR(30) NOT NULL,
PRIMARY KEY(cod_mar)
);

CREATE TABLE unidade(
cod_uni BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
descricao_uni VARCHAR(300) NOT NULL,
PRIMARY KEY(cod_uni)
);

CREATE TABLE produto(
cod_prod BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
descricao_prod VARCHAR(300) NOT NULL,
preco_custo FLOAT NOT NULL,
preco_venda FLOAT NOT NULL,
qtde_estoque SMALLINT NOT NULL,
qtde_minima TINYINT NOT NULL,
cod_cat BIGINT NOT NULL,
cod_mar BIGINT NOT NULL,
cod_uni BIGINT NOT NULL,
PRIMARY KEY(cod_prod),
FOREIGN KEY(cod_cat) REFERENCES categoria(cod_cat),
FOREIGN KEY(cod_mar) REFERENCES marca(cod_mar),
FOREIGN KEY(cod_uni) REFERENCES unidade(cod_uni)
);

INSERT INTO categoria VALUES(null,'Tenis de Mesa'),(null,'Tenis'),(null,'Futebol'),
(null,'Natacao'),(null,'Basquete'),(null,'Paddle');

INSERT INTO marca VALUES(null,'Butterfly'),(null,'Spalding'),(null,'Adidas'),
(null,'Nike'),(null,'Speedy'),(null,'Wilson');

INSERT INTO unidade VALUES(null,'Par'),(null,'Gramas'),(null,'Caixa'),
(null,'Cartela'),(null,'Duzia'),(null,'Unidade');

INSERT INTO produto VALUES(null, 'Camisa Internacional', 100, 179.90, 50, 10, 3, 4, 6);
INSERT INTO produto VALUES(null, 'Bola de Tenis de Mesa 40mm', 8.59, 15.50, 100, 5, 1, 1, 5);
INSERT INTO produto VALUES(null, 'Camisa Chelsea', 100, 169.90, 2, 4, 3, 3, 6);
INSERT INTO produto VALUES(null, 'Raquete de Tenis', 250, 420, 5, 3, 2, 6, 6);
INSERT INTO produto VALUES(null, 'Chuteira de Futebol', 89.90, 159.50, 20, 5, 3, 4, 1);
INSERT INTO produto VALUES(null, 'Bola de Basquete', 59.90, 129.90, 15, 10, 5, 2, 6);
INSERT INTO produto VALUES(null, 'Oculos de Natacao', 29.90, 59.90, 3, 5, 4, 5, 6);

ALTER TABLE produto CHANGE descricao_prod desc_prod VARCHAR(300) NOT NULL;

ALTER TABLE unidade ADD sigla_uni VARCHAR(5);

ALTER TABLE unidade DROP sigla_uni;

UPDATE produto SET preco_venda = (preco_venda+((preco_venda*5)/100));

UPDATE produto SET preco_venda = (preco_venda-((preco_venda*25)/100));

DELETE FROM produto;
#      OU       #
TRUNCATE produto;