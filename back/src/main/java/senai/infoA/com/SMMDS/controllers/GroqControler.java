package senai.infoA.com.SMMDS.controllers;

import org.springframework.web.bind.annotation.RestController;

import senai.infoA.com.SMMDS.services.GroqService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/groq")  //Poder acessar no Swagger
public class GroqControler {
    private final GroqService groqService;

    public GroqControler(GroqService groqService) {
        this.groqService = groqService;
    }

    @GetMapping("/recomendacao")
    public ResponseEntity<String> obterRecomendacao(
        @RequestParam String tipoSensor,
        @RequestParam BigDecimal dado,
        @RequestParam String tipoSolo) {
            String respostaIA= groqService.pedirRecomendacaoAgricola(tipoSensor, dado, tipoSolo);
            return ResponseEntity.ok(respostaIA);
    
    }
}
