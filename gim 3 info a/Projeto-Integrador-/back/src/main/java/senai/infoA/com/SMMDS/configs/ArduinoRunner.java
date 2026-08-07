package senai.infoA.com.SMMDS.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import senai.infoA.com.SMMDS.services.ArduinoService;

@Configuration
@Profile("local")
public class ArduinoRunner {

    @Bean
    public CommandLineRunner run(ArduinoService arduinoService) {
        return args -> {
            System.out.println("Iniciando leitura do Arduino...");
            arduinoService.iniciarLeitura();
        };
    }
}
