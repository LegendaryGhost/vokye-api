package mg.itu.vokye.repository;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import mg.itu.vokye.entity.ChiffreAffaire;

@Repository
public interface ChiffreAffaireRepository extends JpaRepository<ChiffreAffaire, Long> {

    @Query("SELECT SUM(d.prix) FROM Depense d WHERE d.date_depense > :d1 AND d.date_depense < :d2")
    double total_depense(@Param("d1") Date d1, @Param("d2") Date d2);

    @Query("SELECT SUM(v.quantite * p.prix) FROM Vente v JOIN v.produit p WHERE v.date_vente > :d1 AND v.date_vente < :d2")
    double total_vente(@Param("d1") Date d1, @Param("d2") Date d2);
}
