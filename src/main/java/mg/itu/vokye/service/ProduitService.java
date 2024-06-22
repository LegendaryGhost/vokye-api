package mg.itu.vokye.service;

import mg.itu.vokye.entity.Produit;
import mg.itu.vokye.repository.ProduitRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Page<Produit> getAllProduit(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
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

    public List<Object[]> findTotalBeneficeByProduit() {
        return repository.findTotalBeneficeByProduit();
    }

    public List<Object[]> findTotalPerteByProduit() {
        return repository.findTotalPerteByProduit();
    }

    public List<String> getNameProduit() {
        return repository.getNameProduit();
    }

    public List<Map.Entry<String, Double>> rankProduit() {
    List<Object[]> benefices = repository.findTotalBeneficeByProduit();

    return benefices.stream()
                    .map(obj -> {
                        String produitNom = (String) obj[0];
                        BigDecimal bigDecimalBenefice = (BigDecimal) obj[1];
                        Double benefice = bigDecimalBenefice.doubleValue();
                        return Map.entry(produitNom, benefice);
                    })
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .collect(Collectors.toList());
}
}
