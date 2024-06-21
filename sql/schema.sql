-- Création de la base de données
CREATE DATABASE vokye_api;

-- Connexion à la base de données
\c vokye_api;

-- Création des tables
CREATE SCHEMA IF NOT EXISTS "public";

CREATE SEQUENCE "public".achat_ingredient_id_achat_ingredient_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".achat_ingredient_id_achat_ingredient_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".achat_utilitaire_id_achat_utilitaire_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".achat_utilitaire_id_achat_utilitaire_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".chariot_id_chariot_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".chariot_id_chariot_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".depense_id_depense_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".depense_id_depense_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".employe_id_employe_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".employe_id_employe_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".employe_id_genre_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".etat_id_etat_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".etat_id_etat_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".etat_utilitaire_id_etat_utilitaire_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".etat_utilitaire_id_etat_utilitaire_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".genres_id_genre_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".ingredient_id_ingredient_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".ingredient_id_ingredient_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".ingredient_produit_id_ingredient_produit_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".ingredient_produit_id_ingredient_produit_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".point_vente_id_point_vente_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".point_vente_id_point_vente_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".produit_id_produit_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".produit_id_produit_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".stock_ingredient_id_stock_ingredient_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".stock_ingredient_id_stock_ingredient_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".stock_utilitaire_id_stock_utilitaire_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".stock_utilitaire_id_stock_utilitaire_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_depense_id_type_depense_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_depense_id_type_depense_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_employe_id_type_employe_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_employe_id_type_employe_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".unite_id_unite_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".unite_id_unite_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".utilitaire_id_utilitaire_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".utilitaire_id_utilitaire_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".vente_id_vente_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".vente_id_vente_seq1 AS integer START WITH 1 INCREMENT BY 1;

CREATE TABLE "public".etat_utilitaire
(
    id_etat_utilitaire   integer DEFAULT nextval('etat_utilitaire_id_etat_utilitaire_seq1'::regclass) NOT NULL,
    id_utilitaire        integer,
    id_etat              integer,
    date_etat_utilitaire date,
    CONSTRAINT etat_utilitaire_pkey PRIMARY KEY (id_etat_utilitaire),
    CONSTRAINT unq_etat_utilitaire_id_etat UNIQUE (id_etat)
);

CREATE TABLE "public".produit
(
    id_produit integer DEFAULT nextval('produit_id_produit_seq1'::regclass) NOT NULL,
    nom        varchar(50),
    prix       numeric(10, 2),
    CONSTRAINT produit_pkey PRIMARY KEY (id_produit)
);

CREATE TABLE "public".type_achat
(
    id_type_achat   serial      NOT NULL,
    designation     varchar(50) NOT NULL,
    id_type_depense integer DEFAULT nextval('type_depense_id_type_depense_seq1'::regclass),
    CONSTRAINT pk_achats PRIMARY KEY (id_type_achat),
    CONSTRAINT unq_type_achat_id_type_depense UNIQUE (id_type_depense)
);

CREATE TABLE "public".type_depense
(
    id_type_depense integer DEFAULT nextval('type_depense_id_type_depense_seq1'::regclass) NOT NULL,
    designation     varchar(50),
    CONSTRAINT type_depense_pkey PRIMARY KEY (id_type_depense)
);

CREATE TABLE "public".type_employe
(
    id_type_employe integer DEFAULT nextval('type_employe_id_type_employe_seq1'::regclass) NOT NULL,
    cota            numeric(10, 2),
    designation     varchar(20),
    salaire_base    numeric(10, 2),
    pourcentage     integer,
    CONSTRAINT type_employe_pkey PRIMARY KEY (id_type_employe)
);

CREATE TABLE "public".unite
(
    id_unite  integer DEFAULT nextval('unite_id_unite_seq1'::regclass) NOT NULL,
    nom_unite varchar(50),
    CONSTRAINT unite_pkey PRIMARY KEY (id_unite)
);

CREATE TABLE "public".utilitaire
(
    id_utilitaire integer DEFAULT nextval('utilitaire_id_utilitaire_seq1'::regclass) NOT NULL,
    nom           varchar(50),
    id_unite      integer,
    stock         double precision                                                   NOT NULL,
    CONSTRAINT utilitaire_pkey PRIMARY KEY (id_utilitaire)
);

CREATE TABLE "public".achat_utilitaire
(
    id_achat_utilitaire integer DEFAULT nextval('achat_utilitaire_id_achat_utilitaire_seq1'::regclass) NOT NULL,
    id_utilitaire       integer,
    prix_unitaire       numeric(10, 2),
    quantite            integer,
    date_achat          date,
    id_depense          integer DEFAULT nextval('depense_id_depense_seq1'::regclass),
    CONSTRAINT achat_utilitaire_pkey PRIMARY KEY (id_achat_utilitaire),
    CONSTRAINT unq_achat_utilitaire_id_depense UNIQUE (id_depense)
);

CREATE TABLE "public".employe
(
    id_employe      integer DEFAULT nextval('employe_id_employe_seq1'::regclass) NOT NULL,
    id_type_employe integer,
    nom             varchar(50),
    prenom          varchar(50),
    mot_de_passe    varchar(50),
    date_entree     date,
    date_fin        date,
    id_genre        serial                                                       NOT NULL,
    email           varchar(255)                                                 NOT NULL,
    photo           varchar(255)                                                 NOT NULL,
    date_naissance  date                                                         NOT NULL,
    num_tel         varchar(14)                                                  NOT NULL,
    CONSTRAINT employe_pkey PRIMARY KEY (id_employe),
    CONSTRAINT unq_employe_id_genre UNIQUE (id_genre)
);

CREATE TABLE "public".etat
(
    id_etat integer DEFAULT nextval('etat_id_etat_seq1'::regclass) NOT NULL,
    nom     varchar(50),
    CONSTRAINT etat_pkey PRIMARY KEY (id_etat)
);

CREATE TABLE "public".genres
(
    id_genre  serial NOT NULL,
    nom_genre varchar(10),
    CONSTRAINT pk_genres PRIMARY KEY (id_genre)
);

CREATE TABLE "public".ingredient
(
    id_ingredient integer DEFAULT nextval('ingredient_id_ingredient_seq1'::regclass) NOT NULL,
    nom           varchar(50),
    id_unite      integer,
    stock         double precision                                                   NOT NULL,
    CONSTRAINT ingredient_pkey PRIMARY KEY (id_ingredient)
);

CREATE TABLE "public".ingredient_produit
(
    id_ingredient_produit integer DEFAULT nextval('ingredient_produit_id_ingredient_produit_seq1'::regclass) NOT NULL,
    id_produit            integer,
    id_ingredient         integer,
    id_unite              integer,
    quantite              integer,
    CONSTRAINT ingredient_produit_pkey PRIMARY KEY (id_ingredient_produit)
);

CREATE TABLE "public".achat_ingredient
(
    id_achat_ingredient integer DEFAULT nextval('achat_ingredient_id_achat_ingredient_seq1'::regclass) NOT NULL,
    id_ingredient       integer,
    prix_unitaire       numeric(10, 2),
    quantite            integer,
    date_achat          date,
    id_depense          integer DEFAULT nextval('depense_id_depense_seq1'::regclass),
    CONSTRAINT achat_ingredient_pkey PRIMARY KEY (id_achat_ingredient),
    CONSTRAINT unq_achat_ingredient_id_depense UNIQUE (id_depense)
);

CREATE TABLE "public".chariot
(
    id_chariot integer DEFAULT nextval('chariot_id_chariot_seq1'::regclass) NOT NULL,
    id_employe integer,
    CONSTRAINT chariot_pkey PRIMARY KEY (id_chariot)
);

CREATE TABLE "public".depense
(
    id_depense      integer DEFAULT nextval('depense_id_depense_seq1'::regclass) NOT NULL,
    id_type_depense integer,
    prix            numeric(10, 2),
    date_depense    date,
    CONSTRAINT depense_pkey PRIMARY KEY (id_depense)
);

CREATE TABLE "public".point_vente
(
    id_point_vente integer DEFAULT nextval('point_vente_id_point_vente_seq1'::regclass) NOT NULL,
    id_chariot     integer,
    localisation   varchar(200),
    longitude      double precision,
    latitude       double precision,
    CONSTRAINT point_vente_pkey PRIMARY KEY (id_point_vente)
);

CREATE TABLE "public".vente
(
    id_vente       integer DEFAULT nextval('vente_id_vente_seq1'::regclass) NOT NULL,
    id_point_vente integer,
    id_chariot     integer,
    id_produit     integer,
    quantite       integer,
    date_vente     date,
    CONSTRAINT vente_pkey PRIMARY KEY (id_vente)
);

ALTER TABLE "public".achat_ingredient
    ADD CONSTRAINT achat_ingredient_id_ingredient_fkey FOREIGN KEY (id_ingredient) REFERENCES "public".ingredient (id_ingredient);

ALTER TABLE "public".achat_utilitaire
    ADD CONSTRAINT achat_utilitaire_id_utilitaire_fkey FOREIGN KEY (id_utilitaire) REFERENCES "public".utilitaire (id_utilitaire);

ALTER TABLE "public".chariot
    ADD CONSTRAINT fk_chariot_employe FOREIGN KEY (id_employe) REFERENCES "public".employe (id_employe);

ALTER TABLE "public".depense
    ADD CONSTRAINT depense_id_type_depense_fkey FOREIGN KEY (id_type_depense) REFERENCES "public".type_depense (id_type_depense);

ALTER TABLE "public".depense
    ADD CONSTRAINT fk_depense_achat_utilitaire FOREIGN KEY (id_depense) REFERENCES "public".achat_utilitaire (id_depense);

ALTER TABLE "public".depense
    ADD CONSTRAINT fk_depense_achat_ingredient FOREIGN KEY (id_depense) REFERENCES "public".achat_ingredient (id_depense);

ALTER TABLE "public".employe
    ADD CONSTRAINT employe_id_type_employe_fkey FOREIGN KEY (id_type_employe) REFERENCES "public".type_employe (id_type_employe);

ALTER TABLE "public".etat
    ADD CONSTRAINT fk_etat_etat_utilitaire FOREIGN KEY (id_etat) REFERENCES "public".etat_utilitaire (id_etat);

ALTER TABLE "public".genres
    ADD CONSTRAINT fk_genres_employe FOREIGN KEY (id_genre) REFERENCES "public".employe (id_genre);

ALTER TABLE "public".ingredient
    ADD CONSTRAINT ingredient_id_unite_fkey FOREIGN KEY (id_unite) REFERENCES "public".unite (id_unite);

ALTER TABLE "public".ingredient_produit
    ADD CONSTRAINT ingredient_produit_id_produit_fkey FOREIGN KEY (id_produit) REFERENCES "public".produit (id_produit);

ALTER TABLE "public".ingredient_produit
    ADD CONSTRAINT fk_ingredient_produit_ingredient FOREIGN KEY (id_ingredient) REFERENCES "public".ingredient (id_ingredient);

ALTER TABLE "public".point_vente
    ADD CONSTRAINT point_vente_id_chariot_fkey FOREIGN KEY (id_chariot) REFERENCES "public".chariot (id_chariot);

ALTER TABLE "public".type_depense
    ADD CONSTRAINT fk_type_depense_type_achat FOREIGN KEY (id_type_depense) REFERENCES "public".type_achat (id_type_depense);

ALTER TABLE "public".utilitaire
    ADD CONSTRAINT utilitaire_id_unite_fkey FOREIGN KEY (id_unite) REFERENCES "public".unite (id_unite);

ALTER TABLE "public".vente
    ADD CONSTRAINT vente_id_produit_fkey FOREIGN KEY (id_produit) REFERENCES "public".produit (id_produit);

ALTER TABLE "public".vente
    ADD CONSTRAINT vente_id_chariot_fkey FOREIGN KEY (id_chariot) REFERENCES "public".chariot (id_chariot);

ALTER TABLE "public".vente
    ADD CONSTRAINT vente_id_point_vente_fkey FOREIGN KEY (id_point_vente) REFERENCES "public".point_vente (id_point_vente);

-- view vente
CREATE OR REPLACE VIEW recette_vente AS
(
SELECT SUM(p.prix * quantite) AS sum_vente,
       v.date_vente           AS date_vente,
       e.id_employe,
       e.id_type_employe,
       e.nom                  as nom,
       e.prenom               as prenom,
       te.cota,
       SUM(v.quantite)        AS nombre_vente
FROM Vente v
         JOIN chariot c ON v.id_chariot = c.id_chariot
         JOIN employe e ON c.id_employe = e.id_employe
         JOIN produit p ON v.id_produit = p.id_produit
         JOIN type_employe te ON e.id_type_employe = te.id_type_employe
GROUP BY e.id_employe, v.date_vente, te.cota
    );


SELECT SUM()
FROM recette_vente