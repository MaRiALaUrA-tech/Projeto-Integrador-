package senai.infoA.com.SMMDS.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// fk_local e fk_tipo_sensor
@Entity
@Table(name="sensor")
public class Sensor{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="sensor_id")
    private Integer sensorId;

    @Column(name="tipo_sensor")
    private String tipoSensor;


    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @OneToMany(mappedBy = "sensor")
    private List<Leitura> leitura;


    public Sensor(){

    }


    public Sensor(Integer sensorId, String tipoSensor, Local local, List<Leitura> leitura) {
        this.sensorId = sensorId;
        this.tipoSensor = tipoSensor;
        this.local = local;
        this.leitura = leitura;
    }


    public Integer getSensorId() {
        return sensorId;
    }


    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }
    public Local getLocal() {
        return local;
    }


    public void setLocal(Local local) {
        this.local = local;
    }


    public List<Leitura> getLeitura() {
        return leitura;
    }


    public void setLeitura(List<Leitura> leitura) {
        this.leitura = leitura;
    }

}