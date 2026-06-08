package senai.infoA.com.SMMDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senai.infoA.com.SMMDS.models.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
    
}
