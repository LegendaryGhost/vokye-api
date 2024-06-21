package mg.itu.vokye.service;

import mg.itu.vokye.entity.StockUtilitaire;
import mg.itu.vokye.repository.StockUtilitaireRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StockUtilitaireService {
    private final StockUtilitaireRepository repository;

    public StockUtilitaireService(StockUtilitaireRepository repository) {
        this.repository = repository;
    }

    public StockUtilitaire createStockUtilitaire(StockUtilitaire stockUtilitaire) {
        return repository.save(stockUtilitaire);
    }

    public Page<StockUtilitaire> getAllStockUtilitaire(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public StockUtilitaire getStockUtilitaireById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public StockUtilitaire updateStockUtilitaire(Long id, StockUtilitaire StockUtilitaire) {
        StockUtilitaire existingStockUtilitaire = repository.findById(id).orElseThrow();
        existingStockUtilitaire.setUtilitaire(StockUtilitaire.getUtilitaire());
        existingStockUtilitaire.setQuantite(StockUtilitaire.getQuantite());
        return repository.save(existingStockUtilitaire);
    }

    public void deleteStockUtilitaire(Long id) {
        repository.deleteById(id);
    }
}
