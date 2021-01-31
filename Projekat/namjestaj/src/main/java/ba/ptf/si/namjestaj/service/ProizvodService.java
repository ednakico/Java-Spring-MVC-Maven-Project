package ba.ptf.si.namjestaj.service;

import ba.ptf.si.namjestaj.model.Proizvod;

import java.util.List;

public interface ProizvodService {
    List<Proizvod> getAll();
    void save(Proizvod proizvod);
    Proizvod getById(Integer id);
}
