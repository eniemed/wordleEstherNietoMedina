SET NAMES utf8;
SET time_zone = '+02:00';
SET sql_mode = '';
DROP DATABASE IF EXISTS `wordle`;
CREATE DATABASE `wordle` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `wordle`;


CREATE TABLE equipo (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    badge VARCHAR(255),
    score INT,
    PRIMARY KEY (id)
);

CREATE TABLE juego (
    id INT NOT NULL AUTO_INCREMENT,
    dificultad VARCHAR(255),
    descripcion VARCHAR(255),
    intentosmax INT,
    PRIMARY KEY (id)
);

CREATE TABLE jugador (
    id INT NOT NULL AUTO_INCREMENT,
    score INT,
    user VARCHAR(255),
    avatar VARCHAR(255),
    equipo_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (equipo_id) REFERENCES equipo (id)
);

CREATE TABLE palabra (
    id INT NOT NULL AUTO_INCREMENT,
    palabra VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE partida (
    id INT NOT NULL AUTO_INCREMENT,
    score INT,
    palabra VARCHAR(255),
    intentos INT,
    jugador_id INT NOT NULL,
    juego_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (jugador_id) REFERENCES jugador (id),
    FOREIGN KEY (juego_id) REFERENCES juego (id)
);

CREATE TABLE sp (
    juego_id INT NOT NULL,
    palabra_id INT NOT NULL,
    PRIMARY KEY (juego_id, palabra_id),
    FOREIGN KEY (juego_id) REFERENCES juego (id),
    FOREIGN KEY (palabra_id) REFERENCES palabra (id)
);
