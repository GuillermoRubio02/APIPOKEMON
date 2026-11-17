USE Pokedex;

-- ENTRENADORES
INSERT INTO trainers (name, hometown)
VALUES ('Ash', 'Pueblo Paleta');

INSERT INTO trainers (name, hometown)
VALUES ('Misty', 'Ciudad Celeste');

-- POKEMON
INSERT INTO pokemon (name, imagen_url, type, trainer_id)
VALUES ('Charizard', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png', 'Fuego/Volador', 1);

INSERT INTO pokemon (name, imagen_url, type, trainer_id)
VALUES ('Pikachu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'Eléctrico', 1);

INSERT INTO pokemon (name, imagen_url, type, trainer_id)
VALUES ('Bulbasaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', 'Planta/Veneno', NULL);

-- ESTADISTICAS
INSERT INTO pokemon_stats (hp, attack, defense, speed, height, weight, pokemon_id)
VALUES (78, 84, 78, 100, 1.7, 90.5, 1);

INSERT INTO pokemon_stats (hp, attack, defense, speed, height, weight, pokemon_id)
VALUES (35, 55, 40, 90, 0.4, 6.0, 2);

INSERT INTO pokemon_stats (hp, attack, defense, speed, height, weight, pokemon_id)
VALUES (45, 49, 49, 45, 0.7, 6.9, 3);

-- HABILIDADES
INSERT INTO abilities (name, description)
VALUES ('Mar Llamas', 'Potencia los movimientos de tipo fuego.');

INSERT INTO abilities (name, description)
VALUES ('Electricidad Estática', 'Puede paralizar al entrar en contacto.');

INSERT INTO abilities (name, description)
VALUES ('Espesura', 'Potencia los movimientos de tipo planta.');

-- RELACION POKEMON - HABILIDADES
INSERT INTO pokemon_abilities (pokemon_id, ability_id)
VALUES (1, 1);

INSERT INTO pokemon_abilities (pokemon_id, ability_id)
VALUES (2, 2);

INSERT INTO pokemon_abilities (pokemon_id, ability_id)
VALUES (3, 3);
