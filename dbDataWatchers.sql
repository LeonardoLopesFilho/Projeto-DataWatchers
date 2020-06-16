--TABELA DADOS
DROP TABLE IF EXISTS Dados
CREATE TABLE Dados(
    NomePessoa VARCHAR(30),
    Valor INT,
    Comprado INT,
    DadosPessoa VARCHAR(30),
    Site VARCHAR(30)
);
--INSERÇÃO DE DADOS NA TABELA
INSERT INTO Dados (NomePessoa,Valor,Comprado,DadosPessoa,Site) 
VALUES ('Leonardo',300,0,'Compra muitos jogos fps','www.facebook.com.br');
INSERT INTO Dados (NomePessoa,Valor,Comprado,DadosPessoa,Site) 
VALUES ('Ismael',1000,0,'Quer se casar com  a namorada','www.PrataFina.com.br');
INSERT INTO Dados (NomePessoa,Valor,Comprado,DadosPessoa,Site) 
VALUES ('Marlon',1300,0,'Prestes a Comprar Moto Nova','www.HarleyDavison.com.br');
INSERT INTO Dados (NomePessoa,Valor,Comprado,DadosPessoa,Site) 
VALUES ('Felipe',2000,0,'Estuda muito PHP','www.Udemy.com.br');
INSERT INTO Dados (NomePessoa,Valor,Comprado,DadosPessoa,Site) 
VALUES ('Gabriel',2400,0,'Traiu uns amigos','www.Tinder.com.br');
--UPDATE Dados SET Comprado = 0 WHERE NomePessoa = 'Leonardo';


--TABELA ECONOMIA
DROP TABLE IF EXISTS Economia
CREATE TABLE Economia(
    moedas INT
);
--INSERÇÃO DE DADOS NA TABELA
INSERT INTO Economia (moedas) VALUES(0);
--UPDATE Economia SET moedas =0;

--TABELA ENIGMAS
DROP TABLE IF EXISTS Enigmas
CREATE TABLE Enigmas(
    id_enigma INT,
    enigma VARCHAR(100),
    comprado INT,
    ajuda VARCHAR(100),
    resposta VARCHAR(50)
);
--INSERÇÃO DE DADOS NA TABELA
INSERT INTO Enigmas(id_enigma,enigma,comprado,ajuda,resposta) 
VALUES (1,'B dhr zngnzbf gbqbf bf qvnf znf aãb fbzbf cerfbf? ',0,'ROT13','fome');
INSERT INTO Enigmas(id_enigma,enigma,comprado,ajuda,resposta) 
VALUES (2,'vqnqr qr grfyn nb snyrpre',0,'ROT13','86');
INSERT INTO Enigmas(id_enigma,enigma,comprado,ajuda,resposta) 
VALUES (3,'N ivqn ...... Wbnb 3:16 ',0,'ROT13','eterna');
INSERT INTO Enigmas(id_enigma,enigma,comprado,ajuda,resposta) 
VALUES (4,'Gur ..... vf gur fgebatrfg zhfpyr ',0,'ROT13','heart');
INSERT INTO Enigmas(id_enigma,enigma,comprado,ajuda,resposta) 
VALUES (5,'Dhr qryrvgr qr ntbavn inzbf vasevatve?',0,'ROT13','thresh');
--UPDATE Enigmas SET comprado = 0;

--TABELA AJUDA
DROP TABLE IF EXISTS ajuda
CREATE TABLE ajuda(
    completos INT
);
--INSERÇÃO DE DADOS NA TABELA
INSERT INTO ajuda (completos) VALUES (0);
--UPDATE ajuda SET completos = 0;

--TABELA LOGIN
DROP TABLE IF EXISTS Login
CREATE TABLE Login(
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(30),
    senha VARCHAR(100),
    logado INT,
    economia INT
);
--INSERÇÃO DE DADOS NA TABELA
INSERT INTO Login (usuario,senha) VALUES('usuario','senha1'); 