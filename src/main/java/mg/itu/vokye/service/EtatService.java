package mg.itu.vokye.service;

import mg.itu.vokye.entity.Etat;
import mg.itu.vokye.repository.EtatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatService {
    private final EtatRepository repository;

    public EtatService(EtatRepository repository) {
        this.repository = repository;
    }

    public Etat createEtat(Etat etat) {
        return repository.save(etat);
    }

    public List<Etat> getAllEtat() {
        return repository.findAll();
    }

    public Etat getEtatById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Etat updateEtat(Long id, Etat etat) {
        Etat existingEtat = repository.findById(id).orElseThrow();
        existingEtat.setNom(etat.getNom());
        return repository.save(existingEtat);
    }

    public void deleteEtat(Long id) {
        repository.deleteById(id);
    }
}
