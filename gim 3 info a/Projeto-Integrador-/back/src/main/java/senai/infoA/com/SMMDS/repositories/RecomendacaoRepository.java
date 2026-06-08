package senai.infoA.com.SMMDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senai.infoA.com.SMMDS.models.Recomendacao;

@Repository
public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Integer>{    
}
