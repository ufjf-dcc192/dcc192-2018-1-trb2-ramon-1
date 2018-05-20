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
id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(100),
email VARCHAR(50),
senha VARCHAR(30),
id_evento INTEGER,
id_amigo INTEGER
);

CREATE TABLE EVENTO(
id INTEGER primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
titulo VARCHAR(100),
minimo DOUBLE,
data DATE,
sorteio DATE
);

