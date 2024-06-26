package mg.itu.vokye.service;

import mg.itu.vokye.entity.Depense;
import mg.itu.vokye.repository.DepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DepenseService {
    @Autowired
    DepenseRepository depenseRepository;

    @Autowired
    VenteService venteService;

    public Depense create(Depense depense) {
        if (depense.getId_depense() == null) {
            return depenseRepository.save(depense);
        }
        return null;
    }


    public Page<Depense> readDepense(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        if (size <= 0) {
            size = 10;
        }
        return depenseRepository.findAll(PageRequest.of(page, size));
    }

    public Depense update(Integer id, Depense depenseDetails) {
        Depense existingDepense = depenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dépense non trouvée avec l'ID: " + id));

        // Mise à jour des champs de l'entité existante
        if (depenseDetails.getTypeDepense() != null) {
            existingDepense.setTypeDepense(depenseDetails.getTypeDepense());
        }

        if (depenseDetails.getPrix() != null) {
            existingDepense.setPrix(depenseDetails.getPrix());
        }

        if (depenseDetails.getDate_depense() != null) {
            existingDepense.setDate_depense(depenseDetails.getDate_depense());
        }

        return depenseRepository.save(existingDepense);
    }

    public String delete(Integer id) {
        depenseRepository.deleteById(id);
        return "deleted succes";
    }

    public Double getSumDepenseBy(Date dateDepense) {

        return depenseRepository.getDepenseAll(dateDepense);
    }

    public Double get_Benefice(Date date) {
        Double sumVente = venteService.getRecetteAll(date) != null ? venteService.getRecetteAll(date) : 0;
        Double sumDepense = getSumDepenseBy(date) != null ? getSumDepenseBy(date) : 0;
        return sumVente - sumDepense;
    }


    public Double get_BeneficeMonth(Integer month, Integer year) {
        Double sumVente = venteService.getRecetteByMonth(month, year);
        Double sumDepense = depenseRepository.getDepenseByMonth(month, year);
        return sumVente - sumDepense;
    }

}
