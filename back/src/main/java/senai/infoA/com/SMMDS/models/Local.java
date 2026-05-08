package senai.infoA.com.SMMDS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="local")
public class Local{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="local_id")
    private Integer localId;

    @Column(name="nome_local")
    private String nomeLocal;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="tipo_solo")
    private String tipoSolo;

    public Local(){
    }

    public Local(Integer localId, String nomeLocal, Double latitude, Double longitude, String tipoSolo) {
        this.localId = localId;
        this.nomeLocal = nomeLocal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipoSolo = tipoSolo;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTipoSolo() {
        return tipoSolo;
    }

    public void setTipoSolo(String tipoSolo) {
        this.tipoSolo = tipoSolo;
    }

    

    


}