/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  douglas
 * Created: May 20, 2018
 */

CREATE TABLE PARTICPANTE(
id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(50) NOT NULL,
senha VARCHAR(30),
id_evento INTEGER,
id_amigo INTEGER
);

CREATE TABLE EVENTO(
id INTEGER primary key GENERATED ALWAYS AS IDENTITY,
titulo VARCHAR(100) NOT NULL,
minimoValor DOUBLE NOT NULL,
data_inscricao TIMESTAMP NOT NULL,
sorteio TIMESTAMP NOT NULL,
);

