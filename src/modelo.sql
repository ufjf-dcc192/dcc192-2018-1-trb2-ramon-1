DROP TABLE participante;

DROP TABLE evento;

CREATE TABLE evento (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    titulo VARCHAR(1000) NOT NULL,
    minimoValor DOUBLE NOT NULL,
    dataInscricao TIMESTAMP NOT NULL,
    dataSorteio TIMESTAMP NOT NULL,
    sorteado BOOLEAN DEFAULT FALSE
);

CREATE TABLE participante (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    idEvento INTEGER NOT NULL,
    idAmigo INTEGER,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(30),
    FOREIGN KEY (idEvento) REFERENCES evento(id),
    FOREIGN KEY (idAmigo) REFERENCES participante(id)
);

INSERT INTO evento (titulo, minimoValor, dataInscricao, dataSorteio) VALUES ('Evento 1', 100, '2018-05-23 09:00:00.000', '2018-05-29 09:00:00');

INSERT INTO evento (titulo, minimoValor, dataInscricao, dataSorteio) VALUES ('Evento 2', 50, '2018-06-25 09:00:00.000', '2018-06-27 09:00:00');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (1, 'João', 'joao@gmail.com', '123');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (1, 'José', 'jose@gmail.com', '123');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (1, 'Maria', 'maria@gmail.com', '123');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (1, 'Ana', 'ana@gmail.com', '123');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (1, 'Antônio', 'antonio@gmail.com', '123');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (2, 'Matheus', 'matheus@gmail.com', '123');

INSERT INTO participante (idEvento, nome, email, senha) VALUES (2, 'Nathalia', 'nathalia@gmail.com', '123');

