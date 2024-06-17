package mg.itu.vokye.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.repository.EmployeRepository;

@Service
public class EmployeService {
    private final EmployeRepository repository;

    public EmployeService(EmployeRepository repository) {
        this.repository = repository;
    }

    public Employe createEmploye(Employe employe) {
        return repository.save(employe);
    }

    public List<Employe> getAllEmployes() {
        return repository.findAll();
    }

    public Employe getEmployeById(int id) {
        return repository.findById(id).orElseThrow();
    }

    public Employe updateEmploye(int id, Employe employe) {
        Employe existingEmploye = repository.findById(id).orElseThrow();
        existingEmploye.setNom(employe.getNom());
        existingEmploye.setPrenom(employe.getPrenom());
        existingEmploye.setDateEntree(employe.getDateEntree());
        existingEmploye.setDateFin(employe.getDateFin());
        existingEmploye.setTypeEmploye(employe.getTypeEmploye());
        return repository.save(existingEmploye);
    }

    public void deleteEmploye(int id) {
        repository.deleteById(id);
    }

    public List<Employe> getEmployesByPoste(String poste) {
        return repository.findByPoste(poste);
    }
}
