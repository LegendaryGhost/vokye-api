package mg.itu.vokye.service;



import mg.itu.vokye.dto.EmployeStatsDTO;
import mg.itu.vokye.entity.Vente;
import mg.itu.vokye.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private VenteRepository venteRepository;

    public Vente create(Vente vente) {
        // Assure-toi que l'ID de vente est null pour s'assurer que c'est une nouvelle vente
        if (vente.getId_vente() != null) {
            throw new IllegalArgumentException("L'ID de vente doit être nul pour une nouvelle vente");
        }
        // Assure-toi que la quantité n'est pas nulle ou négative
        if (vente.getQuantite() == null || vente.getQuantite() <= 0) {
            throw new IllegalArgumentException("La quantité de vente doit être spécifiée et être supérieure à zéro");
        }
        // Enregistre la nouvelle vente
        return venteRepository.save(vente);
    }

    public Page<Vente> read(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        if (size <= 0) {
            size = 10;
        }
        return venteRepository.findAll(PageRequest.of(page, size));
    }

    public String update(Vente vente) {
        // Vérifie si la vente existe déjà
        Optional<Vente> optionalExistingVente = venteRepository.findById(vente.getId_vente());

        if (optionalExistingVente.isPresent()) {
            Vente existingVente = optionalExistingVente.get();

            // Vérifie si la quantité à mettre à jour est valide
            if (vente.getQuantite() != null && vente.getQuantite() > 0) {
                existingVente.setQuantite(vente.getQuantite());
                venteRepository.save(existingVente);
                return "Mise à jour réussie";
            } else {
                throw new IllegalArgumentException("La quantité de vente doit être spécifiée et être supérieure à zéro");
            }
        } else {
            throw new RuntimeException("Vente non trouvée avec l'ID: " + vente.getId_vente());
        }
    }

    public String delete(Integer idVente) {
        venteRepository.deleteById(idVente);
        return "deleted succes";
    }

    public Optional<Vente> getVenteById(Integer idVente) {
        return venteRepository.findById(idVente);
    }

// Recette benefice et perte //

    public Double getRecetteAll(Date dateVente) {
        return venteRepository.getRecetteAll(dateVente);
    }

    public Double getRecetteByMonth(Integer month,Integer year){
        return venteRepository.getRecetteAllMensuel(month,year);
    }

//    public Double getRecette(Integer idEmploye) {
//        return venteRepository.getRecette(idEmploye, null);
//    }
//
//    public Double getRecetteByDate(Integer idEmploye, LocalDate dateVente) {
//        return venteRepository.getRecette(idEmploye, dateVente);
//    }
//
//    // benefice
//
//
//    public Double getBenefice(Integer idEmploye) {
//        return venteRepository.getBenefice(idEmploye, null
//        );
//    }
//
//    public Double getBeneficeByDate(Integer idEmploye, LocalDate dateVente) {
//        return venteRepository.getBenefice(idEmploye, dateVente
//        );
//    }
//
//    // perte
//
//    public Double getPerte(Integer idEmploye) {
//        return venteRepository.getPerte(idEmploye, null
//        );
//    }
//
//    public Double getPerteByDate(Integer idEmploye, LocalDate dateVente) {
//        return venteRepository.getPerte(idEmploye, dateVente);
//    }

    // Employe statistique
    public List<EmployeStatsDTO> getStatsVenteEmp(Integer employeeId, Date dateVente) {
        String sql = "SELECT nom, prenom, SUM(sum_vente) AS recette, SUM(sum_vente - cota) AS validcota, " +
                "CAST(? AS DATE) AS in_date,nombre_vente " +
                "FROM recette_vente " +
                "WHERE id_employe = ? " +
                "AND (CAST(? AS DATE) IS NULL OR date_vente = CAST(? AS DATE)) " +
                "GROUP BY id_employe, nom, prenom,nombre_vente";

        return jdbcTemplate.query(sql, new Object[]{dateVente, employeeId, dateVente, dateVente}, (rs, rowNum) -> new EmployeStatsDTO(
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getDouble("recette"),
                rs.getDouble("validcota"),
                dateVente,
                rs.getInt("nombre_vente")

        ));
    }

    public Double getCountVente(Date date){
        Double count =  venteRepository.getCountVente(date);
        return Objects.requireNonNullElse(count, 0.0);
    }

}
