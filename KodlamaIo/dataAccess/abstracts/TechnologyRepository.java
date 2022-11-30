package kodlama.io.KodlamaIo.dataAccess.abstracts;


import kodlama.io.KodlamaIo.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
