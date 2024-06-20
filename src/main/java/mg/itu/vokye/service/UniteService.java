package mg.itu.vokye.service;

import mg.itu.vokye.entity.Unite;
import mg.itu.vokye.repository.UniteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteService {
    private final UniteRepository repository;

    public UniteService(UniteRepository repository) {
        this.repository = repository;
    }

    public Unite createUnite(Unite unite) {
        return repository.save(unite);
    }

    public List<Unite> getAllUnite() {
        return repository.findAll();
    }

    public Unite getUniteById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Unite updateUnite(Long id, Unite unite) {
        Unite existingUnite = repository.findById(id).orElseThrow();
        existingUnite.setNomUnite(unite.getNomUnite());
        return repository.save(existingUnite);
    }

    public void deleteUnite(Long id) {
        repository.deleteById(id);
    }
}
