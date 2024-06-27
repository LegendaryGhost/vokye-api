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

CREATE TABLE "public".genres
(
    id_genre  serial NOT NULL,
    nom_genre varchar(10),
    CONSTRAINT pk_genres PRIMARY KEY (id_genre)
);

CREATE TABLE "public".employe
(
    id_employe      integer DEFAULT nextval('employe_id_employe_seq1'::regclass) NOT NULL,
    id_type_employe integer,
    nom             varchar(50),
    prenom          varchar(50),
    mot_de_passe    varchar(100),
    date_entree     date,
    date_fin        date,
    id_genre        integer,                                                                    -- Modification de la colonne id_genre en tant qu'integer

    email           varchar(255)                                                 NOT NULL,
    photo           varchar(255)                                                 NOT NULL,
    date_naissance  date                                                         NOT NULL,
    num_tel         varchar(14)                                                  NOT NULL,

    CONSTRAINT employe_pkey PRIMARY KEY (id_employe),
    CONSTRAINT fk_employe_id_genre FOREIGN KEY (id_genre) REFERENCES "public".genres (id_genre) -- Ajout de la contrainte de clé étrangère
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

CREATE TABLE "public".etat
(
    id_etat integer DEFAULT nextval('etat_id_etat_seq1'::regclass) NOT NULL,
    nom     varchar(50),
    CONSTRAINT etat_pkey PRIMARY KEY (id_etat)
);


CREATE TABLE "public".etat_utilitaire
(
    id_etat_utilitaire   integer DEFAULT nextval('etat_utilitaire_id_etat_utilitaire_seq1'::regclass) NOT NULL,
    id_utilitaire        integer,
    id_etat              integer,
    date_etat_utilitaire date,
    CONSTRAINT etat_utilitaire_pkey PRIMARY KEY (id_etat_utilitaire)
);

CREATE TABLE "public".produit
(
    id_produit integer DEFAULT nextval('produit_id_produit_seq1'::regclass) NOT NULL,
    nom        varchar(50),
    prix       numeric(10, 2),
    CONSTRAINT produit_pkey PRIMARY KEY (id_produit)
);


CREATE TABLE "public".type_depense
(
    id_type_depense integer DEFAULT nextval('type_depense_id_type_depense_seq1'::regclass) NOT NULL,
    designation     varchar(50),
    CONSTRAINT type_depense_pkey PRIMARY KEY (id_type_depense)
);

CREATE TABLE "public".depense
(
    id_depense      integer DEFAULT nextval('depense_id_depense_seq1'::regclass) NOT NULL,
    id_type_depense integer,
    prix            numeric(10, 2),
    date_depense    date,
    CONSTRAINT depense_pkey PRIMARY KEY (id_depense)
);


CREATE TABLE "public".achat_utilitaire
(
    id_achat_utilitaire integer DEFAULT nextval('achat_utilitaire_id_achat_utilitaire_seq1'::regclass) NOT NULL,
    id_utilitaire       integer,
    prix_unitaire       numeric(10, 2),
    quantite            integer,
    date_achat          date,
    id_depense          integer,
    CONSTRAINT achat_utilitaire_pkey PRIMARY KEY (id_achat_utilitaire),
    CONSTRAINT unq_id_depense UNIQUE (id_depense)
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
    id_depense          integer,
    CONSTRAINT achat_ingredient_pkey PRIMARY KEY (id_achat_ingredient),
    CONSTRAINT unq_achat_ingredient_id_depense UNIQUE (id_depense)
);

CREATE TABLE "public".chariot
(
    id_chariot integer DEFAULT nextval('chariot_id_chariot_seq1'::regclass) NOT NULL,
    id_employe integer,
    CONSTRAINT chariot_pkey PRIMARY KEY (id_chariot)
);



CREATE TABLE "public".point_vente
(
    id_point_vente integer DEFAULT nextval('point_vente_id_point_vente_seq1'::regclass) NOT NULL,
    localisation   varchar(200),
    longitude      double precision,
    latitude       double precision,
    CONSTRAINT point_vente_pkey PRIMARY KEY (id_point_vente)
);

CREATE TABLE "public".vente
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

CREATE OR REPLACE VIEW v_sale_point AS
SELECT pv.*,
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

-- view employe

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



CREATE OR REPLACE VIEW vue_chiffre_affaire AS
SELECT v.id_chariot             AS id_employe,
       SUM(v.quantite * p.prix) AS chiffre_affaires
FROM vente v
         JOIN
     produit p ON v.id_produit = p.id_produit
GROUP BY v.id_chariot;


DROP VIEW IF EXISTS employe_performance;
CREATE OR REPLACE VIEW employe_performance AS
SELECT e.id_employe,
       e.nom,
       e.prenom,
       e.photo                 AS photo_de_profil,
       MAX(v.quantite)         AS meilleur_quantite_vente,
       MAX(c.chiffre_affaires) AS meilleur_chiffre_d_affaires
FROM employe e
         LEFT JOIN
     vente v ON e.id_employe = v.id_chariot
         LEFT JOIN
     vue_chiffre_affaire c ON e.id_employe = c.id_employe
GROUP BY e.id_employe, e.nom, e.prenom, e.photo;

CREATE OR REPLACE VIEW employe_performanceByYear AS
SELECT e.id_employe,
       e.nom,
       e.prenom,
       e.photo                 AS photo_de_profil,
       MAX(v.quantite)         AS meilleur_quantite_vente,
       MAX(c.chiffre_affaires) AS meilleur_chiffre_d_affaires,
       v.date_vente
FROM employe e
         LEFT JOIN
     vente v ON e.id_employe = v.id_chariot
         LEFT JOIN
     vue_chiffre_affaire c ON e.id_employe = c.id_employe
GROUP BY e.id_employe, e.nom, e.prenom, e.photo,v.date_vente;

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
--view recherche somme poinvente par date
CREATE VIEW vue_ventes_par_mois_annee AS
SELECT ROW_NUMBER() OVER ()           AS numero_ligne,
        id_point_vente,
       localisation,
       EXTRACT(YEAR FROM date_vente)  AS annee,
       EXTRACT(MONTH FROM date_vente) AS mois,
       SUM(total_ventes)              AS total_ventes_mois
FROM vue_somme_ventes_point_vente
GROUP BY id_point_vente,
         localisation,
         annee,
         mois
ORDER BY annee,
         mois,
         id_point_vente;

--view depenses
CREATE OR REPLACE VIEW vue_depenses_par_mois_annee AS
SELECT
    EXTRACT(YEAR FROM date_depense) AS annee,
    EXTRACT(MONTH FROM date_depense) AS mois,
    SUM(prix) AS total_depenses_mois
FROM
    depense
GROUP BY
    annee,
    mois
ORDER BY
    annee,
    mois;

--view cA
CREATE OR REPLACE VIEW vue_ventes_par_mois_annee2 AS
SELECT
    EXTRACT(YEAR FROM date_vente) AS annee,
    EXTRACT(MONTH FROM date_vente) AS mois,
    SUM(total_ventes) AS total_ventes_mois
FROM
    vue_somme_ventes_point_vente
GROUP BY
    annee,
    mois
ORDER BY
    annee,
    mois;

--view gestion
CREATE OR REPLACE VIEW vue_gestion AS
SELECT ROW_NUMBER() OVER ()           AS numero_ligne,
        COALESCE(v.annee, d.annee) AS annee,
       COALESCE(v.mois, d.mois) AS mois,
       COALESCE(v.total_ventes_mois, 0) AS total_ventes_mois,
       COALESCE(d.total_depenses_mois, 0) AS total_depenses_mois,
       COALESCE(v.total_ventes_mois, 0) - COALESCE(d.total_depenses_mois, 0) AS benefice_mois
FROM
    vue_ventes_par_mois_annee2 v
        FULL OUTER JOIN
    vue_depenses_par_mois_annee d
    ON
                v.annee = d.annee AND v.mois = d.mois
ORDER BY
    annee,
    mois;
