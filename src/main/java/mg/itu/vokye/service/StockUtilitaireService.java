package mg.itu.vokye.service;

import mg.itu.vokye.entity.StockUtilitaire;
import mg.itu.vokye.repository.StockUtilitaireRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockUtilitaireService {
    private final StockUtilitaireRepository repository;

    public StockUtilitaireService(StockUtilitaireRepository repository) {
        this.repository = repository;
    }

    public StockUtilitaire createStockUtilitaire(StockUtilitaire stockUtilitaire) {
        return repository.save(stockUtilitaire);
    }

    public List<StockUtilitaire> getAllStockUtilitaire() {
        return repository.findAll();
    }

    public StockUtilitaire getStockUtilitaireById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public StockUtilitaire updateStockUtilitaire(Long id, StockUtilitaire stockUtilitaire) {
        StockUtilitaire existingStockUtilitaire = repository.findById(id).orElseThrow();
        existingStockUtilitaire.setUtilitaire(stockUtilitaire.getUtilitaire());
        existingStockUtilitaire.setQuantite(stockUtilitaire.getQuantite());
        return repository.save(existingStockUtilitaire);
    }

    public void deleteStockUtilitaire(Long id) {
        repository.deleteById(id);
    }
}
