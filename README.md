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
