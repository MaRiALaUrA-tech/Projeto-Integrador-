package senai.infoA.com.SMMDS.models;

import java.math.BigDecimal;

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
    private BigDecimal latitude;

    @Column(name="longitude")
    private BigDecimal longitude;

    @Column(name="tipo_solo")
    private String tipoSolo;

    public Local(){
    }

    public Local(Integer localId, String nomeLocal, BigDecimal latitude, BigDecimal longitude, String tipoSolo) {
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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getTipoSolo() {
        return tipoSolo;
    }

    public void setTipoSolo(String tipoSolo) {
        this.tipoSolo = tipoSolo;
    }

    

    


}