package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT SUM(p.prix) AS sum_vente " +
            "FROM Vente v " +
            "JOIN Chariot c ON v.id_chariot = c.id_chariot " +
            "JOIN Employe e ON c.id_employe = e.id_employe " +
            "JOIN Produit p ON v.id_produit = p.id_produit " +
            "WHERE e.id_employe = :employeeId " +
            "AND (:dateVente IS NULL OR v.date_vente = :dateVente) ",
            nativeQuery = true)
    Double getRecette(@Param("employeeId") Integer employeeId, @Param("dateVente") LocalDate dateVente);

    @Query(value = "SELECT SUM(p.prix) - :cota  AS sum_vente " +
            "FROM Vente v " +
            "JOIN Chariot c ON v.id_chariot = c.id_chariot " +
            "JOIN Employe e ON c.id_employe = e.id_employe " +
            "JOIN Produit p ON v.id_produit = p.id_produit " +
            "WHERE e.id_employe = :employeeId " +
            "AND (:dateVente IS NULL OR v.date_vente = :dateVente) " +
            "GROUP BY e.id_employe " +
            "HAVING SUM(p.prix) - :cota > 0",
            nativeQuery = true)
    Double getBenefice(@Param("employeeId") Integer employeeId, @Param("cota") Double cota, @Param("dateVente") LocalDate dateVente);


    @Query(value = "SELECT SUM(p.prix) - :cota  AS sum_vente " +
            "FROM Vente v " +
            "JOIN Chariot c ON v.id_chariot = c.id_chariot " +
            "JOIN Employe e ON c.id_employe = e.id_employe " +
            "JOIN Produit p ON v.id_produit = p.id_produit " +
            "WHERE e.id_employe = :employeeId " +
            "AND (:dateVente IS NULL OR v.date_vente = :dateVente) " +
            "GROUP BY e.id_employe " +
            "HAVING SUM(p.prix) - :cota < 0",
            nativeQuery = true)
    Double getPerte(@Param("employeeId") Integer employeeId, @Param("cota") Double cota, @Param("dateVente") LocalDate dateVente);


}