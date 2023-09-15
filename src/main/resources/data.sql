INSERT INTO AUTHOR (ID, NAME) VALUES
  (101, 'Goscinny'),
  (102, 'Uderzo'),
  (103, 'Morris'),
  (104, 'Herge');

-- Insérer des livres de bandes dessinées françaises
INSERT INTO BOOK (ID, TITLE, ISBN, AUTHOR_ID) VALUES
  (101, 'Asterix et Obelix',9781455586690, 101),
  (102, 'Lucky Luke',9780375706772, 103),
  (103, 'Tintin au Tibet',9780679723165, 104),
  (104, 'Asterix chez les Bretons',9780553375402, 101),
  (105, 'Asterix en Corse',9780804139298, 101),
  (106, 'Les Dalton',9780140279418, 103),
  (107, 'Boule et Bill',9780060938456, 102),
  (108, 'Les Schtroumpfs',9780345459671, 104),
  (109, 'Gaston Lagaffe',9780525479624, 102),
  (110, 'Lucky Luke - Daisy Town',9780062393559, 103),
  (111, 'Asterix et Cleopatre',9780735207003, 101),
  (112, 'Tintin - Le Secret de La Licorne',9780743247542, 104),
  (113, 'Boule et Bill - 60 Ans de Bonheur',9780671024092, 102),
  (114, 'Blueberry - L homme qui Valait 500 000',9780451524935, 103),
  (115, 'Lucky Luke - La Diligence',9780441007461, 101),
  (116, 'Tintin - Les Cigares du Pharaon',9780767905923, 104),
  (117, 'Asterix - Le Combat des Chefs',9780812979658, 102),
  (118, 'Boule et Bill - Bill a du Talent',9780312195512, 102);