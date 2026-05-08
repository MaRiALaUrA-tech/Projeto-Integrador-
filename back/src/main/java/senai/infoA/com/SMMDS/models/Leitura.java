package senai.infoA.com.SMMDS.models;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leitura")
public class Leitura{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="leitura_id")
    private Integer leituraId;

    @Column(name="dado")
    private Double dado;

    @Column(name="ultima_atualizacao")
    private Timestamp ultimaAtualizacao;

    @Column(name="risco_dado")
    private String riscoDado;

    @Column(name="classificacao_dado")
    private String classificacaoDado;

    
    @Column(name="tipo_sensor")
    private String tipoSensor;

    public Leitura(){
    }

    public Leitura(Integer leituraId, Double dado, Timestamp ultimaAtualizacao, String riscoDado,
            String classificacaoDado, String tipoSensor) {
        this.leituraId = leituraId;
        this.dado = dado;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.riscoDado = riscoDado;
        this.classificacaoDado = classificacaoDado;
        this.tipoSensor = tipoSensor;
    }

    public Integer getLeituraId() {
        return leituraId;
    }

    public void setLeituraId(Integer leituraId) {
        this.leituraId = leituraId;
    }

    public Double getDado() {
        return dado;
    }

    public void setDado(Double dado) {
        this.dado = dado;
    }

    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getRiscoDado() {
        return riscoDado;
    }

    public void setRiscoDado(String riscoDado) {
        this.riscoDado = riscoDado;
    }

    public String getClassificacaoDado() {
        return classificacaoDado;
    }

    public void setClassificacaoDado(String classificacaoDado) {
        this.classificacaoDado = classificacaoDado;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    

    

    


}