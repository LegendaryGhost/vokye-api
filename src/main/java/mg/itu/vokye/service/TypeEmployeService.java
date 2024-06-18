package mg.itu.vokye.service;

import mg.itu.vokye.entity.TypeEmploye;
import mg.itu.vokye.repository.TypeEmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEmployeService {
    private final TypeEmployeRepository repository;

    public TypeEmployeService(TypeEmployeRepository repository) {
        this.repository = repository;
    }

    public TypeEmploye createTypeEmploye(TypeEmploye typeEmploye) {
        return repository.save(typeEmploye);
    }

    public List<TypeEmploye> getAllTypeEmployes() {
        return repository.findAll();
    }

    public TypeEmploye getTypeEmployeById(int id) {
        return repository.findById(id).orElseThrow();
    }

    public TypeEmploye updateTypeEmploye(int id, TypeEmploye typeEmploye) {
        TypeEmploye existingTypeEmploye = repository.findById(id).orElseThrow();
        existingTypeEmploye.setDesignation(typeEmploye.getDesignation());
        existingTypeEmploye.setSalaireBase(typeEmploye.getSalaireBase());
        existingTypeEmploye.setPourcentage(typeEmploye.getPourcentage());
        return repository.save(existingTypeEmploye);
    }

    public void deleteTypeEmploye(int id) {
        repository.deleteById(id);
    }
}
