package ba.ptf.si.namjestaj.repository;

import ba.ptf.si.namjestaj.model.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProizvodRepository extends JpaRepository<Proizvod, Integer> {
}
