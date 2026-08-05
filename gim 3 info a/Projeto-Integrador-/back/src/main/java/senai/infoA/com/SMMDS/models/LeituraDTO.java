package senai.infoA.com.SMMDS.models;

import java.math.BigDecimal;

public class LeituraDTO {
    private String tipoSensor;
    private BigDecimal valor;
    
    public String getTipoSensor() {
        return tipoSensor;
    }
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    

    
}
