package senai.infoA.com.SMMDS.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="leitura")
public class Leitura{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="leitura_id")
    private Integer leituraId;

    @Column(name="dado")
    private BigDecimal dado;

    @Column(name="ultima_atualizacao")
    private Timestamp ultimaAtualizacao;

    @Column(name="risco_dado")
    private String riscoDado;

    @Column(name="classificacao_dado")
    private String classificacaoDado;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @OneToOne
    @JoinColumn(name="recomendacao_id", referencedColumnName = "recomendacao_id")
    private Recomendacao recomendacao;


    public Leitura(){
    }

    public Leitura(Integer leituraId, BigDecimal dado, Timestamp ultimaAtualizacao, String riscoDado, String classificacaoDado, String tipoSensor, Recomendacao recomendacao) {
        this.leituraId = leituraId;
        this.dado = dado;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.riscoDado = riscoDado;
        this.classificacaoDado = classificacaoDado;
        this.recomendacao = recomendacao;
    }

    public Integer getLeituraId() {
        return leituraId;
    }

    public void setLeituraId(Integer leituraId) {
        this.leituraId = leituraId;
    }

    public BigDecimal getDado() {
        return dado;
    }

    public void setDado(BigDecimal dado) {
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Recomendacao getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(Recomendacao recomendacao) {
        this.recomendacao = recomendacao;
    }
    

    

    

    

    

    


}