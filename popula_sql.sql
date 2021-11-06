

-- insert into venda.cliente (idCliente, endereco, estado, cidade, telefone, email) values (1, 'Rua cogumelo', 'MS', 'Jacarepagua', '40028922', 'saosilvestre@gmail.com'),
-- (2, 'Rua samambaia', 'SP', 'Mundo Novo', '89224002', 'saosilvestre@facom.ufms');

-- insert into venda.pessoaj (cnpj, razaoSocial, nomeFantasia, idCliente) values ('12345678901234', 'Nome_razao_social', 'Nome_fantasia', 3);

-- insert into venda.pessoaf (cpf, nome, idCliente) values ('12345678900', 'Ricardo' ,1),
-- ('12345678911', 'Carlos Alberto', 2);

-- insert into venda.funcionario (cpf, nome, email) values ('98765432100', 'Joao das neves', 'teste@email.com'),
-- ('98765432122', 'Tyson james', 'teste@email.com');


-- select * from venda.pessoaj;

insert into venda.carro (placa, marca, modelo, cor, valor) values 
('RDU-714', 'Nissan       ', 'Versa  ', 'Vermelho', 435870.66),       
('GQA-683', 'Hyundai      ', 'HB20   ', 'Vermelho', 475193.29),       
('KRD-357', 'Kia          ', 'Stinger', 'Azul    ', 60852.93 ),  
('DWE-605', 'Hyundai      ', 'Creta  ', 'Amarelo ', 401395.21),       
('IPJ-007', 'BMW          ', 'Z4     ', 'Azul    ', 64639.47 ),  
('OBD-186', 'Honda        ', 'Civic  ', 'Azul    ', 441323.79),   
('OXN-886', 'Ford         ', 'Edge   ', 'Branco  ', 255314.86),   
('OAP-819', 'Chevrolet    ', 'Cruze  ', 'Azul    ', 256146.71),   
('RVH-539', 'Nissan       ', 'Versa  ', 'Amarelo ', 363706.79),       
('IBP-173', 'Toyota       ', 'Corolla', 'Vermelho', 60715.43 ),      
('EMO-192', 'Ford         ', 'Edge   ', 'Cinza   ', 439213.37),   
('PIJ-347', 'Volkswagen   ', 'Gol    ', 'Amarelo ', 156227.76),       
('RRI-613', 'Chevrolet    ', 'Cruze  ', 'Azul    ', 31770.68 ),  
('NZX-030', 'Nissan       ', 'Leaf   ', 'Branco  ', 46499.45 ),  
('HAI-299', 'Chevrolet    ', 'Camaro ', 'Amarelo ', 2931.68  ),     
('PPQ-277', 'Honda        ', 'City   ', 'Cinza   ', 422123.49),   
('KQW-005', 'BMW          ', 'X6     ', 'Amarelo ', 172530.55),       
('QNU-730', 'Mercedes-Benz', 'C 200  ', 'Branco  ', 499373.45),   
('XIS-520', 'Honda        ', 'City   ', 'Azul    ', 258965.63),   
('DHQ-636', 'Honda        ', 'City   ', 'Cinza   ', 296194.65),   
('ARF-478', 'BMW          ', 'Z4     ', 'Cinza   ', 313702.96),   
('OLD-214', 'Honda        ', 'Civic  ', 'Cinza   ', 187298.14),   
('KIY-999', 'Toyota       ', 'Prius  ', 'Amarelo ', 323108.23),       
('HRN-217', 'Mercedes-Benz', 'C 200  ', 'Cinza   ', 355381.28),   
('ULA-581', 'Mercedes-Benz', 'C 180  ', 'Branco  ', 497635.07),   
('TDU-026', 'Chevrolet    ', 'Onix   ', 'Amarelo ', 252883.57),       
('TAK-401', 'Chevrolet    ', 'Cruze  ', 'Amarelo ', 248016.02),       
('PMF-993', 'Toyota       ', 'Prius  ', 'Cinza   ', 409988.0 ),  
('MJZ-565', 'Honda        ', 'City   ', 'Vermelho', 487284.16),       
('YNY-190', 'Kia          ', 'Stinger', 'Preto   ', 375855.3 );

insert into venda.funcionario(cpf, nome, email) values 
('12345678911', 'Ricardo', 'ricardo@ufms.br'),
('12345678922', 'Igor', 'igor@ufms.br'),
('12345678933', 'Wellington', 'wellington@ufms.br');

-- select * from venda.funcionario;

insert into venda.cliente(idCliente, endereco, estado, cidade, telefone, email) values
(1, 'rua da facom', 'MS', 'Campo Grande', '1111-1111', 'teste1@gmail.com'),
(2, 'rua do RU', 'MS', 'Campo Grande', '2222-2222', 'teste2@gmail.com'),
(3, 'rua do multiuso', 'PR', 'Sao Miguel', '3333-3333', 'sr.wellington@gmail.com');

-- select * from venda.cliente;


insert into venda.pessoaf(cpf, nome, idCliente) values
('12345678911', 'Ricardo Cliente', 1),
('12345678922', 'Wellington Cliente', 3);

-- select * from venda.pessoaf;

insert into venda.pessoaj(cnpj, razaoSocial, nomeFantasia, idCliente) values
('1234567891111', 'Seguradora', 'SegurancaT', 2);

-- select * from venda.pessoaj;




-- select distinct marca from venda.carro;

-- drop table venda.carro;