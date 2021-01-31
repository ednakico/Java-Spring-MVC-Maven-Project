package ba.ptf.si.namjestaj.service;

import ba.ptf.si.namjestaj.model.Kategorija;
import ba.ptf.si.namjestaj.repository.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaServiceImpl implements KategorijaService {
    @Autowired
    private KategorijaRepository kategorijaRepository;

    public List<Kategorija> getAll(){
        return kategorijaRepository.findAll();
    }

    public void save(Kategorija kategorija){
        kategorijaRepository.save(kategorija);
    }

    public Kategorija getById(Integer id){
        return kategorijaRepository.findById(id).get();
    }
}
