-- Insert data into type_emp
INSERT INTO "public".type_employe (cota, designation, salaire_base, pourcentage)
VALUES
(1000.00, 'Manager', 1500000.00, 10),
(800.00, 'Cuisinier', 1200000.00, 0),
(600.00, 'Vendeur', 800000.00, 0);

-- Insertion des données pour la table genres
INSERT INTO "public".genres (nom_genre)
VALUES
('Masculin'),
('Féminin');

CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Insérer des données de test pour la table employe avec des données malgaches
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES
(1, 'Razafindrakoto', 'Mialy', crypt('mdp123', gen_salt('bf')), '2023-01-15', NULL, 1, 'mialy.razafindrakoto@example.mg', 'chemin/vers/photo.jpg', '1992-05-15', '0321122334'),
(2, 'Rakotomalala', 'Haja', crypt('password456', gen_salt('bf')), '2022-11-20', '2023-06-30', 2, 'haja.rakotomalala@example.mg', 'chemin/vers/photo.jpg', '1988-08-20', '0334455667'),
(1, 'Andrianaivo', 'Jean', crypt('securepass789', gen_salt('bf')), '2023-03-10', NULL, 1, 'jean.andrianaivo@example.mg', 'chemin/vers/photo.jpg', '1990-03-10', '0345566778'),
(2, 'Razakavololona', 'Fitiavana', crypt('mypass123', gen_salt('bf')), '2023-02-05', NULL, 2, 'fitiavana.razakavololona@example.mg', 'chemin/vers/photo.jpg', '1995-07-25', '0333344556'),
(1, 'Rasolofonirina', 'Hery', crypt('new456', gen_salt('bf')), '2022-12-30', NULL, 1, 'hery.rasolofonirina@example.mg', 'chemin/vers/photo.jpg', '1993-11-12', '0322233445'),
(2, 'Rajaonarison', 'Tantely', crypt('password789', gen_salt('bf')), '2023-04-18', NULL, 2, 'tantely.rajaonarison@example.mg', 'chemin/vers/photo.jpg', '1991-09-08', '0345566778'),
(1, 'Rakotondramanana', 'Andry', crypt('testpass123', gen_salt('bf')), '2023-05-20', NULL, 1, 'andry.rakotondramanana@example.mg', 'chemin/vers/photo.jpg', '1994-06-30', '0334433221'),
(2, 'Ramaroson', 'Tiana', crypt('securepass456', gen_salt('bf')), '2022-10-15', '2023-08-31', 2, 'tiana.ramaroson@example.mg', 'chemin/vers/photo.jpg', '1987-04-15', '0321122334'),
(1, 'Rabemananjara', 'Fanja', crypt('mypass789', gen_salt('bf')), '2023-01-05', NULL, 1, 'fanja.rabemananjara@example.mg', 'chemin/vers/photo.jpg', '1989-02-25', '0334455667'),
(2, 'Randrianarisoa', 'Mamisoa', crypt('new789', gen_salt('bf')), '2022-11-12', NULL, 2, 'mamisoa.randrianarisoa@example.mg', 'chemin/vers/photo.jpg', '1996-03-20', '0345566778');

-- Insert data into Unite
INSERT INTO unite (nom_unite)
VALUES ('kg'),
       ('litre'),
       ('piece');

-- Insert data into Utilitaire
INSERT INTO "public".utilitaire (nom, id_unite, stock)
VALUES
('Couteaux', 3, 50.0),
('Poêles', 3, 30.0),
('Emballages alimentaires', 1, 200.0),
('Assiettes', 3, 150.0),         
('Casseroles', 3, 20.0),        
('Huile d olive', 2, 10.5),      
('Farine', 1, 25.0),             
('Sacs poubelles', 3, 80.0);     

INSERT INTO "public".etat (id_etat,nom)
VALUES
(1,'New'),
(2,'Used'),
(3,'Damaged');

-- Insérer des données de test pour la table etat_utilitaire
ALTER TABLE "public".etat_utilitaire DROP CONSTRAINT unq_etat_utilitaire_id_etat;
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire)
VALUES
(1, 1, '2023-01-15'),
(2, 2, '2023-02-20'),
(3, 1, '2023-03-10'),
(1, 2, '2023-04-05'),
(2, 1, '2023-05-12');

-- Insérer des données de test pour la table produit
INSERT INTO "public".produit (nom, prix)
VALUES
('Pizza Margherita', 12.99),
('Burger Cheese', 9.50),
('Salade César', 8.75),
('Pâtes Carbonara', 11.25),
('Tacos Mexicain', 10.99);

-- Insérer des données de test pour la table type_depense
INSERT INTO "public".type_depense (designation)
VALUES
('variable'),
('fixe');

-- Insérer des données de test pour la table depense
-- Insérer des nouvelles données pour la table depense pour novembre 2023
INSERT INTO "public".depense (id_type_depense, prix, date_depense)
VALUES
    (1, 55.25, '2023-11-01'),
    (2, 37.60, '2023-11-02'),
    (1, 22.00, '2023-11-03'),
    (2, 47.75, '2023-11-04'),
    (1, 32.50, '2023-11-05'),
    (1, 40.00, '2024-01-15'),
    (2, 55.20, '2024-02-20'),
    (1, 28.75, '2024-03-10'),
    (2, 62.80, '2024-04-05'),
    (1, 33.40, '2024-05-12'),
    (2, 41.60, '2024-06-03'),
    (1, 27.90, '2024-06-15'),
    (2, 38.25, '2024-06-27'),
    (1, 45.50, '2024-01-25'),
    (2, 39.20, '2024-02-29'),
    (1, 30.80, '2024-03-20'),
    (2, 58.40, '2024-04-10'),
    (1, 36.70, '2024-05-18'),
    (2, 43.90, '2024-06-05'),
    (1, 25.60, '2024-06-20'),
    (2, 42.75, '2024-06-27'),
    (1, 50.25, '2024-01-08'),
    (2, 34.80, '2024-02-12'),
    (1, 24.90, '2024-03-25'),
    (2, 61.20, '2024-04-15'),
    (1, 31.50, '2024-05-22'),
    (2, 47.30, '2024-06-10'),
    (1, 29.80, '2024-06-25'),
    (2, 36.50, '2024-06-27');



-- Insérer des données de test pour la table achat_utilitaire
INSERT INTO "public".achat_utilitaire (id_utilitaire, prix_unitaire, quantite, date_achat, id_depense)
VALUES
(1, 25.50, 3, '2023-01-15', 1),
(2, 15.75, 2, '2023-02-20', 2),
(3, 10.00, 5, '2023-03-10', 3),
(1, 30.25, 1, '2023-04-05', 4),
(2, 20.00, 4, '2023-05-12', 5);

-- Insérer des données de test pour la table ingredient
INSERT INTO "public".ingredient (nom, id_unite, stock)
VALUES
    ('Farine', 1, 10.5),
    ('Sucre', 1, 20.0),
    ('Beurre', 1, 15.75),
    ('Sel', 1, 5.25),
    ('Oeufs', 2, 30.0),
    ('Chocolat', 1, 18.25),
    ('Lait', 2, 25.5),
    ('Levure', 1, 8.0);
-- Insérer des données de test pour la table ingredient_produit
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite)
VALUES
    (1, 1, 1, 2),
    (1, 2, 1, 3),
    (2, 3, 1, 1),
    (2, 4, 1, 0.5),
    (3, 5, 2, 4),
    (3, 6, 1, 2),
    (4, 7, 2, 3),
    (4, 8, 1, 1.5);

-- Insérer des données de test pour la table achat_ingredient
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense)
VALUES
    (1, 5.75, 2, '2023-06-15', 1),
    (2, 3.50, 3, '2023-06-16', 2),
    (3, 10.25, 1, '2023-06-17', 3),
    (4, 2.50, 4, '2023-06-18', 4),
    (5, 7.80, 2, '2023-06-19', 5);


-- Insérer des données de test pour la table chariot
INSERT INTO "public".chariot (id_employe)
VALUES
    (1),
    (2),
    (3),
    (4),
    (5);

-- Insérer des données de test pour la table point_vente
INSERT INTO "public".point_vente (localisation, longitude, latitude)
VALUES
    ('Analakely', 47.5221, -18.9144),
    ('Andavamamba', 47.5277, -18.9079),
    ('Anosy', 47.5197, -18.9064),
    ('Isotry', 47.5205, -18.9035),
    ('Ampefiloha', 47.5224, -18.9123),
    ('Anosibe', 47.5000, -18.9200),
    ('Andravoahangy', 47.5235, -18.9070),
    ('67 Ha', 47.5360, -18.9050),
    ('Ampasanimalo', 47.5150, -18.9200),
    ('Antaninarenina', 47.5265, -18.9135),
    ('Ambanidia', 47.5170, -18.9230),
    ('Ambatomainty', 47.5350, -18.9180),
    ('Ankadifotsy', 47.5335, -18.9065),
    ('Ankadimbahoaka', 47.5475, -18.9205),
    ('Ambatomitsangana', 47.5295, -18.9090),
    ('Ampandrana', 47.5305, -18.9050),
    ('Ankadilalana', 47.5195, -18.9120),
    ('Ankadivato', 47.5160, -18.9100),
    ('Soarano', 47.5280, -18.9030);

-- Insérer des données de test pour la table vente
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-06-15'),
    (2, 2, 3, 3, '2023-06-16'),
    (3, 3, 2, 2, '2023-06-17'),
    (4, 4, 5, 1, '2023-06-18'),
    (5, 5, 4, 4, '2023-06-19');

-- Insérer des données de vente pour le mois de juillet 2023
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-07-01'),
    (1, 2, 2, 3, '2023-07-02'),
    (2, 3, 3, 4, '2023-07-03'),
    (2, 4, 4, 2, '2023-07-04'),
    (3, 5, 5, 1, '2023-07-05'),
    (3, 1, 1, 6, '2023-07-06'),
    (1, 2, 2, 2, '2023-07-07'),
    (1, 3, 3, 5, '2023-07-08'),
    (2, 4, 4, 4, '2023-07-09'),
    (2, 5, 5, 3, '2023-07-10'),
    (3, 1, 1, 2, '2023-07-11'),
    (3, 2, 2, 6, '2023-07-12'),
    (1, 3, 3, 4, '2023-07-13'),
    (1, 4, 4, 1, '2023-07-14'),
    (2, 5, 5, 2, '2023-07-15'),
    (2, 1, 1, 3, '2023-07-16'),
    (3, 2, 2, 4, '2023-07-17'),
    (3, 3, 3, 5, '2023-07-18'),
    (1, 4, 4, 6, '2023-07-19'),
    (1, 5, 5, 2, '2023-07-20'),
    (2, 1, 1, 4, '2023-07-21'),
    (2, 2, 2, 3, '2023-07-22'),
    (3, 3, 3, 2, '2023-07-23'),
    (3, 4, 4, 1, '2023-07-24'),
    (1, 5, 5, 5, '2023-07-25'),
    (1, 1, 1, 2, '2023-07-26'),
    (2, 2, 2, 6, '2023-07-27'),
    (2, 3, 3, 4, '2023-07-28'),
    (3, 4, 4, 3, '2023-07-29'),
    (3, 5, 5, 1, '2023-07-30'),
    (1, 1, 1, 5, '2023-07-31');

-- Insérer des données de vente pour le mois d'août 2023
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-08-01'),
    (1, 2, 2, 3, '2023-08-02'),
    (2, 3, 3, 4, '2023-08-03'),
    (2, 4, 4, 2, '2023-08-04'),
    (3, 5, 5, 1, '2023-08-05'),
    (3, 1, 1, 6, '2023-08-06'),
    (1, 2, 2, 2, '2023-08-07'),
    (1, 3, 3, 5, '2023-08-08'),
    (2, 4, 4, 4, '2023-08-09'),
    (2, 5, 5, 3, '2023-08-10'),
    (3, 1, 1, 2, '2023-08-11'),
    (3, 2, 2, 6, '2023-08-12'),
    (1, 3, 3, 4, '2023-08-13'),
    (1, 4, 4, 1, '2023-08-14'),
    (2, 5, 5, 2, '2023-08-15'),
    (2, 1, 1, 3, '2023-08-16'),
    (3, 2, 2, 4, '2023-08-17'),
    (3, 3, 3, 5, '2023-08-18'),
    (1, 4, 4, 6, '2023-08-19'),
    (1, 5, 5, 2, '2023-08-20'),
    (2, 1, 1, 4, '2023-08-21'),
    (2, 2, 2, 3, '2023-08-22'),
    (3, 3, 3, 2, '2023-08-23'),
    (3, 4, 4, 1, '2023-08-24'),
    (1, 5, 5, 5, '2023-08-25'),
    (1, 1, 1, 2, '2023-08-26'),
    (2, 2, 2, 6, '2023-08-27'),
    (2, 3, 3, 4, '2023-08-28'),
    (3, 4, 4, 3, '2023-08-29'),
    (3, 5, 5, 1, '2023-08-30'),
    (1, 1, 1, 5, '2023-08-31');

-- Insérer des données de vente pour le mois de septembre 2023
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-09-01'),
    (1, 2, 2, 3, '2023-09-02'),
    (2, 3, 3, 4, '2023-09-03'),
    (2, 4, 4, 2, '2023-09-04'),
    (3, 5, 5, 1, '2023-09-05'),
    (3, 1, 1, 6, '2023-09-06'),
    (1, 2, 2, 2, '2023-09-07'),
    (1, 3, 3, 5, '2023-09-08'),
    (2, 4, 4, 4, '2023-09-09'),
    (2, 5, 5, 3, '2023-09-10'),
    (3, 1, 1, 2, '2023-09-11'),
    (3, 2, 2, 6, '2023-09-12'),
    (1, 3, 3, 4, '2023-09-13'),
    (1, 4, 4, 1, '2023-09-14'),
    (2, 5, 5, 2, '2023-09-15'),
    (2, 1, 1, 3, '2023-09-16'),
    (3, 2, 2, 4, '2023-09-17'),
    (3, 3, 3, 5, '2023-09-18'),
    (1, 4, 4, 6, '2023-09-19'),
    (1, 5, 5, 2, '2023-09-20'),
    (2, 1, 1, 4, '2023-09-21'),
    (2, 2, 2, 3, '2023-09-22'),
    (3, 3, 3, 2, '2023-09-23'),
    (3, 4, 4, 1, '2023-09-24'),
    (1, 5, 5, 5, '2023-09-25'),
    (1, 1, 1, 2, '2023-09-26'),
    (2, 2, 2, 6, '2023-09-27'),
    (2, 3, 3, 4, '2023-09-28'),
    (3, 4, 4, 3, '2023-09-29'),
    (3, 5, 5, 1, '2023-09-30');

-- Insérer des données de vente pour le mois d'octobre 2023
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-10-01'),
    (1, 2, 2, 3, '2023-10-02'),
    (2, 3, 3, 4, '2023-10-03'),
    (2, 4, 4, 2, '2023-10-04'),
    (3, 5, 5, 1, '2023-10-05'),
    (3, 1, 1, 6, '2023-10-06'),
    (1, 2, 2, 2, '2023-10-07'),
    (1, 3, 3, 5, '2023-10-08'),
    (2, 4, 4, 4, '2023-10-09'),
    (2, 5, 5, 3, '2023-10-10'),
    (3, 1, 1, 2, '2023-10-11'),
    (3, 2, 2, 6, '2023-10-12'),
    (1, 3, 3, 4, '2023-10-13'),
    (1, 4, 4, 1, '2023-10-14'),
    (2, 5, 5, 2, '2023-10-15'),
    (2, 1, 1, 3, '2023-10-16'),
    (3, 2, 2, 4, '2023-10-17'),
    (3, 3, 3, 5, '2023-10-18'),
    (1, 4, 4, 6, '2023-10-19'),
    (1, 5, 5, 2, '2023-10-20'),
    (2, 1, 1, 4, '2023-10-21'),
    (2, 2, 2, 3, '2023-10-22'),
    (3, 3, 3, 2, '2023-10-23'),
    (3, 4, 4, 1, '2023-10-24'),
    (1, 5, 5, 5, '2023-10-25'),
    (1, 1, 1, 2, '2023-10-26'),
    (2, 2, 2, 6, '2023-10-27'),
    (2, 3, 3, 4, '2023-10-28'),
    (3, 4, 4, 3, '2023-10-29'),
    (3, 5, 5, 1, '2023-10-30'),
    (1, 1, 1, 5, '2023-10-31');

-- Insérer des données de vente pour le mois de novembre 2023
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-11-01'),
    (1, 2, 2, 3, '2023-11-02'),
    (2, 3, 3, 4, '2023-11-03'),
    (2, 4, 4, 2, '2023-11-04'),
    (3, 5, 5, 1, '2023-11-05'),
    (3, 1, 1, 6, '2023-11-06'),
    (1, 2, 2, 2, '2023-11-07'),
    (1, 3, 3, 5, '2023-11-08'),
    (2, 4, 4, 4, '2023-11-09'),
    (2, 5, 5, 3, '2023-11-10'),
    (3, 1, 1, 2, '2023-11-11'),
    (3, 2, 2, 6, '2023-11-12'),
    (1, 3, 3, 4, '2023-11-13'),
    (1, 4, 4, 1, '2023-11-14'),
    (2, 5, 5, 2, '2023-11-15'),
    (2, 1, 1, 3, '2023-11-16'),
    (3, 2, 2, 4, '2023-11-17'),
    (3, 3, 3, 5, '2023-11-18'),
    (1, 4, 4, 6, '2023-11-19'),
    (1, 5, 5, 2, '2023-11-20'),
    (2, 1, 1, 4, '2023-11-21'),
    (2, 2, 2, 3, '2023-11-22'),
    (3, 3, 3, 2, '2023-11-23'),
    (3, 4, 4, 1, '2023-11-24'),
    (1, 5, 5, 5, '2023-11-25'),
    (1, 1, 1, 2, '2023-11-26'),
    (2, 2, 2, 6, '2023-11-27'),
    (2, 3, 3, 4, '2023-11-28'),
    (3, 4, 4, 3, '2023-11-29'),
    (3, 5, 5, 1, '2023-11-30');

-- Insérer des données de vente pour le mois de décembre 2023
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-12-01'),
    (1, 2, 2, 3, '2023-12-02'),
    (2, 3, 3, 4, '2023-12-03'),
    (2, 4, 4, 2, '2023-12-04'),
    (3, 5, 5, 1, '2023-12-05'),
    (3, 1, 1, 6, '2023-12-06'),
    (1, 2, 2, 2, '2023-12-07'),
    (1, 3, 3, 5, '2023-12-08'),
    (2, 4, 4, 4, '2023-12-09'),
    (2, 5, 5, 3, '2023-12-10'),
    (3, 1, 1, 2, '2023-12-11'),
    (3, 2, 2, 6, '2023-12-12'),
    (1, 3, 3, 4, '2023-12-13'),
    (1, 4, 4, 1, '2023-12-14'),
    (2, 5, 5, 2, '2023-12-15'),
    (2, 1, 1, 3, '2023-12-16'),
    (3, 2, 2, 4, '2023-12-17'),
    (3, 3, 3, 5, '2023-12-18'),
    (1, 4, 4, 6, '2023-12-19'),
    (1, 5, 5, 2, '2023-12-20'),
    (2, 1, 1, 4, '2023-12-21'),
    (2, 2, 2, 3, '2023-12-22'),
    (3, 3, 3, 2, '2023-12-23'),
    (3, 4, 4, 1, '2023-12-24'),
    (1, 5, 5, 5, '2023-12-25'),
    (1, 1, 1, 2, '2023-12-26'),
    (2, 2, 2, 6, '2023-12-27'),
    (2, 3, 3, 4, '2023-12-28'),
    (3, 4, 4, 3, '2023-12-29'),
    (3, 5, 5, 1, '2023-12-30'),
    (1, 1, 1, 5, '2023-12-31');

-- Insérer des données de vente pour janvier 2024
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 6, '2024-01-01'),
    (2, 2, 2, 4, '2024-01-02'),
    (3, 3, 3, 3, '2024-01-03'),
    (4, 4, 4, 2, '2024-01-04'),
    (5, 5, 5, 1, '2024-01-05'),
    (1, 1, 1, 7, '2024-01-06'),
    (2, 2, 2, 3, '2024-01-07'),
    (3, 3, 3, 6, '2024-01-08'),
    (4, 4, 4, 5, '2024-01-09'),
    (5, 5, 5, 4, '2024-01-10'),
    (1, 1, 1, 3, '2024-01-11'),
    (2, 2, 2, 6, '2024-01-12'),
    (3, 3, 3, 5, '2024-01-13'),
    (4, 4, 4, 4, '2024-01-14'),
    (5, 5, 5, 3, '2024-01-15'),
    (1, 1, 1, 2, '2024-01-16'),
    (2, 2, 2, 7, '2024-01-17'),
    (3, 3, 3, 4, '2024-01-18'),
    (4, 4, 4, 3, '2024-01-19'),
    (5, 5, 5, 6, '2024-01-20'),
    (1, 1, 1, 5, '2024-01-21'),
    (2, 2, 2, 4, '2024-01-22'),
    (3, 3, 3, 3, '2024-01-23'),
    (4, 4, 4, 2, '2024-01-24'),
    (5, 5, 5, 1, '2024-01-25'),
    (1, 1, 1, 6, '2024-01-26'),
    (2, 2, 2, 5, '2024-01-27'),
    (3, 3, 3, 4, '2024-01-28'),
    (4, 4, 4, 3, '2024-01-29'),
    (5, 5, 5, 2, '2024-01-30'),
    (1, 1, 1, 7, '2024-01-31');

-- Insérer des données de vente pour février 2024
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 6, '2024-02-01'),
    (2, 2, 2, 4, '2024-02-02'),
    (3, 3, 3, 3, '2024-02-03'),
    (4, 4, 4, 2, '2024-02-04'),
    (5, 5, 5, 1, '2024-02-05'),
    (1, 1, 1, 7, '2024-02-06'),
    (2, 2, 2, 3, '2024-02-07'),
    (3, 3, 3, 6, '2024-02-08'),
    (4, 4, 4, 5, '2024-02-09'),
    (5, 5, 5, 4, '2024-02-10'),
    (1, 1, 1, 3, '2024-02-11'),
    (2, 2, 2, 6, '2024-02-12'),
    (3, 3, 3, 5, '2024-02-13'),
    (4, 4, 4, 4, '2024-02-14'),
    (5, 5, 5, 3, '2024-02-15'),
    (1, 1, 1, 2, '2024-02-16'),
    (2, 2, 2, 7, '2024-02-17'),
    (3, 3, 3, 4, '2024-02-18'),
    (4, 4, 4, 3, '2024-02-19'),
    (5, 5, 5, 6, '2024-02-20'),
    (1, 1, 1, 5, '2024-02-21'),
    (2, 2, 2, 4, '2024-02-22'),
    (3, 3, 3, 3, '2024-02-23'),
    (4, 4, 4, 2, '2024-02-24'),
    (5, 5, 5, 1, '2024-02-25'),
    (1, 1, 1, 6, '2024-02-26'),
    (2, 2, 2, 5, '2024-02-27'),
    (3, 3, 3, 4, '2024-02-28');

-- Insérer des données de vente pour mars 2024
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 6, '2024-03-01'),
    (2, 2, 2, 4, '2024-03-02'),
    (3, 3, 3, 3, '2024-03-03'),
    (4, 4, 4, 2, '2024-03-04'),
    (5, 5, 5, 1, '2024-03-05'),
    (1, 1, 1, 7, '2024-03-06'),
    (2, 2, 2, 3, '2024-03-07'),
    (3, 3, 3, 6, '2024-03-08'),
    (4, 4, 4, 5, '2024-03-09'),
    (5, 5, 5, 4, '2024-03-10'),
    (1, 1, 1, 3, '2024-03-11'),
    (2, 2, 2, 6, '2024-03-12'),
    (3, 3, 3, 5, '2024-03-13'),
    (4, 4, 4, 4, '2024-03-14'),
    (5, 5, 5, 3, '2024-03-15'),
    (1, 1, 1, 2, '2024-03-16'),
    (2, 2, 2, 7, '2024-03-17'),
    (3, 3, 3, 4, '2024-03-18'),
    (4, 4, 4, 3, '2024-03-19'),
    (5, 5, 5, 6, '2024-03-20'),
    (1, 1, 1, 5, '2024-03-21'),
    (2, 2, 2, 4, '2024-03-22'),
    (3, 3, 3, 3, '2024-03-23'),
    (4, 4, 4, 2, '2024-03-24'),
    (5, 5, 5, 1, '2024-03-25'),
    (1, 1, 1, 6, '2024-03-26'),
    (2, 2, 2, 5, '2024-03-27'),
    (3, 3, 3, 4, '2024-03-28'),
    (4, 4, 4, 3, '2024-03-29'),
    (5, 5, 5, 2, '2024-03-30'),
    (1, 1, 1, 7, '2024-03-31');

