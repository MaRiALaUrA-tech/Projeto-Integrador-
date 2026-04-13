package senai.infoA.com.SMMDS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "drones")
public class drones {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="drones_id")
    private Integer dronesId;

    @Column ( name = "modelo")
    private  String modelo;


    @ManyToMany
    @JoinColumn(name = "area_id")
    private Integer areaId;


    public drones(Integer dronesId, String modelo, Integer areaId) {
        this.dronesId = dronesId;
        this.modelo = modelo;
        this.areaId = areaId;
    }


    public Integer getDronesId() {
        return dronesId;
    }


    public void setDronesId(Integer dronesId) {
        this.dronesId = dronesId;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public Integer getAreaId() {
        return areaId;
    }


    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    
    
}
