package kodlama.io.KodlamaIo.dataAccess.abstracts;

import kodlama.io.KodlamaIo.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangugageRepository extends JpaRepository<Language, Integer> {

}
