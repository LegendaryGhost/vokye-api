package mg.itu.vokye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class VentePredictionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // prediction
    public double predictChiffreAffaireIn(LocalDate date) {
        String sql = "SELECT DATE(date_vente) AS jour, SUM(vente.quantite * produit.prix) AS recette_journaliere " +
                "FROM vente " +
                "JOIN produit ON vente.id_produit = produit.id_produit " +
                "GROUP BY DATE(date_vente)";

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

        int n = results.size();
        if (n == 0) {
            return 0;
        }

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        LocalDate today = LocalDate.now();

        for (Map<String, Object> row : results) {
            LocalDate venteDate = LocalDate.parse(row.get("jour").toString());
            double recetteJournaliere = ((Number) row.get("recette_journaliere")).doubleValue();

            long days = venteDate.toEpochDay() - today.toEpochDay();

            sumX += days;
            sumY += recetteJournaliere;
            sumXY += days * recetteJournaliere;
            sumX2 += days * days;
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        long targetDays = date.toEpochDay() - today.toEpochDay();
        return slope * targetDays + intercept;
    }
}
