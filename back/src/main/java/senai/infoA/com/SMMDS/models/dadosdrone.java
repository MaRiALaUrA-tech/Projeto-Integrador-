package senai.infoA.com.SMMDS.models;

import java.math.BigDecimal;
import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "dadosdrone")
public class dadosdrone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dadosdrone_id")
    private Integer dadosdroneId;

    @Column(name = "sensor_id")
    private Integer sensor;

    @Column ( name = "temperatura")
    private  BigDecimal temperatura;

    @Column ( name = "umidade")
    private  BigDecimal umidade;

    @Column ( name = "data_registro")
    private  Timestamp data_registro;

    public dadosdrone(Integer dadosdroneId, Integer sensor, BigDecimal temperatura, BigDecimal umidade,
            Timestamp data_registro) {
        this.dadosdroneId = dadosdroneId;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.data_registro = data_registro;
    }

    public Integer getDadosdroneId() {
        return dadosdroneId;
    }

    public void setDadosdroneId(Integer dadosdroneId) {
        this.dadosdroneId = dadosdroneId;
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

    public Timestamp getData_registro() {
        return data_registro;
    }

    public void setData_registro(Timestamp data_registro) {
        this.data_registro = data_registro;
    }

    
    
}
