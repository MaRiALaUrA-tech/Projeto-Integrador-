package senai.infoA.com.SMMDS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="statusalerta")
public class statusalerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tiposensores_id")
    private Integer tiposensoresId;

    @Column ( name = "nome")
    private  String nome;

    public statusalerta(Integer tiposensoresId, String nome) {
        this.tiposensoresId = tiposensoresId;
        this.nome = nome;
    }

    public Integer getTiposensoresId() {
        return tiposensoresId;
    }

    public void setTiposensoresId(Integer tiposensoresId) {
        this.tiposensoresId = tiposensoresId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
