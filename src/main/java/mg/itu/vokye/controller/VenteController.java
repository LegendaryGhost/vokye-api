package mg.itu.vokye.controller;



import mg.itu.vokye.dto.EmployeStatsDTO;
import mg.itu.vokye.entity.Vente;
import mg.itu.vokye.service.VentePredictionService;
import mg.itu.vokye.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private VentePredictionService ventePredictionService;

    @GetMapping("read")
    public ResponseEntity<List<Vente>> getAllVentes() {
        List<Vente> ventes = venteService.read();
        return new ResponseEntity<>(ventes, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Vente> getVenteById(@PathVariable Integer id) {
        Optional<Vente> vente = venteService.getVenteById(id);
        return vente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Vente> createVente(@RequestBody Vente vente) {
        Vente venteCreated = venteService.create(vente);
        return new ResponseEntity<>(venteCreated, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Vente> updateVente(@RequestBody Vente vente) {
        Vente venteCreated = venteService.create(vente);
        return new ResponseEntity<>(venteCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVente(@PathVariable Integer id) {
        String status =  venteService.delete(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    // demande autre que le crud
    // type soit recette ou benefice perte


    @GetMapping("/all/recette")
    public ResponseEntity<Double> getRecetteDateAll() {
        Double result = venteService.getRecetteAll(null);
        if (result == null){
            result = 0.0;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/all/recette/{date}")
    public ResponseEntity<Double> getRecetteDateAllInDate(
            @PathVariable(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        Double result = venteService.getRecetteAll(date);
        if (result == null){
            result = 0.0;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }




// par id employe
//    @GetMapping("/{type}/{id}")
//    public ResponseEntity<Double> getRecetteOrBeneficeOrPerteByEmp(
//            @PathVariable String type, @PathVariable Integer id) {
//        Double result = getResultByTypeAndId(type, id, null);
//        if (result == null){
//            result = 0.0;
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//    @GetMapping("/{type}/{id}/{date}")
//    public ResponseEntity<Double> getRecetteOrBeneficeOrPerteByEmpDate(
//            @PathVariable String type, @PathVariable Integer id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        Double result = getResultByTypeAndId(type, id, date);
//        if (result == null){
//            result = 0.0;
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//    private Double getResultByTypeAndId(String type, Integer id, LocalDate date) {
//        return switch (type) {
//            case "recette" -> (date == null) ? venteService.getRecette(id) : venteService.getRecetteByDate(id, date);
//            case "benefice" -> (date == null) ? venteService.getBenefice(id) : venteService.getBeneficeByDate(id, date);
//            case "perte" -> (date == null) ? venteService.getPerte(id) : venteService.getPerteByDate(id, date);
//            default -> throw new IllegalArgumentException("Invalid type: " + type);
//        };
//    }


    /// Prediction de chiffre d affaire a une date donne

    @GetMapping("/prediction/{date}")
    public ResponseEntity<Double> predictVente(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        double prediction = ventePredictionService.predictChiffreAffaireIn(date);
        return ResponseEntity.ok(prediction);
    }
    //Statistique employe
    @GetMapping("/stats/employe")
    public List<EmployeStatsDTO> getStatEmployeBydate(
            @RequestParam Integer employeeId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateVente) {
        return venteService.getStatsVenteEmp(employeeId, dateVente);
    }



}
