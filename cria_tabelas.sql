-- drop table venda.carro, venda.cliente, venda.funcionario, venda.pessoaf, venda.pessoaj, venda.testdrive, venda.gerente, venda.telefone;


-- create database venda;
-- create schema venda;

CREATE TABLE venda.carro(
	placa varchar(7) NOT NULL,-- PRIMARY KEY,
	marca varchar(15),
	modelo varchar(15),
	cor varchar(10),
    valor double
);

-- select * FROM venda.carro;

-- Atendente eh parte de funcionario por isso nao 
-- tem tabela de atendente ja que nao tem atributo 
-- a mais
CREATE TABLE venda.funcionario(
	cpf varchar(11) NOT NULL,-- PRIMARY KEY,
	nome varchar(30) NOT NULL,
	email varchar(30)
);

-- select * FROM venda.funcionario;


CREATE TABLE venda.telefone(
	cpfFunc varchar(11) NOT NULL,-- PRIMARY KEY,
	tel varchar(11) 
);

-- select * FROM venda.telefone;

CREATE TABLE venda.gerente(
	idGerente INTEGER NOT NULL,-- PRIMARY KEY,
	cpfGer VARCHAR(11) NOT NULL
);

-- select * FROM venda.gerente;

CREATE TABLE venda.cliente (
	idCliente INTEGER NOT NULL,-- PRIMARY KEY,
	endereco VARCHAR(20),
	estado VARCHAR(15),
	cidade VARCHAR(15),
	telefone VARCHAR(11),
	email VARCHAR(30)
);


CREATE TABLE venda.pessoaf(
	cpf VARCHAR(11) NOT NULL ,--PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	idCliente INTEGER NOT NULL
);


CREATE TABLE venda.pessoaj(
	cnpj VARCHAR(14) NOT NULL,-- PRIMARY KEY,
	razaoSocial VARCHAR(20),
	nomeFantasia VARCHAR(20) NOT NULL,
	idCliente INTEGER NOT NULL
);


CREATE TABLE venda.testdrive(
	placaCarro VARCHAR(7) NOT NULL,
	dataInicio DATE,
	dataDoTermino DATE,
	estadoInicioDoCarro VARCHAR(15),
	estadoCarroVolta VARCHAR(15)
);


CREATE TABLE venda.venda(
	idVenda INTEGER PRIMARY KEY,
	idFuncionario VARCHAR(11), -- cpf do func
	carroDaVenda VARCHAR(7),   -- placa do carro
	idCliente INTEGER,	   	   -- idCliente da tabela cliente
	dataVenda date, 
	situacao VARCHAR(12),
    
);


CREATE TABLE venda.pagamento(
	idVenda INTEGER,
	valor FLOAT,
	tipoPagamento INTEGER,
	desconto FLOAT
);


-- Colocando chave primaria em placa para a tabela carro
ALTER TABLE venda.carro ADD CONSTRAINT
placa_pk PRIMARY KEY(placa);

-- FUNCIONARIOS
-- Colocando chave primaria em cpf da tabela funcionario
ALTER TABLE venda.funcionario ADD CONSTRAINT
cpf_pk PRIMARY KEY(cpf);

-- Colocando atributo idgerente como chave primaria e
-- referenciando cpfger para o atributo cpf na tabela funcionario
ALTER TABLE venda.gerente ADD CONSTRAINT
idgerente_pk PRIMARY KEY(idGerente);

ALTER TABLE venda.gerente ADD CONSTRAINT
cpfger_fk FOREIGN KEY (cpfGer) REFERENCES venda.funcionario(cpf) ON UPDATE CASCADE;

-- Colocando chave secundaria da tabela telefone referenciando para cpf 
-- na tabela do funcionario
ALTER TABLE venda.telefone ADD CONSTRAINT
cpfFunc_fk FOREIGN KEY(cpfFunc) REFERENCES venda.funcionario(cpf) ON UPDATE CASCADE;



-- CLIENTES
-- Chave primaria da tabela eh idcliente
ALTER TABLE venda.cliente ADD CONSTRAINT
idCliente_pk PRIMARY KEY(idCliente);

-- Referenciando idcliente de pessoaf para
-- idcliente da tabela cliente
ALTER TABLE venda.pessoaf ADD CONSTRAINT
idClientef_fk FOREIGN KEY(idCliente) REFERENCES venda.cliente(idCliente);

-- Referenciando idcliente de pessoaj para
-- idCliente da tabela cliente
ALTER TABLE venda.pessoaj ADD CONSTRAINT
idClientej_fk FOREIGN KEY(idCliente) REFERENCES venda.cliente(idCliente);


-- TESTE-DRIVE
ALTER TABLE venda.testdrive ADD CONSTRAINT
placaCarro_fk FOREIGN KEY(placaCarro) REFERENCES venda.carro(placa);

-- VENDA
-- Atribuindo chave primaria para atributo idVenda
-- e colocando as chaves secundarias
ALTER TABLE venda.venda ADD CONSTRAINT
idVenda_pk PRIMARY KEY(idVenda);

ALTER TABLE venda.venda ADD CONSTRAINT
idFuncionario_fk FOREIGN KEY(idFuncionario) REFERENCES venda.funcionario(cpf) ON UPDATE CASCADE;

ALTER TABLE venda.venda ADD CONSTRAINT
carroDaVenda_fk FOREIGN KEY(carroDaVenda) REFERENCES venda.carro(placa) ON UPDATE CASCADE;

ALTER TABLE venda.venda ADD CONSTRAINT
idCliente_fk FOREIGN KEY(idCliente) REFERENCES venda.cliente(idCliente) ON UPDATE CASCADE;


-- PAGAMENTO
-- Colocando referencia de chave secundaria entre atributo 
-- idVenda de pagamento e idVenda da tabela venda
ALTER TABLE venda.pagamento ADD CONSTRAINT
idVenda_fk FOREIGN KEY(idVenda) REFERENCES venda.venda(idVenda);