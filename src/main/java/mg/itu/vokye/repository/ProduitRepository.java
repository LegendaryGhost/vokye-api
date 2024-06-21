package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Map;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT p.nom AS nom, SUM(v.quantite * p.prix) AS totalBenefice " +
                        "FROM Produit p JOIN Vente v ON p.id = v.produit.id " +
                        "GROUP BY p.nom")
    Map<String, Double> findTotalBeneficeByProduit();

    @Query("SELECT p.nom, SUM(a.prix) AS total_perte " +
                       "FROM Produit p JOIN achat_ingredient a ON p.id_produit = a.id_ingredient " +
                       "GROUP BY p.nom")
    Map<String, Double> findTotalPerteByProduit();

    @Query("SELECT nom FROM Produit")
    List<String> getNameProduit();

}
