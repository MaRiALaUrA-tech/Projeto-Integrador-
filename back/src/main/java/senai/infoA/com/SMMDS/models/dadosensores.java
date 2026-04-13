package senai.infoA.com.SMMDS.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="dadosensores")
public class dadosensores {

       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dadosensores_id")
    private Integer dadosensoresId;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Integer sensor;

    @Column ( name = "temperatura")
    private  BigDecimal temperatura;

    @Column ( name = "umidade")
    private  BigDecimal umidade;

    @Column ( name = "movimento")
    private  Boolean movimento;

    public dadosensores(Integer dadosensoresId, Integer sensor, BigDecimal temperatura, BigDecimal umidade,
            Boolean movimento) {
        this.dadosensoresId = dadosensoresId;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.movimento = movimento;
    }

    public Integer getDadosensoresId() {
        return dadosensoresId;
    }

    public void setDadosensoresId(Integer dadosensoresId) {
        this.dadosensoresId = dadosensoresId;
    }

    public Integer getSensor() {
        return sensor;
    }

    public void setSensor(Integer sensor) {
        this.sensor = sensor;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public BigDecimal getUmidade() {
        return umidade;
    }

    public void setUmidade(BigDecimal umidade) {
        this.umidade = umidade;
    }

    public Boolean getMovimento() {
        return movimento;
    }

    public void setMovimento(Boolean movimento) {
        this.movimento = movimento;
    }



    
}
