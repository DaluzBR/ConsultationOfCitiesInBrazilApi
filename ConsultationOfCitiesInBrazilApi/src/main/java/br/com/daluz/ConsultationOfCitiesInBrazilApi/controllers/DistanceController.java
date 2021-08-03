package br.com.daluz.ConsultationOfCitiesInBrazilApi.controllers;


import br.com.daluz.ConsultationOfCitiesInBrazilApi.services.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/distances")
public class DistanceController {

    @Autowired
    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceController.class);

    public DistanceController(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity getDistanceByPoints(@RequestParam(name = "from") final Long city1,
                                              @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity getDistanceByCube(@RequestParam(name = "from") final Long city1,
                                            @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
    }

//    @GetMapping("/by-math")
//    public Double byMath(@RequestParam(name = "from") final Long city1,
//                         @RequestParam(name = "to") final Long city2,
//                         @RequestParam final EarthRadius unit) {
//        log.info("byMath");
//        return service.distanceUsingMath(city1, city2, unit);
//    }
}