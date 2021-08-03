package br.com.daluz.ConsultationOfCitiesInBrazilApi.entities;

import br.com.daluz.ConsultationOfCitiesInBrazilApi.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@TypeDefs({
        // Necessário para que o Hibernate possa trabalhar com Ponto  ('point' dentro de 'PointerType.class'). .
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name="uf", referencedColumnName = "id")
    //@Column(name = "uf")
    private State uf_id;

    @Column(name = "ibge")
    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "cod_tom")
    private Integer codTom;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getUf_id() {
        return uf_id;
    }

    public void setUf_id(State uf_id) {
        this.uf_id = uf_id;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getCodTom() {
        return codTom;
    }

    public void setCodTom(Integer codTom) {
        this.codTom = codTom;
    }
}
