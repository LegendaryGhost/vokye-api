package mg.itu.vokye.service;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mg.itu.vokye.repository.ChiffreAffaireRepository;

@Service
public class ChiffreAffaireService {
    
    private final ChiffreAffaireRepository chiffreAffaireRepository;

    @Autowired
    public ChiffreAffaireService(ChiffreAffaireRepository chiffreAffaireRepository) {
        this.chiffreAffaireRepository = chiffreAffaireRepository;
    }

    public double total_depense(Date d1, Date d2) {
        Date date_first = (d1.compareTo(d2) > 0) ? d2 : d1;
        Date date_last = (d1.compareTo(d2) > 0) ? d1 : d2;
        return chiffreAffaireRepository.total_depense(date_first, date_last);
    }

    public double total_vente(Date d1, Date d2) {
        Date date_first = (d1.compareTo(d2) > 0) ? d2 : d1;
        Date date_last = (d1.compareTo(d2) > 0) ? d1 : d2;
        return chiffreAffaireRepository.total_vente(date_first, date_last);
    }

    public double chiffreAffaire(Date d1, Date d2) {
        Date date_first = (d1.compareTo(d2) > 0) ? d2 : d1;
        Date date_last = (d1.compareTo(d2) > 0) ? d1 : d2;
        return chiffreAffaireRepository.total_vente(date_first, date_last) - chiffreAffaireRepository.total_depense(date_first, date_last);
    }
}
