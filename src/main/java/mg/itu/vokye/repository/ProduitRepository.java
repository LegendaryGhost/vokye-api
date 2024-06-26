package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query(value = "SELECT p.nom AS nom, SUM(v.quantite * p.prix) AS totalBenefice " +
            "FROM produit p " +
            "JOIN vente v ON p.id_produit = v.id_produit " +
            "GROUP BY p.nom ", nativeQuery = true)
    List<Object[]> findTotalBeneficeByProduit();


    @Query(value = "SELECT p.nom AS nom, SUM(ai.quantite * ai.prix_unitaire) AS total_perte " +
            "FROM produit p " +
            "JOIN ingredient_produit ip ON p.id_produit = ip.id_produit " +
            "JOIN achat_ingredient ai ON ip.id_ingredient = ai.id_ingredient " +
            "GROUP BY p.nom ", nativeQuery = true)
    List<Object[]> findTotalPerteByProduit();


    @Query("SELECT nom FROM Produit")
    List<String> getNameProduit();

}

