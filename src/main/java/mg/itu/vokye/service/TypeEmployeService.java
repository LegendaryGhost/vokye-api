package mg.itu.vokye.service;

import mg.itu.vokye.entity.TypeEmploye;
import mg.itu.vokye.repository.TypeEmployeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TypeEmployeService {
    private final TypeEmployeRepository repository;

    public TypeEmployeService(TypeEmployeRepository repository) {
        this.repository = repository;
    }

    public TypeEmploye createTypeEmploye(TypeEmploye typeEmploye) {
        return repository.save(typeEmploye);
    }

    public Page<TypeEmploye> getAllTypeEmploye(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public TypeEmploye getTypeEmployeById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public TypeEmploye updateTypeEmploye(Long id, TypeEmploye typeEmploye) {
        TypeEmploye existingTypeEmploye = repository.findById(id).orElseThrow();
        existingTypeEmploye.setDesignation(typeEmploye.getDesignation());
        existingTypeEmploye.setSalaireBase(typeEmploye.getSalaireBase());
        existingTypeEmploye.setPourcentage(typeEmploye.getPourcentage());
        existingTypeEmploye.setCota(typeEmploye.getCota());
        return repository.save(existingTypeEmploye);
    }

    public void deleteTypeEmploye(Long id) {
        repository.deleteById(id);
    }
}
