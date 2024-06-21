package mg.itu.vokye.service;

import mg.itu.vokye.entity.EtatUtilitaire;
import mg.itu.vokye.repository.EtatUtilitaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatUtilitaireService {
    private final EtatUtilitaireRepository repository;

    public EtatUtilitaireService(EtatUtilitaireRepository repository) {
        this.repository = repository;
    }

    public EtatUtilitaire createEtatUtilitaire(EtatUtilitaire etatUtilitaire) {
        return repository.save(etatUtilitaire);
    }

    public List<EtatUtilitaire> getAllEtatUtilitaire() {
        return repository.findAll();
    }

    public EtatUtilitaire getEtatUtilitaireById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public EtatUtilitaire updateEtatUtilitaire(Long id, EtatUtilitaire etatUtilitaire) {
        EtatUtilitaire existingEtatUtilitaire = repository.findById(id).orElseThrow();
        existingEtatUtilitaire.setUtilitaire(etatUtilitaire.getUtilitaire());
        existingEtatUtilitaire.setEtat(etatUtilitaire.getEtat());
        existingEtatUtilitaire.setDateEtatUtilitaire(etatUtilitaire.getDateEtatUtilitaire());
        return repository.save(existingEtatUtilitaire);
    }

    public void deleteEtatUtilitaire(Long id) {
        repository.deleteById(id);
    }
}
