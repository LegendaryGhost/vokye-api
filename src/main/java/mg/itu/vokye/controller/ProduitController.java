package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Produit;
import mg.itu.vokye.service.ProduitService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return service.createProduit(produit);
    }

    // Read All
    @GetMapping
    public Page<Produit> getAllProduit(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllProduit(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return service.getProduitById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long id) {
        return service.updateProduit(id, produit);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        service.deleteProduit(id);
    }

    @GetMapping("/noms-produit")
    public List<String> getNameProduit() {
        return service.getNameProduit();
    }

    @GetMapping("/somme-benefice")
    public List<Object[]> findTotalBeneficeByProduit() {
        return service.findTotalBeneficeByProduit();
    }

    @GetMapping("/somme-perte")
    public List<Object[]> findTotalPerteByProduit() {
        return service.findTotalBeneficeByProduit();
    }

    @GetMapping("/classement-produit")
    public List<Map.Entry<String, Double>> rankProduit() {
        return service.rankProduit();
    }

}
