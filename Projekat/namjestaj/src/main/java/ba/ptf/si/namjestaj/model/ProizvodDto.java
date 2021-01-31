package ba.ptf.si.namjestaj.model;

public class ProizvodDto {
    private Integer id;
    private String naziv;
    private Float cijena;
    private Integer kategorija_id;

    public ProizvodDto() {
    }

    public ProizvodDto(Integer id, String naziv, Float cijena, Integer kategorija_id) {
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        this.kategorija_id = kategorija_id;
    }

    public Integer getId() {
        return id;
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

    public Integer getKategorija_id() {
        return kategorija_id;
    }

    public void setKategorija_id(Integer kategorija_id) {
        this.kategorija_id = kategorija_id;
    }
}
