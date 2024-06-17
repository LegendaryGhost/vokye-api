package mg.itu.vokye.service;


import mg.itu.vokye.entity.Vente;
import mg.itu.vokye.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;
    private Double cota = 100000.0;

    public Vente create(Vente vente) {
        // Assure-toi que l'ID de vente est null pour s'assurer que c'est une nouvelle vente
        if (vente.getId_vente() != null) {
            throw new IllegalArgumentException("L'ID de vente doit être nul pour une nouvelle vente");
        }
        // Assure-toi que la quantité n'est pas nulle ou négative
        if (vente.getQuantite() == null || vente.getQuantite() <= 0) {
            throw new IllegalArgumentException("La quantité de vente doit être spécifiée et être supérieure à zéro");
        }
        // Enregistre la nouvelle vente
        return venteRepository.save(vente);
    }

    public List<Vente> read() {
        return venteRepository.findAll();
    }

    public String update(Vente vente) {
        // Vérifie si la vente existe déjà
        Optional<Vente> optionalExistingVente = venteRepository.findById(vente.getId_vente());

        if (optionalExistingVente.isPresent()) {
            Vente existingVente = optionalExistingVente.get();

            // Vérifie si la quantité à mettre à jour est valide
            if (vente.getQuantite() != null && vente.getQuantite() > 0) {
                existingVente.setQuantite(vente.getQuantite());
                venteRepository.save(existingVente);
                return "Mise à jour réussie";
            } else {
                throw new IllegalArgumentException("La quantité de vente doit être spécifiée et être supérieure à zéro");
            }
        } else {
            throw new RuntimeException("Vente non trouvée avec l'ID: " + vente.getId_vente());
        }
    }

    public String delete(Integer idVente) {
        venteRepository.deleteById(idVente);
        return "deleted succes";
    }

    public Optional<Vente> getVenteById(Integer idVente) {
        return venteRepository.findById(idVente);
    }

// Recette benefice et perte //

    public Double getRecetteAll(LocalDate dateVente) {
        return venteRepository.getRecetteAll(dateVente);
    }

    public Double getRecette(Integer idEmploye) {
        return venteRepository.getRecette(idEmploye, null);
    }

    public Double getRecetteByDate(Integer idEmploye, LocalDate dateVente) {
        return venteRepository.getRecette(idEmploye, dateVente);
    }

    // benefice


    public Double getBenefice(Integer idEmploye) {
        return venteRepository.getBenefice(idEmploye, cota, null
        );
    }

    public Double getBeneficeByDate(Integer idEmploye, LocalDate dateVente) {
        return venteRepository.getBenefice(idEmploye, cota, dateVente
        );
    }

    // perte

    public Double getPerte(Integer idEmploye) {
        return venteRepository.getPerte(idEmploye, cota, null
        );
    }

    public Double getPerteByDate(Integer idEmploye, LocalDate dateVente) {
        return venteRepository.getPerte(idEmploye, cota, dateVente
        );
    }
}
