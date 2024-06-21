package mg.itu.vokye.service;

import mg.itu.vokye.entity.Etat;
import mg.itu.vokye.repository.EtatRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EtatService {
    private final EtatRepository repository;

    public EtatService(EtatRepository repository) {
        this.repository = repository;
    }

    public Etat createEtat(Etat etat) {
        return repository.save(etat);
    }

    public Page<Etat> getAllEtat(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
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
