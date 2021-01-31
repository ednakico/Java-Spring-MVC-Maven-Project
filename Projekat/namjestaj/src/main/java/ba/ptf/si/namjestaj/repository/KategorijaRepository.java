package ba.ptf.si.namjestaj.repository;

import ba.ptf.si.namjestaj.model.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
}
