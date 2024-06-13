package mg.itu.vokye.controller;



import mg.itu.vokye.entity.Vente;
import mg.itu.vokye.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;

    @GetMapping("read")
    public ResponseEntity<List<Vente>> getAllVentes() {
        List<Vente> ventes = venteService.read();
        return new ResponseEntity<>(ventes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vente> getUserById(@PathVariable Integer id) {
        Optional<Vente> vente = venteService.getVenteById(id);
        return vente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Vente> createUser(@RequestBody Vente vente) {
        Vente venteCreated = venteService.create(vente);
        return new ResponseEntity<>(venteCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        String status =  venteService.delete(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    // demande autre que le crud

    @GetMapping("/recette/{id}")
    public ResponseEntity<Double> getRecetteByEmp(@PathVariable Integer id){
        Double recette =  venteService.getRecette(id);
        return new ResponseEntity<>(recette,HttpStatus.OK);
    }
    @GetMapping("/recette/{id}/{date}")
    public ResponseEntity<Double> getRecetteByEmpDate(@PathVariable Integer id, @PathVariable LocalDate date_recette){
        Double recette =  venteService.getRecetteByDate(id,date_recette);
        return new ResponseEntity<>(recette,HttpStatus.OK);
    }

    @GetMapping("/benefice/{id}")
    public ResponseEntity<Double> getBeneficeByEmp(@PathVariable Integer id){
        Double recette =  venteService.getBenefice(id);
        return new ResponseEntity<>(recette,HttpStatus.OK);
    }
    @GetMapping("/benefice/{id}/{date}")
    public ResponseEntity<Double> getBeneficeByEmpDate(@PathVariable Integer id, @PathVariable LocalDate date_recette){
        Double recette =  venteService.getBeneficeByDate(id,date_recette);
        return new ResponseEntity<>(recette,HttpStatus.OK);
    }

    @GetMapping("/perte/{id}")
    public ResponseEntity<Double> getPerteByEmp(@PathVariable Integer id){
        Double recette =  venteService.getPerte(id);
        return new ResponseEntity<>(recette,HttpStatus.OK);
    }
    @GetMapping("/perte/{id}/{date}")
    public ResponseEntity<Double> getPerteByEmpDate(@PathVariable Integer id, @PathVariable LocalDate date_recette){
        Double recette =  venteService.getPerteByDate(id,date_recette);
        return new ResponseEntity<>(recette,HttpStatus.OK);
    }




}
