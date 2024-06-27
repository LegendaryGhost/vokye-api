package mg.itu.vokye.service;

import mg.itu.vokye.dto.GestionDTO;
import mg.itu.vokye.entity.PointVente;
import mg.itu.vokye.repository.PointVenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PointVenteService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final PointVenteRepository repository;

    public PointVenteService(PointVenteRepository repository) {
        this.repository = repository;
    }

    public PointVente createPointVente(PointVente pointVente) {
        return repository.save(pointVente);
    }

    public Page<PointVente> getAllPointVente(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public PointVente getPointVenteById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public PointVente updatePointVente(Long id, PointVente pointVente) {
        PointVente existingPointVente = repository.findById(id).orElseThrow();
        existingPointVente.setLocalisation(pointVente.getLocalisation());
        existingPointVente.setLongitude(pointVente.getLongitude());
        existingPointVente.setLatitude(pointVente.getLatitude());
        return repository.save(existingPointVente);
    }

    public void deletePointVente(Long id) {
        repository.deleteById(id);
    }
    public List<GestionDTO> getStatsVentePoint(int page, int size) {
        String sql = "SELECT id_point_vente, localisation, longitude, latitude, date_vente, total_ventes " +
                "FROM v_sale_point " +
                "LIMIT ? OFFSET ?";

        int offset = (page - 1) * size;

        return jdbcTemplate.query(sql, new Object[]{size, offset}, (rs, rowNum) -> new GestionDTO(
                rs.getLong("id_point_vente"),
                rs.getString("localisation"),
                rs.getDouble("longitude"),
                rs.getDouble("latitude"),
                rs.getDate("date_vente"),
                rs.getDouble("total_ventes")
        ));
    }



}
