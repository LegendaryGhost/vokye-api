-- Création de la base de données
CREATE DATABASE vokye_api;

-- Connexion à la base de données
\c vokye_api;

-- Création des tables

-- type_employe
CREATE TABLE type_emp (
    id_type_emp SERIAL PRIMARY KEY,
    cota NUMERIC(10,2),
    designation VARCHAR(20),
    salaire_base NUMERIC(10, 2),
    pourcentage INT
);

CREATE TABLE genres (
    id_genre SERIAL PRIMARY KEY,
    nom_genre VARCHAR(10)
);

CREATE TABLE employee (
    id_employee SERIAL PRIMARY KEY,
    id_type_emp INT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    mot_de_passe VARCHAR(150),
    email VARCHAR(50),
    photo VARCHAR(50),
    designation VARCHAR(20),
    date_de_naissance DATE,
    num_tel INT,
    id_genre INT,
    date_entree DATE,
    date_fin DATE,
    FOREIGN KEY (id_type_emp) REFERENCES type_emp(id_type_emp),
    FOREIGN KEY (id_genre) REFERENCES genres(id_genre)
);


-- unite
CREATE TABLE unite
(
    id_unite  SERIAL PRIMARY KEY,
    nom_unite VARCHAR(50)
);

-- utilitaire
CREATE TABLE utilitaire
(
    id_utilitaire SERIAL PRIMARY KEY,
    nom           VARCHAR(50),
    id_unite      INT,
    FOREIGN KEY (id_unite) REFERENCES unite (id_unite)
);

-- ingredient
CREATE TABLE ingredient
(
    id_ingredient SERIAL PRIMARY KEY,
    nom           VARCHAR(50),
    id_unite      INT,
    FOREIGN KEY (id_unite) REFERENCES unite (id_unite)
);

-- stock_utilitaire
CREATE TABLE stock_utilitaire
(
    id_stock_utilitaire SERIAL PRIMARY KEY,
    id_utilitaire       INT,
    quantite            INT,
    FOREIGN KEY (id_utilitaire) REFERENCES utilitaire (id_utilitaire)
);

-- stock_ingredient
CREATE TABLE stock_ingredient
(
    id_stock_ingredient SERIAL PRIMARY KEY,
    id_ingredient       INT,
    quantite            INT,
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

-- achat_ingredient
CREATE TABLE achat_ingredient
(
    id_achat_ingredient SERIAL PRIMARY KEY,
    id_ingredient       INT,
    prix                NUMERIC(10, 2),
    quantite            INTEGER,
    date_achat          DATE,
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

-- achat_utilitaire
CREATE TABLE achat_utilitaire
(
    id_achat_utilitaire SERIAL PRIMARY KEY,
    id_utilitaire       INT,
    prix                NUMERIC(10, 2),
    quantite            INTEGER,
    date_achat          DATE,
    FOREIGN KEY (id_utilitaire) REFERENCES utilitaire (id_utilitaire)
);

-- type_depense
CREATE TABLE type_depense
(
    id_type_depense SERIAL PRIMARY KEY,
    designation     VARCHAR(50)
);

-- depense
CREATE TABLE depense
(
    id_depense      SERIAL PRIMARY KEY,
    id_type_depense INT,
    prix            NUMERIC(10, 2),
    date_depense    DATE,
    FOREIGN KEY (id_type_depense) REFERENCES type_depense (id_type_depense)
);

-- produit
CREATE TABLE produit
(
    id_produit SERIAL PRIMARY KEY,
    nom        VARCHAR(50),
    prix       NUMERIC(10, 2)
);

-- ingredient_produit
CREATE TABLE ingredient_produit
(
    id_ingredient_produit SERIAL PRIMARY KEY,
    id_produit            INT,
    id_ingredient         INT,
    id_unite              INT,
    quantite              INT,
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit)
);

-- chariot
CREATE TABLE chariot
(
    id_chariot SERIAL PRIMARY KEY,
    id_employe INT
);

-- point_vente
CREATE TABLE point_vente
(
    id_point_vente SERIAL PRIMARY KEY,
    id_chariot     INT,
    localisation   VARCHAR(200),
    longitude      DOUBLE PRECISION,
    latitude       DOUBLE PRECISION,
    FOREIGN KEY (id_chariot) REFERENCES chariot (id_chariot)
);

-- vente
CREATE TABLE vente
(
    id_vente       SERIAL PRIMARY KEY,
    id_point_vente INT,
    id_chariot     INT,
    id_produit     INT,
    quantite       INT,
    date_vente     DATE,
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit),
    FOREIGN KEY (id_chariot) REFERENCES chariot (id_chariot),
    FOREIGN KEY (id_point_vente) REFERENCES point_vente (id_point_vente)
);

-- etat
CREATE TABLE etat
(
    id_etat SERIAL PRIMARY KEY,
    nom     VARCHAR(50)
);

-- etat_utilitaire
CREATE TABLE etat_utilitaire
(
    id_etat_utilitaire   SERIAL PRIMARY KEY,
    id_utilitaire        INTEGER,
    id_etat              INTEGER,
    date_etat_utilitaire DATE
);

-- Vues

CREATE OR REPLACE VIEW vue_somme_ventes_point_vente AS
SELECT pv.id_point_vente,
       pv.localisation,
       v.date_vente,
       SUM(v.quantite * p.prix) AS total_ventes
FROM point_vente pv
         JOIN
     vente v ON pv.id_point_vente = v.id_point_vente
         JOIN
     produit p ON v.id_produit = p.id_produit
GROUP BY pv.id_point_vente,
         pv.localisation,
         v.date_vente;

CREATE OR REPLACE VIEW vue_employe_type AS
SELECT e.id_employe,
       e.nom,
       e.prenom,
       e.date_entree,
       e.mot_de_passe,
       e.date_fin,
       t.designation,
       t.salaire_base,
       t.pourcentage
FROM employe e
         JOIN
     type_employe t ON e.id_type_employe = t.id_type_employe;
