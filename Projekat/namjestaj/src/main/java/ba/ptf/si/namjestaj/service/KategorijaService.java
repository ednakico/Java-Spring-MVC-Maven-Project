package ba.ptf.si.namjestaj.service;

import ba.ptf.si.namjestaj.model.Kategorija;

import java.util.List;

public interface KategorijaService {
    List<Kategorija> getAll();
    void save(Kategorija kategorija);
    Kategorija getById(Integer id);
}
