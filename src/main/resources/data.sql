INSERT INTO AUTHOR (ID, NAME) VALUES
  (101, 'Goscinny'),
  (102, 'Uderzo'),
  (103, 'Morris'),
  (104, 'Herge');

-- Insérer des livres de bandes dessinées françaises
INSERT INTO BOOK (ID, TITLE, AUTHOR_ID) VALUES
  (101, 'Asterix et Obelix', 101),
  (102, 'Lucky Luke', 103),
  (103, 'Tintin au Tibet', 104),
  (104, 'Asterix chez les Bretons', 101),
  (105, 'Asterix en Corse', 101),
  (106, 'Les Dalton', 103),
  (107, 'Boule et Bill', 102),
  (108, 'Les Schtroumpfs', 104),
  (109, 'Gaston Lagaffe', 102),
  (110, 'Lucky Luke - Daisy Town', 103),
  (111, 'Asterix et Cleopatre', 101),
  (112, 'Tintin - Le Secret de La Licorne', 104),
  (113, 'Boule et Bill - 60 Ans de Bonheur', 102),
  (114, 'Blueberry - L homme qui Valait 500 000', 103),
  (115, 'Lucky Luke - La Diligence', 101),
  (116, 'Tintin - Les Cigares du Pharaon', 104),
  (117, 'Asterix - Le Combat des Chefs', 102),
  (118, 'Boule et Bill - Bill a du Talent', 102);