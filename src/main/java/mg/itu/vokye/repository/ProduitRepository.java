package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT p.nom AS nom, SUM(v.quantite * p.prix) AS totalBenefice " +
            "FROM produit p " +
            "JOIN vente v ON p.id_produit = v.id_produit " +
            "GROUP BY p.nom ",nativeQuery = true)
    List<Object[]> findTotalBeneficeByProduit();

    @Query("SELECT p.nom, SUM(a.quantite * a.prixUnitaire) AS total_perte " +
                       "FROM Produit p JOIN AchatIngredient a ON p.id_produit = a.ingredient.id " +
                       "GROUP BY p.nom")
    List<Object[]> findTotalPerteByProduit();

    @Query("SELECT nom FROM Produit")
    List<String> getNameProduit();

}

