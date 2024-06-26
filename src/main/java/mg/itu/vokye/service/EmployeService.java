package mg.itu.vokye.service;

import lombok.Data;
import mg.itu.vokye.dto.EmployeDTO;
import mg.itu.vokye.dto.EmployeStatsDTO;
import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.repository.EmployeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final EmployeRepository repository;

    public EmployeService(EmployeRepository repository) {
        this.repository = repository;
    }

    public Employe createEmploye(Employe employe) {
        return repository.save(employe);
    }

    public Page<Employe> getAllEmploye(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Employe getEmployeById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Employe updateEmploye(Long id, Employe employe) {
        Employe existingEmploye = repository.findById(id).orElseThrow();
        existingEmploye.setNom(employe.getNom());
        existingEmploye.setPrenom(employe.getPrenom());
        existingEmploye.setDateEntree(employe.getDateEntree());
        existingEmploye.setDateFin(employe.getDateFin());
        existingEmploye.setTypeEmploye(employe.getTypeEmploye());
        existingEmploye.setGenre(employe.getGenre());
        existingEmploye.setMotDePasse(employe.getMotDePasse());
        existingEmploye.setEmail(employe.getEmail());
        existingEmploye.setPhoto(employe.getPhoto());
        return repository.save(existingEmploye);
    }

    public void deleteEmploye(Long id) {
        repository.deleteById(id);
    }

    public Employe checkEmploye(String email, String motDePasse) {
        return repository.existsByEmailAndMotDePasse(email, motDePasse);
    }

//    public EmployeDTO getEmployeStatsById(Long idEmploye) {
//        return repository.findEmployeStatsById(idEmploye);
//    }

    public EmployeDTO getEmployeStatsById(Long idEmploye) {
        String sql = "SELECT e.nom, e.prenom, e.photo_de_profil, " +
                "e.meilleur_quantite_vente AS meilleurQuantiteVente, " +
                "e.meilleur_chiffre_d_affaires AS meilleurChiffreAffaires " +
                "FROM employe_performance e " +
                "WHERE e.id_employe = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{idEmploye}, new RowMapper<EmployeDTO>() {
            @Override
            public EmployeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new EmployeDTO(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("meilleurQuantiteVente"),
                        rs.getDouble("meilleurChiffreAffaires"),
                        rs.getString("photo_de_profil")
                );
            }
        });
    }
    public List<EmployeDTO> getEmployeStatsByDate(Integer year) {
        String sql = "SELECT e.nom, e.prenom, e.photo_de_profil, " +
                "e.meilleur_quantite_vente AS meilleurQuantiteVente, " +
                "e.meilleur_chiffre_d_affaires AS meilleurChiffreAffaires " +
                "FROM employe_performanceByYear e " +
                "WHERE extract(year from e.date_vente) = ?";

        return jdbcTemplate.query(sql, new Object[]{year}, new RowMapper<EmployeDTO>() {
            @Override
            public EmployeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new EmployeDTO(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("meilleurQuantiteVente"),
                        rs.getDouble("meilleurChiffreAffaires"),
                        rs.getString("photo_de_profil")
                );
            }
        });
    }
}
