package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Depense;
import mg.itu.vokye.service.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/depense")
public class DepenseController {
    @Autowired
    private DepenseService depenseService;
    @PostMapping
    public ResponseEntity<Depense> create(@RequestBody Depense depense) {
        Depense depenseCreated = depenseService.create(depense);
        return new ResponseEntity<>(depenseCreated, HttpStatus.CREATED);
    }

    @GetMapping("read")
    public ResponseEntity<List<Depense>> read() {
        List<Depense> depenses = depenseService.read();
        return new ResponseEntity<>(depenses, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody Depense depense) {
        String status = depenseService.update(depense);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        String status =  depenseService.delete(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @GetMapping("/all/depense/{date}")
    public ResponseEntity<Double> getDepenseByDate(
            @PathVariable(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Double result = depenseService.getSumDepenseBy(date);
        if (result == null){
            result = 0.0;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/all/depense/")
    public ResponseEntity<Double> getDepenseAllTime() {
        Double result = depenseService.getSumDepenseBy(null);
        if (result == null){
            result = 0.0;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}

