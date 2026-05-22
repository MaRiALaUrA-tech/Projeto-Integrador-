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
@Table(name = "Recomenacao")
public class Recomendacao{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="recomendacao_id")
    private Integer recomendacaoId; 

    @Column(name="texto_recomendacao")
    private String textoRecomendacao;

    @ManyToOne
    @JoinColumn(name="leitura_id")
    private Leitura leitura;

    public Recomendacao(){
    }

    public Recomendacao(Integer recomendacaoId, String textoRecomendacao) {
        this.recomendacaoId = recomendacaoId;
        this.textoRecomendacao = textoRecomendacao;
    }

    public Integer getRecomendacaoId() {
        return recomendacaoId;
    }

    public void setRecomendacaoId(Integer recomendacaoId) {
        this.recomendacaoId = recomendacaoId;
    }

    public String getTextoRecomendacao() {
        return textoRecomendacao;
    }

    public void setTextoRecomendacao(String textoRecomendacao) {
        this.textoRecomendacao = textoRecomendacao;
    }

    



    




}