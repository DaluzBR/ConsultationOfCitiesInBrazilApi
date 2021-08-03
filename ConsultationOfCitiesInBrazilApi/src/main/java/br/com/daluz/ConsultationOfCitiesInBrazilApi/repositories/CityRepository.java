package br.com.daluz.ConsultationOfCitiesInBrazilApi.repositories;


import br.com.daluz.ConsultationOfCitiesInBrazilApi.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(double x, double y, double x1, double y1);

    @Query(value = "SELECT nome FROM cidade WHERE id=?1", nativeQuery = true)
    String cityNameById(Long city);

    @Query(value = "SELECT B.uf FROM cidade A INNER JOIN estado B ON A.uf = B.id WHERE A.id = ?1", nativeQuery = true)
    String cityUfById(Long city);



}
