package senai.infoA.com.SMMDS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import senai.infoA.com.SMMDS.models.Leitura;
import senai.infoA.com.SMMDS.models.LeituraDTO;
import senai.infoA.com.SMMDS.services.ArduinoService;

@RestController
@RequestMapping("/arduino")
public class ArduinoControler {
    @Autowired
    private ArduinoService arduinoService;

    public ArduinoControler(ArduinoService arduinoService) {
        this.arduinoService = arduinoService;
    }

    @PostMapping("/leitura")
    public ResponseEntity<String> receber(@RequestBody LeituraDTO dto){
         String linha = dto.getTipoSensor() + ":" + dto.getValor();

        arduinoService.processarLinha(linha);

        return ResponseEntity.ok("Leitura recebida!");
    }
    
}
