package br.com.daluz.ConsultationOfCitiesInBrazilApi.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "estado")
@TypeDefs({
        // Necessário para que o Hibernate possa trabalhar com JSON ('jsonb' dentro de 'JsonBinaryType.class').
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String uf;

    @Column(name = "ibge")
    private Integer ibge;

    // @Column(name = "pais")
    // private Integer country_id;

    @ManyToOne
    @JoinColumn(name="pais", referencedColumnName = "id")
    private Country country_id;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd")
    private List<Integer> ddd;

    public State() {
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

//    public Integer getCountry_id() {
//        return country_id;
//    }
//
//    public void setCountry_id(Integer country_id) {
//        this.country_id = country_id;
//    }


    public Country getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    public void setDdd(List<Integer> ddd) {
        this.ddd = ddd;
    }
}
