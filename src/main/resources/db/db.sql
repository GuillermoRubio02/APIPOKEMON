CREATE DATABASE IF NOT EXISTS Pokedex;

USE Pokedex;

CREATE TABLE IF NOT EXISTS trainers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    hometown VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS pokemon (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    imagen_url VARCHAR(255),
    type VARCHAR(45),
    trainer_id BIGINT,
    FOREIGN KEY (trainer_id) REFERENCES trainers(id)
);

CREATE TABLE IF NOT EXISTS pokemon_stats (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hp INT NOT NULL,
    attack INT NOT NULL,
    defense INT NOT NULL,
    speed INT NOT NULL,
    height DOUBLE,
    weight DOUBLE,
    pokemon_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)
);

CREATE TABLE IF NOT EXISTS abilities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS pokemon_abilities (
    pokemon_id BIGINT NOT NULL,
    ability_id BIGINT NOT NULL,
    PRIMARY KEY (pokemon_id, ability_id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (ability_id) REFERENCES abilities(id)
);
