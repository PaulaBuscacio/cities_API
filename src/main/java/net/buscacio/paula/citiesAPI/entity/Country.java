package net.buscacio.paula.citiesAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Country {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    @Column(name = "sigla")
    private String code;

    private Integer bacen;


    public Country() {}

    public Country(Long id, String name, String portugueseName, String code, Integer bacen) {
        this.id = id;
        this.name = name;
        this.portugueseName = portugueseName;
        this.code = code;
        this.bacen = bacen;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getPortugueseName() {
        return portugueseName;
    }

    public String getCode() {
        return code;
    }

    public Integer getBacen() {
        return bacen;
    }

}
