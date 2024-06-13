INSERT INTO type_employe (designation, salaire_base, pourcentage)
VALUES
    ('Cuisinier', 500000.00, 10),
    ('Livreur', 400000.00, 8),
    ('Vendeur', 600000.00, 12);

INSERT INTO employe (id_type_employe, nom, prenom, mot_de_passe, date_entree, date_fin)
VALUES
    (1, 'Rakoto', 'Andriana', 'mdp123', '2020-01-01', NULL),
    (1, 'Ravelo', 'Mbolatiana', 'mdp123', '2020-02-01', NULL),
    (2, 'Rasolofonirina', 'Lalao', 'mdp123', '2020-03-01', NULL),
    (2, 'Rakotovao', 'Nirina', 'mdp123', '2020-04-01', NULL),
    (3, 'Ratsimbazafy', 'Fara', 'mdp123', '2020-05-01', NULL),
    (3, 'Rakotonirina', 'Sitraka', 'mdp123', '2020-06-01', NULL),
    (1, 'Rakotomalala', 'Mamy', 'mdp123', '2020-07-01', NULL),
    (2, 'Rasolofonirina', 'Lova', 'mdp123', '2020-08-01', NULL),
    (3, 'Rakotoarisoa', 'Tiana', 'mdp123', '2020-09-01', NULL);
