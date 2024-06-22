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
INSERT INTO "public".depense (id_type_depense, prix, date_depense)
VALUES
(1, 50.25, '2023-01-15'),
(2, 35.60, '2023-02-20'),
(1, 20.00, '2023-03-10'),
(2, 45.75, '2023-04-05'),
(1, 30.50, '2023-05-12');

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
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude)
VALUES
    ('Magasin A', 45.6789, -73.5678),
    ('Boutique B', 40.7128, -74.0060),
    ('Centre commercial C', 51.5074, -0.1278),
    ('Marché D', 48.8566, 2.3522),
    ('Supermarché E', 34.0522, -118.2437);

-- Insérer des données de test pour la table vente
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente)
VALUES
    (1, 1, 1, 5, '2023-06-15'),
    (2, 2, 3, 3, '2023-06-16'),
    (3, 3, 2, 2, '2023-06-17'),
    (4, 4, 5, 1, '2023-06-18'),
    (5, 5, 4, 4, '2023-06-19');
