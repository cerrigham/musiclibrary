

CREATE TABLE canzone (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  titolo VARCHAR(250)
);


CREATE TABLE album (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  titolo VARCHAR(250)
);


CREATE TABLE artista (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250)
);

CREATE TABLE canzone_album (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_canzone INT,
  id_album INT
);

CREATE TABLE canzone_artista (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_canzone INT,
  id_artista INT
);