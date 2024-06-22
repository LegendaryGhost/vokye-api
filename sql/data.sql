--type_employe
INSERT INTO "public".type_employe (designation, salaire_base) VALUES ('Cuisinier', 2500.00);
INSERT INTO "public".type_employe (designation, salaire_base) VALUES ('Livreur', 2000.00);
INSERT INTO "public".type_employe (designation, salaire_base) VALUES ('Vendeur', 2200.00);
INSERT INTO "public".type_employe (designation, salaire_base) VALUES ('Manager', 3500.00);

--genre
INSERT INTO "public".genres (nom_genre) VALUES ('Masculin');
INSERT INTO "public".genres (nom_genre) VALUES ('Féminin');
INSERT INTO "public".genres (nom_genre) VALUES ('Autre');

--unite
INSERT INTO "public".unite (nom_unite) VALUES ('kg');
INSERT INTO "public".unite (nom_unite) VALUES ('litre');
INSERT INTO "public".unite (nom_unite) VALUES ('point');

--employe
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (1, 'Doe', 'John', 'motdepasse123', '2023-01-15', NULL, 1, 'john.doe@example.com', 'john.jpg', '1990-05-15', '+261346788767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (2, 'Smith', 'Jane', 'password456', '2023-02-01', NULL, 2, 'jane.smith@example.com', 'jane.jpg', '1995-08-20', '+261346908767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (3, 'Williams', 'Michael', 'securepass', '2023-03-10', NULL, 1, 'michael.williams@example.com', 'michael.jpg', '1985-12-25', '+261346778667');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (1, 'Brown', 'Emily', 'emilypass123', '2023-04-05', '2024-04-05', 2, 'emily.brown@example.com', 'emily.jpg', '1992-10-08', '+26134988767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (4, 'Johnson', 'David', 'davidpass', '2023-05-20', NULL, 1, 'david.johnson@example.com', 'david.jpg', '1988-07-15', '+261336788767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (2, 'Miller', 'Sarah', 'sarahpass456', '2023-06-15', NULL, 2, 'sarah.miller@example.com', 'sarah.jpg', '1997-03-18', '+261326788767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (1, 'Garcia', 'Luis', 'luispass789', '2023-07-10', '2024-04-05', 1, 'luis.garcia@example.com', 'luis.jpg', '1983-09-30', '+261346755767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (3, 'Martinez', 'Ana', 'anapass123', '2023-08-25', NULL, 2, 'ana.martinez@example.com', 'ana.jpg', '1994-01-12', '+2613467454767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (4, 'Lee', 'Christopher', 'chrispass', '2023-09-01', '2024-04-05', 1, 'christopher.lee@example.com', 'chris.jpg', '1991-06-05', '+261346448767');
INSERT INTO "public".employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin, id_genre, email, photo, date_naissance, num_tel)
VALUES (2, 'Taylor', 'Emma', 'emma456pass', '2023-10-12', NULL, 2, 'emma.taylor@example.com', 'emma.jpg', '1989-04-22', '+261348978767');

--utilitaire
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Spatule', 3, 50.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Couteau de Chef', 3, 30.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Planche à Découper', 3, 20.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Fouet', 3, 15.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Cuillère à Soupe', 3, 60.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Pince de Cuisine', 3, 40.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Couteau à Pain', 3, 18.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Louche', 3, 35.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Gaz', 1, 50.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Charbon', 3, 30.0);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Huile de cuisson', 2, 25.5);
INSERT INTO "public".utilitaire (nom, id_unite, stock) VALUES ('Papier aluminium', 3, 100.0);

--etat
INSERT INTO "public".etat (nom) VALUES ('bon ');
INSERT INTO "public".etat (nom) VALUES ('mauvais');
INSERT INTO "public".etat (nom) VALUES ('moyen');

-- etat_utilitaire
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (1, 1, '2024-01-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (2, 2, '2024-02-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (3, 3, '2024-03-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (4, 3, '2024-04-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (5, 2, '2024-05-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (6, 2, '2024-06-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (7, 1, '2024-07-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (8, 1, '2024-08-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (9, 2, '2024-09-01');
INSERT INTO "public".etat_utilitaire (id_utilitaire, id_etat, date_etat_utilitaire) VALUES (10, 2, '2024-10-01');

-- produit
INSERT INTO "public".produit (nom, prix) VALUES ('Hamburger Classique', 4000);
INSERT INTO "public".produit (nom, prix) VALUES ('Cheeseburger', 4000);
INSERT INTO "public".produit (nom, prix) VALUES ('Double Cheeseburger', 4500);
INSERT INTO "public".produit (nom, prix) VALUES ('Sandwich au Poulet', 3000);
INSERT INTO "public".produit (nom, prix) VALUES ('Sandwich au Poisson', 3000);
INSERT INTO "public".produit (nom, prix) VALUES ('Croquettes de Poulet 6 pcs', 2500);
INSERT INTO "public".produit (nom, prix) VALUES ('Croquettes de Poulet 10 pcs', 4000);
INSERT INTO "public".produit (nom, prix) VALUES ('Hamburger Végan', 4000);
INSERT INTO "public".produit (nom, prix) VALUES ('Sandwich BLT', 3000);

--type_depense
INSERT INTO "public".type_depense (designation) VALUES ('Fixe');
INSERT INTO "public".type_depense (designation) VALUES ('Variable');

--depense
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (1, 30000.0, '2024-06-01');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (2, 25000.5, '2024-06-02');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (1, 30000.0, '2024-06-03');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (2, 20000.0, '2024-06-04');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (1, 18000.0, '2024-06-05');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (2, 22000.0, '2024-06-06');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (1, 27000.0, '2024-06-07');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (2, 19000.0, '2024-06-08');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (1, 31000.0, '2024-06-09');
INSERT INTO "public".depense (id_type_depense, prix, date_depense) VALUES (2, 18000.0, '2024-06-10');

--achat_utilitaire
INSERT INTO "public".achat_utilitaire (id_utilitaire, prix_unitaire, quantite, date_achat, id_depense)
VALUES (1, 2000, 2, '2024-06-01', 1);
INSERT INTO "public".achat_utilitaire (id_utilitaire, prix_unitaire, quantite, date_achat, id_depense)
VALUES (2, 3000, 3, '2024-06-02', 2);
INSERT INTO "public".achat_utilitaire (id_utilitaire, prix_unitaire, quantite, date_achat, id_depense)
VALUES (3, 2000, 1, '2024-06-03', 2);
INSERT INTO "public".achat_utilitaire (id_utilitaire, prix_unitaire, quantite, date_achat, id_depense)
VALUES (1, 2500, 1, '2024-06-04', 2);
INSERT INTO "public".achat_utilitaire (id_utilitaire, prix_unitaire, quantite, date_achat, id_depense)
VALUES (4, 10.0, 5, '2024-06-05', 2);

--ingredient
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Viande', 1, 500.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Pain à Hamburger', 3, 200.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Fromage', 2, 150.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Poulet', 1, 300.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Laitue', 2, 100.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Poisson', 1, 200.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Panure', 3, 250.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Substitut de Viande Végétale', 1, 180.0);
INSERT INTO "public".ingredient (nom, id_unite, stock) VALUES ('Bacon', 1, 150.0);

--ingredient_produit
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (1, 1, 1, 150);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (1, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (1, 3, 2, 2);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (2, 1, 1, 120);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (2, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (2, 3, 2, 1);    
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (3, 1, 1, 180);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (3, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (3, 3, 2, 2);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (4, 4, 1, 150);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (4, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (4, 5, 2, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (5, 6, 1, 150);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (5, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (5, 5, 2, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (6, 4, 1, 100);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (6, 7, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (7, 4, 1, 160);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (7, 7, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (8, 8, 1, 200);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (8, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (8, 3, 2, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (9, 9, 1, 150);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (9, 2, 3, 1);
INSERT INTO "public".ingredient_produit (id_produit, id_ingredient, id_unite, quantite) VALUES (9, 5, 2, 1);

-- --achat_ingredient
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (1, 100.0, 2, '2024-06-01', 1);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (2, 2000.5, 3, '2024-06-02', 2);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (3, 2000.0, 1, '2024-06-03', 3);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (1, 2500.0, 1, '2024-06-04', 4);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (4, 2500.0, 5, '2024-06-05', 5);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (2, 3000.0, 4, '2024-06-06', 6);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (3, 4000.0, 2, '2024-06-07', 7);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (1, 3500.0, 3, '2024-06-08', 8);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (4, 2000.0, 6, '2024-06-09', 9);
INSERT INTO "public".achat_ingredient (id_ingredient, prix_unitaire, quantite, date_achat, id_depense) VALUES (2, 1500.0, 5, '2024-06-10', 10);

--chariot
INSERT INTO "public".chariot (id_employe) VALUES (2);
INSERT INTO "public".chariot (id_employe) VALUES (6);
INSERT INTO "public".chariot (id_employe) VALUES (10);


--point de vente
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (1, 'Analakely, Antananarivo', 47.5252, -18.9146);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (2, 'Andravoahangy, Antananarivo', 47.5264, -18.9000);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (3, 'Anosy, Antananarivo', 47.5150, -18.9116);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (4, 'Isoraka, Antananarivo', 47.5233, -18.9103);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (1, '67 Ha, Antananarivo', 47.5235, -18.8953);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (2, 'Antaninarenina, Antananarivo', 47.5190, -18.9125);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (3, 'Tsaralalana, Antananarivo', 47.5267, -18.9074);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (4, 'Ankadifotsy, Antananarivo', 47.5277, -18.9065);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (1, 'Ambohijatovo, Antananarivo', 47.5185, -18.9110);
INSERT INTO "public".point_vente (id_chariot, localisation, longitude, latitude) VALUES (2, 'Ambatonakanga, Antananarivo', 47.5180, -18.9150);

--vente
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (1, 1, 1, 10, '2024-06-01');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (2, 2, 2, 8, '2024-06-02');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (3, 3, 3, 5, '2024-06-03');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (1, 1, 5, 6, '2024-06-05');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (2, 2, 6, 4, '2024-06-06');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (3, 3, 7, 3, '2024-06-07');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (1, 1, 9, 2, '2024-06-09');
INSERT INTO "public".vente (id_point_vente, id_chariot, id_produit, quantite, date_vente) VALUES (2, 2, 10, 5, '2024-06-10');


