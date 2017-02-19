SET foreign_key_checks = 0;
DROP DATABASE IF EXISTS profilemanager;
SET foreign_key_checks = 1;

CREATE DATABASE IF NOT EXISTS profilemanager DEFAULT CHARACTER SET utf8;

CREATE TABLE profilemanager.Profile (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    description TEXT(512) NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profilemanager.Role (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    description TEXT(512) NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profilemanager.User (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(64) NOT NULL,
    lastname VARCHAR(64) NULL,
    email VARCHAR(128) NOT NULL UNIQUE,
    password VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profilemanager.User_Role (
    id_user INT UNSIGNED NOT NULL,
    id_role INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_user , id_role),
    FOREIGN KEY (id_user)
        REFERENCES profilemanager.User (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_role)
        REFERENCES profilemanager.Role (id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;


CREATE TABLE profilemanager.Category (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name TEXT(64) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profilemanager.Information (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    description TEXT(512) NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profilemanager.Category_Information (
	id_category INT UNSIGNED NOT NULL,
    id_information INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_category , id_information),
    FOREIGN KEY (id_category)
        REFERENCES profilemanager.Category (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_information)
        REFERENCES profilemanager.Information (id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

/* This table represents the Knowledge Base */
CREATE TABLE profilemanager.Profile_Information (
	id_profile INT UNSIGNED NOT NULL,
    id_information INT UNSIGNED NOT NULL,
    rank DOUBLE UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY (id_profile , id_information),
    FOREIGN KEY (id_profile)
        REFERENCES profilemanager.Profile (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_information)
        REFERENCES profilemanager.Information (id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE profilemanager.User_Information (
    id_user INT UNSIGNED NOT NULL,
    id_information INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_user , id_information),
    FOREIGN KEY (id_user)
        REFERENCES profilemanager.User (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_information)
        REFERENCES profilemanager.Information (id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

/* INSERT statements */
 
/* Table: Profile */
INSERT INTO profilemanager.Profile (name, description) VALUES ("Ingegnere Civile", "Ingegnere Civile: generalizza le due figure di Ingegnere Civile ed Ingegnere Edile. (Rif. albo degli ingegneri, settore a: civile ed ambientale)");
INSERT INTO profilemanager.Profile (name, description) VALUES ("Architetto", "Architettura o discipline affini");
INSERT INTO profilemanager.Profile (name, description) VALUES ("Energy Manager", "Energy Manager");
INSERT INTO profilemanager.Profile (name, description) VALUES ("Ingegnere Elettronico e dell'Automazione", "Ingegnere Elettronico e dell'Automazione");
INSERT INTO profilemanager.Profile (name, description) VALUES ("Storico dell'Arte", "Storico dell'Arte o discipline affini");
INSERT INTO profilemanager.Profile (name, description) VALUES ("Turista", "Turista");

/* Table: Role */
INSERT INTO profilemanager.Role (name, description) VALUES ("administrator", "Ruolo di Amministratore");
INSERT INTO profilemanager.Role (name, description) VALUES ("user", "Ruolo di utente semplice");

/* Table: User */
INSERT INTO profilemanager.User (firstname, lastname, email, password) VALUES ("Daniele", "Tellina", "danieletellina@gmail.com", "c6009f08fc5fc6385f1ea1f5840e179f");
INSERT INTO profilemanager.User (firstname, lastname, email, password) VALUES ("Alexander", "Perucci", "aleale89@hotmail.it", "21232f297a57a5a743894a0e4a801fc3");

/* Table: User_Role */
INSERT INTO profilemanager.User_Role (id_user, id_role) VALUES
(1, 1),
(2, 1);

/* Table: Information */
INSERT INTO profilemanager.Information (description) VALUES
("Chi ha costruito l'edificio"),
("Altre opere dello stesso autore"),
("Altri edifici nel territorio con stesse caratteristiche architettoniche"),
("Contesto culturale in cui è nata l'opera"),
("Vicende storiche che hanno interessato il luogo"),
("Storia dell'edificio e delle sue trasformazioni architettoniche"),
("Opere pittoriche e scultoree presenti nell'edificio"),
("Apparecchiatura costruttiva dell'edificio"),
("Degrado dei materiali che compongono la fabbrica"),
("Deformazioni e quadro fessurativo"),
("Meccanismi di danno che hanno interessato l'edificio"),
("Tecniche e materiali utilizzati nel consolidamento e nella mitigazione della vulnerabilità sismica"),
("Informazioni sulla struttura dell'edificio e il terreno circostante"),
("Valutazione della vulnerabilità sismica dell'edificio"),
("Pericolosità sismica del sito"),
("Valori di temperatura ed umidità"),
("Valori medi di vibrazione della struttura"),
("Dati e valori accelerometrici in generale, registrati all'interno della struttura"),
("Informazioni sulla messa in sicurezza dell'edificio"),
("Classificazione energetica dell'edificio"),
("Prestazioni energetiche dell'edificio"),
("Presenza di funzioni di automazione"),
("Sistema centralizzato/distribuito"),
("Impianto di condizionamento"),
("Tipologia diffusore (e.g. A pavimento, radiatori, etc.)"),
("Unità di trattamento aria"),
("Funzioni di risparmio e ottimizzazione energia negli edifici"),
("Lettura"),
("Musica"),
("Teatro"),
("Cinema/Cineforum"),
("Mostre artistiche e/o fotografiche"),
("Viaggi"),
("Quando sei fuori per lavoro, trovi sempre del tempo libero per visitare la città che ti ospita"),
("Quando sei fuori per lavoro, visitoi solamente qualche luogo principale."),
("Quando sei fuori per lavoro, difficilmente trovo del tempo per visitare la città."),
("Quando sei fuori per lavoro, non ti interessa visitare la città, preferisco fare altro."),
("Effettuo, anche saltuariamente, viaggi di piacere"),
("Non effettuo, viaggi di piacere"),
("Siti naturali (e.g. parchi, riserve, aree naturali protette etc.)"),
("Beni culturali quali reperti archeologici, opere artistiche, etc."),
("Espressioni intangibili e patrimoni culturali che caratterizzano una comunità, come tradizioni orali, arti dello spettacolo, feste, artigianato, cucina…"),
("Turismo religioso"),
("Opere architettoniche"),
("Opere scultoree"),
("Opere pittoriche"),
("Reperti archeologici"),
("Centri storici"),
("Siti archeologici");

/* Table: Category */
INSERT INTO profilemanager.Category (name) VALUES ("Storia");
INSERT INTO profilemanager.Category (name) VALUES ("Architettura");
INSERT INTO profilemanager.Category (name) VALUES ("Cultura");
INSERT INTO profilemanager.Category (name) VALUES ("Ingegneria");

/* Table: Profile_Information */
INSERT INTO profilemanager.Profile_Information (id_profile, id_information, rank) VALUES
/* IngegnereCivile */
(1, 1, 0.7),(1, 2, 0.7),(1, 3, 0.7),(1, 4, 0.8),(1, 5, 0.8),(1, 6, 0.9),(1, 7, 0.8),(1, 8, 0.8),(1, 9, 0.8),(1, 10, 1.0),(1, 11, 1.0),(1, 12, 1.0),(1, 13, 0.7),(1, 14, 1.0),(1, 15, 0.9),(1, 16, 0.5),(1, 17, 0.6),(1, 18, 0.7),(1, 19, 0.3),(1, 20, 0.4),(1, 21, 0.5),(1, 22, 0.4),(1, 23, 0.3),(1, 24, 0.3),(1, 25, 0.4),(1, 26, 0.3),(1, 27, 0.4),(1, 28, 1.0),(1, 29, 0.5),(1, 30, 0.0),(1, 31, 0.0),(1, 32, 0.5),(1, 33, 0.0),(1, 34, 0.0),(1, 35, 1.0),(1, 36, 0.0),(1, 37, 1.0),(1, 38, 1.0),(1, 39, 1.0),(1, 40, 0.0),(1, 41, 0.0),(1, 42, 1.0),(1, 43, 0.0),(1, 44, 0.0),(1, 45, 1.0),(1, 46, 0.5),(1, 47, 0.5),(1, 48, 0.5),(1, 49, 0.5),
/* Architetto */
(2, 1, 0.6),(2, 2, 0.3),(2, 3, 0.5),(2, 4, 1.0),(2, 5, 0.8),(2, 6, 0.7),(2, 7, 0.5),(2, 8, 0.6),(2, 9, 0.4),(2, 10, 0.5),(2, 11, 0.7),(2, 12, 0.8),(2, 13, 0.4),(2, 14, 0.7),(2, 15, 0.8),(2, 16, 0.5),(2, 17, 0.7),(2, 18, 0.6),(2, 19, 0.7),(2, 20, 0.7),(2, 21, 1.0),(2, 22, 0.7),(2, 23, 0.4),(2, 24, 0.4),(2, 25, 0.4),(2, 26, 0.5),(2, 27, 0.9),(2, 28, 0.0),(2, 29, 0.0),(2, 30, 0.5),(2, 31, 0.0),(2, 32, 0.5),(2, 33, 0.5),(2, 34, 0.0),(2, 35, 1.0),(2, 36, 0.0),(2, 37, 1.0),(2, 38, 0.5),(2, 39, 0.5),(2, 40, 0.0),(2, 41, 0.0),(2, 42, 1.0),(2, 43, 0.0),(2, 44, 1.0),(2, 45, 1.0),(2, 46, 0.0),(2, 47, 0.0),(2, 48, 1.0),(2, 49, 0.0),
/* EnergyManager */
(3, 1, 0.6),(3, 2, 0.3),(3, 3, 0.3),(3, 4, 0.7),(3, 5, 0.8),(3, 6, 0.7),(3, 7, 0.5),(3, 8, 0.8),(3, 9, 0.5),(3, 10, 0.5),(3, 11, 0.8),(3, 12, 0.8),(3, 13, 0.7),(3, 14, 0.7),(3, 15, 0.7),(3, 16, 0.8),(3, 17, 0.8),(3, 18, 0.8),(3, 19, 1.0),(3, 20, 0.7),(3, 21, 0.9),(3, 22, 0.9),(3, 23, 0.9),(3, 24, 0.8),(3, 25, 0.8),(3, 26, 0.7),(3, 27, 1.0),(3, 28, 0.0),(3, 29, 0.0),(3, 30, 0.5),(3, 31, 0.0),(3, 32, 0.0),(3, 33, 1.0),(3, 34, 0.0),(3, 35, 0.5),(3, 36, 1.0),(3, 37, 1.0),(3, 38, 0.5),(3, 39, 1.0),(3, 40, 0.0),(3, 41, 0.0),(3, 42, 1.0),(3, 43, 0.5),(3, 44, 0.5),(3, 45, 1.0),(3, 46, 0.5),(3, 47, 0.5),(3, 48, 1.0),(3, 49, 1.0),
/* IngegnereElettronicoAutomazione */
(4, 1, 0.6),(4, 2, 0.5),(4, 3, 0.5),(4, 4, 0.9),(4, 5, 0.9),(4, 6, 0.4),(4, 7, 0.5),(4, 8, 0.6),(4, 9, 0.4),(4, 10, 0.4),(4, 11, 0.4),(4, 12, 0.6),(4, 13, 0.3),(4, 14, 0.7),(4, 15, 0.7),(4, 16, 0.3),(4, 17, 0.6),(4, 18, 0.7),(4, 19, 0.6),(4, 20, 0.6),(4, 21, 0.6),(4, 22, 0.9),(4, 23, 0.8),(4, 24, 0.6),(4, 25, 0.6),(4, 26, 0.4),(4, 27, 0.6),(4, 28, 0.0),(4, 29, 0.5),(4, 30, 1.0),(4, 31, 0.0),(4, 32, 1.0),(4, 33, 1.0),(4, 34, 0.0),(4, 35, 0.0),(4, 36, 0.5),(4, 37, 0.5),(4, 38, 0.5),(4, 39, 1.0),(4, 40, 0.0),(4, 41, 0.0),(4, 42, 1.0),(4, 43, 0.0),(4, 44, 1.0),(4, 45, 1.0),(4, 46, 1.0),(4, 47, 0.5),(4, 48, 1.0),(4, 49, 0.0),
/* StoricoArte */
(5, 1, 0.8),(5, 2, 0.8),(5, 3, 0.7),(5, 4, 0.9),(5, 5, 0.9),(5, 6, 0.8),(5, 7, 0.9),(5, 8, 0.6),(5, 9, 0.7),(5, 10, 0.1),(5, 11, 0.4),(5, 12, 0.5),(5, 13, 0.4),(5, 14, 0.5),(5, 15, 0.5),(5, 16, 0.3),(5, 17, 0.4),(5, 18, 0.0),(5, 19, 0.4),(5, 20, 0.2),(5, 21, 0.2),(5, 22, 0.3),(5, 23, 0.0),(5, 24, 0.0),(5, 25, 0.1),(5, 26, 0.1),(5, 27, 0.5),(5, 28, 1.0),(5, 29, 0.5),(5, 30, 1.0),(5, 31, 0.0),(5, 32, 0.5),(5, 33, 0.0),(5, 34, 0.0),(5, 35, 0.5),(5, 36, 0.0),(5, 37, 1.0),(5, 38, 0.5),(5, 39, 1.0),(5, 40, 0.0),(5, 41, 0.0),(5, 42, 0.5),(5, 43, 0.0),(5, 44, 0.0),(5, 45, 1.0),(5, 46, 0.0),(5, 47, 0.5),(5, 48, 1.0),(5, 49, 0.5),
/* Turista */
(6, 1, 0.4),(6, 2, 0.3),(6, 3, 0.6),(6, 4, 0.8),(6, 5, 0.8),(6, 6, 0.7),(6, 7, 0.5),(6, 8, 0.4),(6, 9, 0.0),(6, 10, 0.0),(6, 11, 0.0),(6, 12, 0.0),(6, 13, 0.0),(6, 14, 0.0),(6, 15, 0.2),(6, 16, 0.4),(6, 17, 0.2),(6, 18, 0.4),(6, 19, 0.1),(6, 20, 0.1),(6, 21, 0.0),(6, 22, 0.5),(6, 23, 0.4),(6, 24, 0.1),(6, 25, 0.0),(6, 26, 0.1),(6, 27, 0.2),(6, 28, 0.5),(6, 29, 0.5),(6, 30, 0.0),(6, 31, 0.0),(6, 32, 0.0),(6, 33, 0.5),(6, 34, 0.0),(6, 35, 0.5),(6, 36, 0.5),(6, 37, 1.0),(6, 38, 0.5),(6, 39, 1.0),(6, 40, 0.0),(6, 41, 0.0),(6, 42, 1.0),(6, 43, 0.0),(6, 44, 0.5),(6, 45, 1.0),(6, 46, 0.0),(6, 47, 1.0),(6, 48, 0.5),(6, 49, 0.0);

/* Table: Category_Information */
INSERT INTO profilemanager.Category_Information (id_category, id_information) VALUES (1, 2),(2, 2),(3, 3),(3, 1);

/* Table: User_Information */
INSERT INTO profilemanager.User_Information (id_user, id_information) VALUES (1, 1),(1, 2);