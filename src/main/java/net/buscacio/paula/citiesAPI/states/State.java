package net.buscacio.paula.citiesAPI.states;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import net.buscacio.paula.citiesAPI.countries.Country;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "state")
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    @Column(name = "ibge")
    private Integer ibgeCode;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    //map json to list
    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsnob")
    private List<Integer> ddd;

    public State() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbgeCode() {
        return ibgeCode;
    }

    public Country getCountry() {
        return country;
    }

    public List<Integer> getDdd() {
        return ddd;
    }
}
