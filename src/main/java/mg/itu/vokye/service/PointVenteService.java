package mg.itu.vokye.service;

import mg.itu.vokye.entity.PointVente;
import mg.itu.vokye.repository.PointVenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointVenteService {
    private final PointVenteRepository repository;

    public PointVenteService(PointVenteRepository repository) {
        this.repository = repository;
    }

    public PointVente createPointVente(PointVente pointVente) {
        return repository.save(pointVente);
    }

    public List<PointVente> getAllPointVentes() {
        return repository.findAll();
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
}
