package mg.itu.vokye.service;

import mg.itu.vokye.dto.VueSommeVentesPointVenteDTO;
import mg.itu.vokye.repository.VueSommeVentesPointVenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VueSommeVentesPointVenteService {
    private final VueSommeVentesPointVenteRepository repository;

    public VueSommeVentesPointVenteService(VueSommeVentesPointVenteRepository repository) {
        this.repository = repository;
    }

    public List<VueSommeVentesPointVenteDTO> getAllVentes() {
        return repository.findAllVentes();
    }

    public List<VueSommeVentesPointVenteDTO> getVentesBetweenDates(LocalDate dateMin, LocalDate dateMax) {
        return repository.findVentesBetweenDates(dateMin, dateMax);
    }

    public List<VueSommeVentesPointVenteDTO> getVentesFromDate(LocalDate dateMin) {
        return repository.findVentesFromDate(dateMin);
    }

    public List<VueSommeVentesPointVenteDTO> getVentesUpToDate(LocalDate dateMax) {
        return repository.findVentesUpToDate(dateMax);
    }
}
