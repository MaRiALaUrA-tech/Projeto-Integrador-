package senai.infoA.com.SMMDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacaoRepository extends JpaRepository<RecomendacaoRepository, Integer>{
    
}
