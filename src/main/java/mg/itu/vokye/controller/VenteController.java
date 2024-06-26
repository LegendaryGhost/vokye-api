package mg.itu.vokye.controller;

import mg.itu.vokye.dto.EmployeStatsDTO;
import mg.itu.vokye.entity.Vente;
import mg.itu.vokye.service.VentePredictionService;
import mg.itu.vokye.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private VentePredictionService ventePredictionService;

    @GetMapping("")
    public Page<Vente> getAllVentes(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return venteService.read(page, size);
    }

    @GetMapping("/{id}")
    public Vente getVenteById(@PathVariable Integer id) {
        return venteService.getVenteById(id);
    }


    @PostMapping
    public ResponseEntity<Vente> createVente(@RequestBody Vente vente) {
        Vente venteCreated = venteService.create(vente);
        return new ResponseEntity<>(venteCreated, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vente> updateVente(@PathVariable Integer id,@RequestBody Vente vente) {
        Vente venteCreated = venteService.update(id,vente);
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
    public ResponseEntity<Double> predictVente(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date) {
        try {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            Date sqlDate = Date.valueOf(localDate);
            double prediction = ventePredictionService.predictChiffreAffaireIn(sqlDate);
            return ResponseEntity.ok(prediction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //Statistique employe
    @GetMapping("/stats/employe")
    public List<EmployeStatsDTO> getStatEmployeBydate(
            @RequestParam Integer employeeId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateVente) {
        return venteService.getStatsVenteEmp(employeeId, dateVente);
    }



}
