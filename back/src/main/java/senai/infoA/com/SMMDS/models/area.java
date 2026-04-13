package senai.infoA.com.SMMDS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="area")
public class area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_area")
    private Integer areaId;


    @Column ( name = "nome")
    private  String nome;

    @Column ( name = "descicao")
    private  String descricao;

    @Column ( name = "latitude")
    private  Double latitude;

    @Column ( name = "longitude")
    private  Double longitude;

    public area(Integer areaId, String nome, String descricao, Double latitude, Double longitude) {
        this.areaId = areaId;
        this.nome = nome;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    
    


    
}
