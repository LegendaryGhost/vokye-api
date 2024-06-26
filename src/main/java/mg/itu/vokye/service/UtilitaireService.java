package mg.itu.vokye.service;

import mg.itu.vokye.entity.Utilitaire;
import mg.itu.vokye.repository.UtilitaireRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UtilitaireService {
    private final UtilitaireRepository repository;

    public UtilitaireService(UtilitaireRepository repository) {
        this.repository = repository;
    }

    public Utilitaire createUtilitaire(Utilitaire utilitaire) {
        return repository.save(utilitaire);
    }

    public Page<Utilitaire> getAllUtilitaire(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Utilitaire getUtilitaireById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Utilitaire updateUtilitaire(Long id, Utilitaire utilitaire) {
        Utilitaire existingUtilitaire = repository.findById(id).orElseThrow();
        existingUtilitaire.setNom(utilitaire.getNom());
        existingUtilitaire.setUnite(utilitaire.getUnite());
        return repository.save(existingUtilitaire);
    }

    public void deleteUtilitaire(Long id) {
        repository.deleteById(id);
    }
}
