package br.com.daluz.ConsultationOfCitiesInBrazilApi.controllers;


import br.com.daluz.ConsultationOfCitiesInBrazilApi.entities.City;
import br.com.daluz.ConsultationOfCitiesInBrazilApi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    @Autowired
    private CityRepository repository;

    @GetMapping
    public Page<City> cities(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCityById(@PathVariable Long id) {
        Optional<City> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
