 =======
 LES MODIFICATIONS:
    - shema.sql : nampiko ny table employe sy type employe dia mila averina alefa anaty base
    - Dans le dossier src\main\java\mg\itu\vokye\controller/EmployeController
    src\main\java\mg\itu\vokye\controller\TypeEmployeController.java
    - Dans le dossier src\main\java\mg\itu\vokye\entity\Employe.java
    src\main\java\mg\itu\vokye\entity\TypeEmploye.java
    - Dans le dossier src\main\java\mg\itu\vokye\repository\EmployeRepository.java
    src\main\java\mg\itu\vokye\repository\TypeEmployeRepository.java
    
    -Point vente CRUD: "/api/pointVente"
    -Vente par point vente entre 2 dates: "/api/vueSommeVentesPointVente": 
      - Url function("/"): argument dateMin , dateMax 

   -changement dans schema.sql : vue vue_somme_ventes_point_vente(vue teo aloha fa tsy hitako tato) et vue_ventes_par_mois_annee(vue ho any charte)
   -profile point vente :"/api/vueVentesParMoisAnnee/top/{id}"
      -contient liste du meilleure vente liste en cas d'egalite(liste parce que parfois il y a plusieurs mois qui ait le max vente)
      -prends juste indice 0
      -argument id
      -utilisation profil pointVente

   -charte point vente :"/api/vueVentesParMoisAnnee/{id}"
      -contient liste des ventes par mois et par annee
      -argument id
      -utilisation charte pointVente
   