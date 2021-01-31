package ba.ptf.si.namjestaj.service;

import ba.ptf.si.namjestaj.model.Proizvod;
import ba.ptf.si.namjestaj.repository.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServiceImpl implements ProizvodService {

    @Autowired
    private ProizvodRepository proizvodRepository;

    @Override
    public List<Proizvod> getAll() {
        return proizvodRepository.findAll();
    }

    @Override
    public void save(Proizvod proizvod) {
        proizvodRepository.save(proizvod);
    }

    @Override
    public Proizvod getById(Integer id) {
        return proizvodRepository.findById(id).get();
    }
}
