package br.com.daluz.ConsultationOfCitiesInBrazilApi.repositories;

import br.com.daluz.ConsultationOfCitiesInBrazilApi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
