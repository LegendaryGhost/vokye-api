package mg.itu.vokye.service;


import mg.itu.vokye.entity.Depense;
import mg.itu.vokye.repository.DepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Depense> read(){
        return depenseRepository.findAll();
    }

    public String update(Depense depense) {
        Optional<Depense> optionalDepense = depenseRepository.findById(depense.getId_depense());
        if (optionalDepense.isPresent()) {
            depenseRepository.save(depense);
            return "Succes update";
        }
        return "update failed";
    }

    public String delete(Integer id){
        depenseRepository.deleteById(id);
        return "deleted succes";
    }
    public Double getSumDepenseBy(LocalDate dateDepense){

        return depenseRepository.getDepenseAll(dateDepense);
    }

    public Double get_Benefice(LocalDate date){
       Double sumVente = venteService.getRecetteAll(date);
       Double sumDepense = getSumDepenseBy(date);
       return  sumVente - sumDepense;
    }

}
