package senai.infoA.com.SMMDS.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import senai.infoA.com.SMMDS.models.Leitura;

@Repository
public interface LeituraRepository extends JpaRepository<Leitura, Integer> {
    Optional<Leitura> findFirstBySensorSensorIdOrderByUltimaAtualizacaoDesc(Integer sensorId); // Busque apenas um registro do tipo Leitura, onde o objeto sensor tenha o sensorId igual ao número inteiro que passei no parâmetro e ordene os resultados pelo campo ultimaAtualização do mais rescente para o mais antigo
    
}
