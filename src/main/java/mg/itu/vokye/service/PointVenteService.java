package mg.itu.vokye.service;

import mg.itu.vokye.dto.GestionDTO;
import mg.itu.vokye.entity.PointVente;
import mg.itu.vokye.repository.PointVenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<GestionDTO> getStatsVentePoint(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // Adjust for 0-based page index
        String sql = "SELECT id_point_vente, localisation, longitude, latitude, date_vente, total_ventes " +
                "FROM v_sale_point " +
                "LIMIT ? OFFSET ?";

        int offset = pageable.getPageNumber() * pageable.getPageSize();
        int limit = pageable.getPageSize();

        List<GestionDTO> results = jdbcTemplate.query(sql, new Object[]{limit, offset}, (rs, rowNum) -> new GestionDTO(
                rs.getLong("id_point_vente"),
                rs.getString("localisation"),
                rs.getDouble("longitude"),
                rs.getDouble("latitude"),
                rs.getDate("date_vente"),
                rs.getDouble("total_ventes")
        ));

        long total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM v_sale_point", Long.class);

        return new PageImpl<>(results, pageable, total);
    }



}
