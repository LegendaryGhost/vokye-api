package mg.itu.vokye.service;

import mg.itu.vokye.entity.Depense;
import mg.itu.vokye.repository.DepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
        return depenseRepository.findAll(PageRequest.of(page, size));
    }

    public String update(Depense depense) {
        Optional<Depense> optionalDepense = depenseRepository.findById(depense.getId_depense());
        if (optionalDepense.isPresent()) {
            depenseRepository.save(depense);
            return "Succes update";
        }
        return "update failed";
    }

    public String delete(Integer id) {
        depenseRepository.deleteById(id);
        return "deleted succes";
    }

    public Double getSumDepenseBy(Date dateDepense) {

        return depenseRepository.getDepenseAll(dateDepense);
    }

    public Double get_Benefice(Date date) {
        Double sumVente = venteService.getRecetteAll(date);
        Double sumDepense = getSumDepenseBy(date);
        return sumVente - sumDepense;
    }

    public Double get_BeneficeMonth(Integer month, Integer year) {
        Double sumVente = venteService.getRecetteByMonth(month, year);
        Double sumDepense = depenseRepository.getDepenseByMonth(month, year);
        return sumVente - sumDepense;
    }

}
