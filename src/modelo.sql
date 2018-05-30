DROP TABLE participante;

DROP TABLE evento;

CREATE TABLE evento (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    titulo VARCHAR(1000) NOT NULL,
    minimoValor DOUBLE NOT NULL,
    dataInscricao DATE NOT NULL,
    sorteio DATE
);

CREATE TABLE participante (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    idEvento INTEGER NOT NULL,
    idAmigo INTEGER,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(30),
    sorteado BOOLEAN DEFAULT false,
    FOREIGN KEY (idEvento) REFERENCES evento(id),
    FOREIGN KEY (idAmigo) REFERENCES participante(id)
);

INSERT INTO evento (titulo, minimoValor, dataInscricao) VALUES ('Evento 1', 100, '2018-05-23 09:00:00.000');

INSERT INTO evento (titulo, minimoValor, dataInscricao) VALUES ('Evento 2', 50, '2018-06-25 09:00:00.000');