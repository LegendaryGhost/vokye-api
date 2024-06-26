package mg.itu.vokye.service;

import mg.itu.vokye.entity.TypeDepense;
import mg.itu.vokye.repository.TypeDepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TypeDepenseService {
    @Autowired
    TypeDepenseRepository typeDepenseRepository;

    public TypeDepense create(TypeDepense typeDepense) {
        return typeDepenseRepository.save(typeDepense);
    }

    public Page<TypeDepense> read(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        if (size <= 0) {
            size = 10;
        }
        return typeDepenseRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<TypeDepense> getById(Integer id) {
        return typeDepenseRepository.findById(id);
    }

    public TypeDepense update(TypeDepense typeDepense) {
        Optional<TypeDepense> optionalTypeDepense = typeDepenseRepository.findById(typeDepense.getId_type_depense());
        if (optionalTypeDepense.isPresent()) {
            return typeDepenseRepository.save(typeDepense);
        }
        return null;
    }

    public TypeDepense update(Integer id, TypeDepense typeDepense) {
        TypeDepense existingTd = typeDepenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type Dépense non trouvée avec l'ID: " + id));
        existingTd.setDesignation(typeDepense.getDesignation());
        return typeDepenseRepository.save(existingTd);
    }

    public void delete(Integer idTypeDepense) {
        typeDepenseRepository.deleteById(idTypeDepense);
    }


}