package br.com.daluz.ConsultationOfCitiesInBrazilApi.controllers;


import br.com.daluz.ConsultationOfCitiesInBrazilApi.entities.State;
import br.com.daluz.ConsultationOfCitiesInBrazilApi.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {
    @Autowired
    private StateRepository repository;

    @GetMapping
    public Page<State> states(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStateById(@PathVariable Long id) {
        Optional<State> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
