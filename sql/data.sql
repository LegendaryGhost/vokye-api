-- Insert data into type_emp
INSERT INTO type_employe (designation, salaire_base, pourcentage)
VALUES ('Manager', 60000, 15),
       ('Cuisinier', 40000, 10),
       ('Livreur', 25000, 5);

CREATE EXTENSION IF NOT EXISTS pgcrypto;
-- Insert data into employee
INSERT INTO employe (id_type_employe, nom, prenom, email, mot_de_passe, date_entree, date_fin)
VALUES 
(1, 'Smith', 'John', 'john.smith@example.com', crypt('password123', gen_salt('bf')), '2020-01-01', NULL),
(2, 'Doe', 'Jane', 'jane.doe@example.com', crypt('securepass', gen_salt('bf')), '2021-03-15', NULL),
(3, 'Brown', 'Michael', 'michael.brown@example.com', crypt('mypass', gen_salt('bf')), '2019-06-20', NULL);



-- Insert data into Unite
INSERT INTO unite (nom_unite)
VALUES ('kg'),
       ('litre'),
       ('piece');

-- Insert data into Utilitaire
INSERT INTO utilitaire (nom, id_unite)
VALUES ('Knife', 3),
       ('Oven', 3),
       ('Frying Pan', 3);

-- Insert data into Ingredient
INSERT INTO ingredient (nom, id_unite)
VALUES ('Flour', 1),
       ('Sugar', 1),
       ('Milk', 2);

-- Insert data into Stock_utilitaire
INSERT INTO stock_utilitaire (id_utilitaire, quantite)
VALUES (1, 10),
       (2, 5),
       (3, 8);

-- Insert data into Stock_ingredient
INSERT INTO stock_ingredient (id_ingredient, quantite)
VALUES (1, 100),
       (2, 50),
       (3, 200);

-- Insert data into achat_ingredient
INSERT INTO achat_ingredient (id_ingredient, prix, quantite, date_achat)
VALUES (1, 20.50, 100, '2024-01-10'),
       (2, 15.00, 50, '2024-01-12'),
       (3, 50.00, 200, '2024-01-15');

-- Insert data into achat_utilitaire
INSERT INTO achat_utilitaire (id_utilitaire, prix, quantite, date_achat)
VALUES (1, 30.00, 10, '2024-01-20'),
       (2, 500.00, 5, '2024-01-25'),
       (3, 25.00, 8, '2024-01-28');

-- Insert data into type_depense
INSERT INTO type_depense (Designation)
VALUES ('fixe'),
       ('variable');

-- Insert data into depense
INSERT INTO depense (id_type_depense, prix, date_depense)
VALUES (1, 200.00, '2024-01-05'),
       (2, 150.00, '2024-01-10'),
       (2, 1000.00, '2024-01-15');

-- Insert data into Produit
INSERT INTO produit (nom, prix)
VALUES ('Riz', 15.00),
       ('meat', 3.00),
       ('Legume', 2.50);

-- Insert data into Ingredient_produit
INSERT INTO ingredient_produit (id_produit, id_ingredient, id_unite, quantite)
VALUES (1, 1, 1, 2),   -- Cake: 2 kg of Flour
       (1, 2, 1, 1),   -- Cake: 1 kg of Sugar
       (1, 3, 2, 1),   -- Cake: 1 litre of Milk
       (2, 1, 1, 1),   -- Bread: 1 kg of Flour
       (2, 3, 2, 0.5), -- Bread: 0.5 litre of Milk
       (3, 1, 1, 0.5), -- Muffin: 0.5 kg of Flour
       (3, 2, 1, 0.5);
-- Muffin: 0.5 kg of Sugar

-- Insert data into chariot
INSERT INTO chariot (id_employe)
VALUES (1),
       (2),
       (3);

-- Insert data into vente
INSERT INTO vente (id_chariot, id_produit, quantite, date_vente)
VALUES (1, 1, 3, '2024-01-20'), -- Chariot 1 sells 3 Cakes
       (2, 2, 5, '2024-01-21'), -- Chariot 2 sells 5 Breads
       (3, 3, 10, '2024-01-22');
-- Chariot 3 sells 10 Muffins

-- Insert data into point_vente
INSERT INTO point_vente (id_chariot, localisation, latitude, longitude)
VALUES (1, 'Analakely', '-18.9070', '47.5263'),
       (2, 'Andoharanoftsy', '-18.9794', '47.5428'),
       (3, 'Analamahistsy', '-18.8738', '47.5502');

-- Insert data into Etat
INSERT INTO etat (nom)
VALUES ('New'),
       ('Used'),
       ('Damaged');

-- Insert data into Etat_utilitaire
INSERT INTO etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire)
VALUES (1, 1, '2024-01-01'), -- Knife is New
       (2, 2, '2024-02-01'), -- Oven is Used
       (3, 3, '2024-03-01'); -- Frying Pan is Damaged
