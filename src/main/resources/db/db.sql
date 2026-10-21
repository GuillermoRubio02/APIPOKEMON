
CREATE DATABASE IF NOT EXISTS Pokedex;

USE Pokedex;

CREATE TABLE IF NOT EXISTS Pokedex.pokemon (
    pokemon_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pokemon_name VARCHAR(255),
    imagen_url VARCHAR(255),
    pokemon_type VARCHAR(255)
);
