package senai.infoA.com.SMMDS.controllers;

import org.springframework.web.bind.annotation.RestController;

import senai.infoA.com.SMMDS.repositories.LeituraRepository;
import senai.infoA.com.SMMDS.services.GroqService;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/groq")
public class GroqControler {
    private final GroqService groqService;
    private final LeituraRepository leituraRepository;

    public GroqControler(GroqService groqService, LeituraRepository leituraRepository) {
        this.groqService = groqService;
        this.leituraRepository = leituraRepository;
    }

    

    
    
}
