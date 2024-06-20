package mg.itu.vokye.service;

import mg.itu.vokye.entity.Produit;
import mg.itu.vokye.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class ProduitService {
    private final ProduitRepository repository;

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public Produit createProduit(Produit produit) {
        return repository.save(produit);
    }

    public List<Produit> getAllProduit() {
        return repository.findAll();
    }

    public Produit getProduitById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Produit updateProduit(Long id, Produit employe) {
        Produit existingProduit = repository.findById(id).orElseThrow();
        existingProduit.setNom(employe.getNom());
        existingProduit.setPrix(employe.getPrix());
        return repository.save(existingProduit);
    }

    public void deleteProduit(Long id) {
        repository.deleteById(id);
    }

    public Map<String, Double> findTotalBeneficeByProduit() {
        return repository.findTotalBeneficeByProduit();
    }

    public Map<String, Double> findTotalPerteByProduit() {
        return repository.findTotalPerteByProduit();
    }

    public List<String> getNameProduit() {
        return repository.getNameProduit();
    }

    public List<Map.Entry<String, Double>> rankProduit() {
        Map<String, Double> benefices = repository.findTotalBeneficeByProduit();

        return benefices.entrySet()
                        .stream()
                        .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                        .collect(Collectors.toList());
    }
}
