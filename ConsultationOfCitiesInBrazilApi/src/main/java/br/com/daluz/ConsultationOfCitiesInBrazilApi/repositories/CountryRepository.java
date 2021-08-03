package br.com.daluz.ConsultationOfCitiesInBrazilApi.repositories;


import br.com.daluz.ConsultationOfCitiesInBrazilApi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
