CREATE DATABASE IFesta;
USE IFesta;

CREATE TABLE Usuario(
	matricula VARCHAR(16) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(17) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(20) NOT NULL
);

CREATE TABLE Evento_Academico(
	codEvento INT PRIMARY KEY AUTO_INCREMENT,
	organizador VARCHAR(16) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    dt DATE NOT NULL,
    horario TIME NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    lugar VARCHAR(20) NOT NULL, 
    situacao VARCHAR(20) NOT NULL,
    cargaHoraria INT NOT NULL,
	FOREIGN KEY (organizador) REFERENCES Usuario (matricula) ON DELETE CASCADE
);

CREATE TABLE Evento_Cultural(
	codEvento INT PRIMARY KEY AUTO_INCREMENT,
	organizador VARCHAR(16) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    dt DATE NOT NULL, 
    horario TIME NOT NULL, 
    tipo VARCHAR(20) NOT NULL, 
    lugar VARCHAR(20) NOT NULL,
    situacao VARCHAR(20) NOT NULL,
    apresentacao VARCHAR(50) NOT NULL,
	FOREIGN KEY (organizador) REFERENCES Usuario (matricula) ON DELETE CASCADE
);

CREATE TABLE Evento_Social(
	codEvento INT PRIMARY KEY AUTO_INCREMENT,
	organizador VARCHAR(16) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    dt DATE NOT NULL,
    horario TIME NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    lugar VARCHAR(20)NOT NULL, 
    situacao VARCHAR(20)NOT NULL,
    celebracao VARCHAR(20) NOT NULL,
	FOREIGN KEY (organizador) REFERENCES Usuario (matricula) ON DELETE CASCADE
);

CREATE TABLE Lembrete_Academico(
	codLembrete INT PRIMARY KEY AUTO_INCREMENT,
	codEvento INT NOT NULL,
	usuario VARCHAR(16) NOT NULL,
	nota VARCHAR(300) NOT NULL,
    FOREIGN KEY (codEvento) REFERENCES Evento_Academico (codEvento) ON DELETE CASCADE,
	FOREIGN KEY (usuario) REFERENCES Usuario (matricula) ON DELETE CASCADE
);

CREATE TABLE Lembrete_Cultural(
	codLembrete INT PRIMARY KEY AUTO_INCREMENT,
	codEvento INT NOT NULL,
	usuario VARCHAR(16) NOT NULL,
    nota VARCHAR(300) NOT NULL,
    FOREIGN KEY (codEvento) REFERENCES Evento_Cultural (codEvento) ON DELETE CASCADE,
	FOREIGN KEY (usuario) REFERENCES Usuario (matricula) ON DELETE CASCADE
);

CREATE TABLE Lembrete_Social(
	codLembrete INT PRIMARY KEY AUTO_INCREMENT,
	codEvento INT NOT NULL,
	usuario VARCHAR(16) NOT NULL,
	nota VARCHAR(300) NOT NULL,
    FOREIGN KEY (codEvento) REFERENCES Evento_Social (codEvento)ON DELETE CASCADE,
	FOREIGN KEY (usuario) REFERENCES Usuario (matricula) ON DELETE CASCADE
);


INSERT INTO Usuario VALUES('2021.1', 'Woquiton', '4002-8922', 'woquiton@gmail.com', '123');

INSERT INTO Evento_Academico (organizador, nome, descricao, dt, horario, tipo, lugar, situacao, cargaHoraria) VALUES ('2021.1', 'Maratona ADS', 'Competição entre equipes de programadores', '2023-02-10', '07:40:00', 'Evento Acadêmico', 'Laboratório II', 'Agendado', 10);
INSERT INTO Evento_Cultural (organizador, nome, descricao, dt, horario, tipo, lugar, situacao, apresentacao)  VALUES ('2021.1', 'Famif', 'O Famif tem o intuito de mostrar o talento dos alunos', '2023-03-13', '13:30:00', 'Evento Cultural', 'Auditório', 'Agendado', 'Música e Dança');
INSERT INTO Evento_Social (organizador, nome, descricao, dt, horario, tipo, lugar, situacao, celebracao)  VALUES ('2021.1', 'Tchau ADS', 'Formatura e despedida dos alunos de ADS', '2024-06-23', '07:40:00', 'Evento Social', 'Quadra', 'Agendado', 'Formatura');