package mg.itu.vokye.service;

import mg.itu.vokye.entity.VueGestion;
import mg.itu.vokye.repository.VueGestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueGestionService {

    private final VueGestionRepository repository;

    public VueGestionService(VueGestionRepository repository) {
        this.repository = repository;
    }

    public List<VueGestion> getGestionByYear(Integer annee) {
        return repository.findByAnnee(annee);
    }

    public Double getSumDepensesByAnnee(Integer annee) {
        return repository.sumDepensesByAnnee(annee);
    }

    public Double getSumBeneficesByAnnee(Integer annee) {
        return repository.sumBeneficesByAnnee(annee);
    }
}
