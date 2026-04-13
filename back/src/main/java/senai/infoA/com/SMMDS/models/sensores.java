package senai.infoA.com.SMMDS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sensores")
public class sensores {

      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sensores_id")
    private Integer sensoresId;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Integer tiposensoresId;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Integer areaId;

    public sensores(Integer sensoresId, Integer tiposensoresId, Integer areaId) {
        this.sensoresId = sensoresId;
        this.tiposensoresId = tiposensoresId;
        this.areaId = areaId;
    }

    public Integer getSensoresId() {
        return sensoresId;
    }

    public void setSensoresId(Integer sensoresId) {
        this.sensoresId = sensoresId;
    }

    public Integer getTiposensoresId() {
        return tiposensoresId;
    }

    public void setTiposensoresId(Integer tiposensoresId) {
        this.tiposensoresId = tiposensoresId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }


    

    
}
