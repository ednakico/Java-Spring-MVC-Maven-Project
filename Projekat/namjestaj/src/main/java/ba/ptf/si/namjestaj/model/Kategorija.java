package ba.ptf.si.namjestaj.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kategorija {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String naziv;

    @OneToMany(mappedBy = "kategorija", fetch = FetchType.LAZY)
    private List<Proizvod> proizvodi = new ArrayList<>();

    public Kategorija() {
    }

    public Kategorija(Integer id, String naziv, List<Proizvod> proizvodi) {
        this.id = id;
        this.naziv = naziv;
        this.proizvodi = proizvodi;
    }

    public Object getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }
}
