package net.buscacio.paula.citiesAPI.entity;

import net.buscacio.paula.citiesAPI.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    private Integer uf;

    @Column(name = "ibge")
    private Integer ibgeCode;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public City(){}

    public City(final Long id, final String nome, final Integer uf, final Integer ibgeCode, final Point location) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.ibgeCode = ibgeCode;
        this.location = location;
    }

    public City(Long id, String nome, Integer uf, Integer ibgeCode) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.ibgeCode = ibgeCode;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbgeCode() {
        return ibgeCode;
    }

    public Point getLocation() {
        return location;
    }

}
