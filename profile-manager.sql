SET foreign_key_checks = 0;
DROP DATABASE IF EXISTS profile_manager;
SET foreign_key_checks = 1;
SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE IF NOT EXISTS profile_manager DEFAULT CHARACTER SET utf8;

CREATE TABLE profile_manager.Profile (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    description TEXT(512) NULL,
    custom BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profile_manager.Role (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    description TEXT(512) NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE profile_manager.User (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    surname VARCHAR(64) NULL,
    email VARCHAR(128) NOT NULL,
    password VARCHAR(32) NOT NULL,
    role INT NOT NULL,
    profile INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (role)
        REFERENCES profile_manager.Role (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (profile)
        REFERENCES profile_manager.Profile (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB;

CREATE TABLE profile_manager.Information (
    id INT NOT NULL AUTO_INCREMENT,
    description TEXT(512) NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

/* This table represents the Knowledge Base */
CREATE TABLE profile_manager.Information_Profile (
    id_profile INT NOT NULL,
    id_information INT NOT NULL,
    rank DOUBLE NOT NULL DEFAULT 0,
    PRIMARY KEY (id_profile , id_information),
    FOREIGN KEY (id_profile)
        REFERENCES profile_manager.Profile (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_information)
        REFERENCES profile_manager.Information (id)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

INSERT INTO profile_manager.Profile (id, name, description, custom) VALUES (0, "Unknown", "Breve descrizione del profilo", 0);
INSERT INTO profile_manager.Profile (name, description, custom) VALUES ("Ingegnere Civile", "Breve descrizione del profilo", 0);
INSERT INTO profile_manager.Profile (name, description, custom) VALUES ("Architetto", "Breve descrizione del profilo", 0);
INSERT INTO profile_manager.Profile (name, description, custom) VALUES ("Energy Manager", "Breve descrizione del profilo", 0);
INSERT INTO profile_manager.Profile (name, description, custom) VALUES ("Ingegnere Elettronico e dell'Automazione", "Breve descrizione del profilo", 0);
INSERT INTO profile_manager.Profile (name, description, custom) VALUES ("Storico dell'Arte", "Breve descrizione del profilo", 0);
INSERT INTO profile_manager.Profile (name, description, custom) VALUES ("Turista", "Breve descrizione del profilo", 0);

INSERT INTO profile_manager.Role (name, description) VALUES ("administrator", "Ruolo di Amministratore");
INSERT INTO profile_manager.Role (name, description) VALUES ("user", "Ruolo di utente semplice");

/* Criptare md5 le password */
INSERT INTO profile_manager.User (name, surname, email, password, role, profile) VALUES ("Daniele", "Tellina", "admin", "admin", 1, 1);

INSERT INTO profile_manager.Information (description) VALUES ("info1"),("info2"),("info3"),("info4"),("info5");

/* Knowledge Base Matrix */
INSERT INTO profile_manager.Information_Profile (id_profile, id_information, rank) VALUES
/* IngegnereCivile */
(1, 1, 4.0),(1, 2, 3.5),(1, 3, 3.5),(1, 4, 4.0),(1, 5, 4.0),
/* Architetto */
(2, 1, 3.0),(2, 2, 1.5),(2, 3, 2.5),(2, 4, 5.0),(2, 5, 4.0),
/* EnergyManager */
(3, 1, 3.0),(3, 2, 1.5),(3, 3, 1.5),(3, 4, 3.5),(3, 5, 4.0),
/* IngegnereElettronicoAutomazione */
(4, 1, 3.0),(4, 2, 2.5),(4, 3, 2.5),(4, 4, 4.5),(4, 5, 4.5),
/* StoricoArte */
(5, 1, 4.0),(5, 2, 4.0),(5, 3, 3.5),(5, 4, 4.5),(5, 5, 4.5),
/* Turista */
(6, 1, 2.0),(6, 2, 1.5),(6, 3, 3.0),(6, 4, 4.0),(6, 5, 4.0);