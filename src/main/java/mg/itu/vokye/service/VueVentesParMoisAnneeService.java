package mg.itu.vokye.service;

import mg.itu.vokye.repository.VueVentesParMoisAnneeRepository;
import org.springframework.stereotype.Service;
import mg.itu.vokye.entity.VueVentesParMoisAnnee;

import java.util.List;

@Service
public class VueVentesParMoisAnneeService {
    private final VueVentesParMoisAnneeRepository repository;

    public VueVentesParMoisAnneeService(VueVentesParMoisAnneeRepository repository) {
        this.repository = repository;
    }

    public List<VueVentesParMoisAnnee> getVentesByIdPointVente(Long id) {
        return repository.findByIdPointVente(id);
    }

    public List<VueVentesParMoisAnnee> getTopVenteMoisById(Long id) {
        return repository.findTopVenteMoisById(id);
    }
}
