insert into gamers(id, name, geography) values
(1, 'John Doe', 'USA'),
(2, 'Jane Smith', 'Canada'),
(3, 'Alice Johnson', 'UK'),
(4, 'Bob Brown', 'Australia'),
(5, 'Charlie Black', 'Germany');


insert into games(id, name) values
(1, 'Call of duty'),
(2, 'World of Warcraft'),
(3, 'League of Legends'),
(4, 'Minecraft'),
(5, 'Fifa 2025');

insert into gamer_level_on_game(gamer_id, game_id, gaming_level) values
(1, 1, 1),
(1, 2, 2),
(1, 5, 1),
(2, 3, 2),
(2, 4, 2),
(2, 5, 1),
(3, 2, 1),
(3, 4, 1),
(4, 5, 1),
(5, 1, 1),
(5, 2, 3);