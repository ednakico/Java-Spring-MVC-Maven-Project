package ba.ptf.si.namjestaj.model;

import javax.persistence.*;

@Entity
public class Proizvod{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String naziv;
    private Float cijena;

    @ManyToOne
    private Kategorija kategorija;

    public Proizvod() {
    }

    public Proizvod(Integer id, String naziv, Float cijena, Kategorija kategorija) {
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        this.kategorija = kategorija;
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

    public Float getCijena() {
        return cijena;
    }

    public void setCijena(Float cijena) {
        this.cijena = cijena;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
}
