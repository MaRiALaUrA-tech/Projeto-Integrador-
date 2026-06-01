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

    @Column(name="recomendacao_agricola")
    private String recomendacaoAgricola;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;


    public Leitura(){
    }

    public Leitura(Integer leituraId, BigDecimal dado, Timestamp ultimaAtualizacao, String riscoDado, String classificacaoDado, String tipoSensor, String recomendacaoAgricola) {
        this.leituraId = leituraId;
        this.dado = dado;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.riscoDado = riscoDado;
        this.classificacaoDado = classificacaoDado;
        this.recomendacaoAgricola = recomendacaoAgricola;
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

    public String getRecomendacaoAgricola() {
        return recomendacaoAgricola;
    }

    public void setRecomendacaoAgricola(String recomendacaoAgricola) {
        this.recomendacaoAgricola = recomendacaoAgricola;
    }
    
    

    

    

    

    


}