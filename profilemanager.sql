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
INSERT INTO profilemanager.Profile (name, description) VALUES ("Unknown", "Profilo di default");
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
(2, 1, 4.0),(2, 2, 3.5),(2, 3, 3.5),(2, 4, 4.0),(2, 5, 4.0),(2, 6, 4.5),(2, 7, 4.0),(2, 8, 4.0),(2, 9, 4.0),(2, 10, 5.0),(2, 11, 5.0),(2, 12, 5.0),(2, 13, 3.5),(2, 14, 5.0),(2, 15, 4.5),(2, 16, 2.5),(2, 17, 3.0),(2, 18, 3.5),(2, 19, 1.5),(2, 20, 2.0),(2, 21, 2.5),(2, 22, 2.0),(2, 23, 1.5),(2, 24, 1.5),(2, 25, 2.0),(2, 26, 1.5),(2, 27, 2.0),(2, 28, 1.0),(2, 29, 0.5),(2, 30, 0.0),(2, 31, 0.0),(2, 32, 0.5),(2, 33, 0.0),(2, 34, 0.0),(2, 35, 1.0),(2, 36, 0.0),(2, 37, 1.0),(2, 38, 1.0),(2, 39, 1.0),(2, 40, 0.0),(2, 41, 0.0),(2, 42, 1.0),(2, 43, 0.0),(2, 44, 0.0),(2, 45, 1.0),(2, 46, 0.5),(2, 47, 0.0),(2, 48, 0.5),(2, 49, 0.5), 
/* Architetto */
(3, 1, 3.0),(3, 2, 1.5),(3, 3, 2.5),(3, 4, 5.0),(3, 5, 4.0),(3, 6, 3.5),(3, 7, 2.5),(3, 8, 3.0),(3, 9, 2.0),(3, 10, 2.5),(3, 11, 3.5),(3, 12, 4.0),(3, 13, 2.0),(3, 14, 3.5),(3, 15, 4.0),(3, 16, 2.5),(3, 17, 3.5),(3, 18, 3.0),(3, 19, 3.5),(3, 20, 3.5),(3, 21, 5.0),(3, 22, 3.5),(3, 23, 2.0),(3, 24, 2.0),(3, 25, 2.0),(3, 26, 2.5),(3, 27, 4.5),(3, 28, 0.0),(3, 29, 0.0),(3, 30, 0.5),(3, 31, 0.0),(3, 32, 0.5),(3, 33, 0.5),(3, 34, 0.0),(3, 35, 1.0),(3, 36, 0.0),(3, 37, 1.0),(3, 38, 0.5),(3, 39, 0.5),(3, 40, 0.0),(3, 41, 0.0),(3, 42, 1.0),(3, 43, 0.0),(3, 44, 1.0),(3, 45, 1.0),(3, 46, 0.0),(3, 47, 0.0),(3, 48, 1.0),(3, 49, 0.0), 
/* EnergyManager */
(4, 1, 3.0),(4, 2, 1.5),(4, 3, 1.5),(4, 4, 3.5),(4, 5, 4.0),(4, 6, 3.5),(4, 7, 2.5),(4, 8, 4.0),(4, 9, 2.5),(4, 10, 2.5),(4, 11, 4.0),(4, 12, 4.0),(4, 13, 3.5),(4, 14, 3.5),(4, 15, 3.5),(4, 16, 4.0),(4, 17, 4.0),(4, 18, 4.0),(4, 19, 5.0),(4, 20, 3.5),(4, 21, 4.5),(4, 22, 4.5),(4, 23, 4.5),(4, 24, 4.0),(4, 25, 4.0),(4, 26, 3.5),(4, 27, 5.0),(4, 28, 0.0),(4, 29, 0.0),(4, 30, 0.5),(4, 31, 0.0),(4, 32, 0.0),(4, 33, 1.0),(4, 34, 0.0),(4, 35, 0.5),(4, 36, 1.0),(4, 37, 1.0),(4, 38, 0.5),(4, 39, 1.0),(4, 40, 0.0),(4, 41, 0.0),(4, 42, 1.0),(4, 43, 0.0),(4, 44, 0.5),(4, 45, 1.0),(4, 46, 0.5),(4, 47, 0.0),(4, 48, 1.0),(4, 49, 1.0), 
/* IngegnereElettronicoAutomazione */
(5, 1, 3.0),(5, 2, 2.5),(5, 3, 2.5),(5, 4, 4.5),(5, 5, 4.5),(5, 6, 2.0),(5, 7, 2.5),(5, 8, 3.0),(5, 9, 2.0),(5, 10, 2.0),(5, 11, 2.0),(5, 12, 3.0),(5, 13, 1.5),(5, 14, 3.5),(5, 15, 3.5),(5, 16, 1.5),(5, 17, 3.0),(5, 18, 3.5),(5, 19, 3.0),(5, 20, 3.0),(5, 21, 3.0),(5, 22, 4.5),(5, 23, 4.0),(5, 24, 3.0),(5, 25, 3.0),(5, 26, 2.0),(5, 27, 3.0),(5, 28, 0.0),(5, 29, 0.5),(5, 30, 1.0),(5, 31, 0.0),(5, 32, 1.0),(5, 33, 1.0),(5, 34, 0.0),(5, 35, 0.0),(5, 36, 0.5),(5, 37, 0.5),(5, 38, 0.5),(5, 39, 1.0),(5, 40, 0.0),(5, 41, 0.0),(5, 42, 1.0),(5, 43, 0.0),(5, 44, 1.0),(5, 45, 1.0),(5, 46, 1.0),(5, 47, 0.5),(5, 48, 1.0),(5, 49, 0.0), 
/* StoricoArte */
(6, 1, 4.0),(6, 2, 4.0),(6, 3, 3.5),(6, 4, 4.5),(6, 5, 4.5),(6, 6, 4.0),(6, 7, 4.5),(6, 8, 3.0),(6, 9, 3.5),(6, 10, 0.5),(6, 11, 2.0),(6, 12, 2.5),(6, 13, 2.0),(6, 14, 2.5),(6, 15, 2.5),(6, 16, 1.5),(6, 17, 2.0),(6, 18, 0.0),(6, 19, 2.0),(6, 20, 1.0),(6, 21, 1.0),(6, 22, 1.5),(6, 23, 0.0),(6, 24, 0.0),(6, 25, 0.5),(6, 26, 0.5),(6, 27, 2.5),(6, 28, 1.0),(6, 29, 0.5),(6, 30, 1.0),(6, 31, 0.0),(6, 32, 0.5),(6, 33, 0.0),(6, 34, 0.0),(6, 35, 0.5),(6, 36, 0.0),(6, 37, 1.0),(6, 38, 0.5),(6, 39, 1.0),(6, 40, 0.0),(6, 41, 0.0),(6, 42, 0.5),(6, 43, 0.0),(6, 44, 0.0),(6, 45, 1.0),(6, 46, 0.0),(6, 47, 0.5),(6, 48, 1.0),(6, 49, 0.5), 
/* Turista */
(7, 1, 2.0),(7, 2, 1.5),(7, 3, 3.0),(7, 4, 4.0),(7, 5, 4.0),(7, 6, 3.5),(7, 7, 2.5),(7, 8, 2.0),(7, 9, 0.0),(7, 10, 0.0),(7, 11, 0.0),(7, 12, 0.0),(7, 13, 0.0),(7, 14, 0.0),(7, 15, 1.0),(7, 16, 2.0),(7, 17, 1.0),(7, 18, 2.0),(7, 19, 0.5),(7, 20, 0.5),(7, 21, 0.0),(7, 22, 2.5),(7, 23, 2.0),(7, 24, 0.5),(7, 25, 0.0),(7, 26, 0.5),(7, 27, 1.0),(7, 28, 0.5),(7, 29, 0.5),(7, 30, 0.0),(7, 31, 0.0),(7, 32, 0.0),(7, 33, 0.5),(7, 34, 0.0),(7, 35, 0.5),(7, 36, 0.5),(7, 37, 1.0),(7, 38, 0.5),(7, 39, 1.0),(7, 40, 0.0),(7, 41, 0.0),(7, 42, 1.0),(7, 43, 0.0),(7, 44, 0.5),(7, 45, 1.0),(7, 46, 0.0),(7, 47, 1.0),(7, 48, 0.5),(7, 49, 0.0);

/* Table: Category_Information */
INSERT INTO profilemanager.Category_Information (id_category, id_information) VALUES (1, 2),(2, 2),(3, 3),(3, 1);

/* Table: User_Information */
INSERT INTO profilemanager.User_Information (id_user, id_information) VALUES (1, 1),(1, 2);