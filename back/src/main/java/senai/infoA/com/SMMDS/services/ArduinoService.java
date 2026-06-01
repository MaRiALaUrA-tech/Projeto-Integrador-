package senai.infoA.com.SMMDS.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import senai.infoA.com.SMMDS.models.Leitura;
import senai.infoA.com.SMMDS.models.Sensor;
import senai.infoA.com.SMMDS.repositories.LeituraRepository;
import senai.infoA.com.SMMDS.repositories.SensorRepository;
import senai.infoA.com.SMMDS.services.GroqService;

@Service
public class ArduinoService {
    private final SensorRepository sensorRepository;
    private final LeituraRepository leituraRepository;
    private final GroqService groqService;

    public ArduinoService(SensorRepository sensorRepository, LeituraRepository leituraRepository, GroqService groqService) {
        this.sensorRepository = sensorRepository;
        this.leituraRepository = leituraRepository;
        this.groqService = groqService;
    }
    public void iniciarLeitura(){
        SerialPort porta= SerialPort.getCommPort("/dev/ttyUSB0");
        porta.setBaudRate(9600);
    if (porta.openPort()){
        System.out.println("Arduíno conectado!");
        Scanner scanner = new Scanner(porta.getInputStream());
        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
        processarLinha(linha);
        scanner.close();
    }
    
    }
    else {
        System.out.println("Erro ao conectar USB");
        }
    }
    private void processarLinha(String linha){
        
        String[] partes = linha.split(";");
        for (String parte: partes){
            String[] chaveDado = parte.split(":");
            String tipoSensor = chaveDado[0];
            BigDecimal dado = new BigDecimal(chaveDado[1]);
    Sensor sensor = sensorRepository.findByTipoSensor(tipoSensor).orElse(null);
    if (sensor == null){
        System.out.println("Sensor não encontrado:" + tipoSensor);
        continue;
    }
    String tipoSolo = sensor.getTipoSolo();
    Leitura leitura = new Leitura();
    leitura.setSensor(sensor);
    leitura.setDado(dado);
    leitura.setUltimaAtualizacao(new Timestamp(System.currentTimeMillis()));
    leitura.setClassificacaoDado(classificar(dado));
    leitura.setRiscoDado(calcularRisco(tipoSensor, dado));
    System.out.println("Solicitando análise automática da IA...");
    String recomendacaoAgricola = groqService.pedirRecomendacaoAgricola(tipoSensor, dado, tipoSolo);

    // 2. Guardamos o conselho da IA no novo campo do seu objeto leitura
    leitura.setRecomendacaoAgricola(recomendacaoAgricola);

    // 3. AGORA SIM, salvamos o pacote completo (dados + classificação + IA) no banco!
    leituraRepository.save(leitura);
    
    // 4. Print final de sucesso
    System.out.println("Leitura salva: " + tipoSensor + " --> " + dado);

        }
    }

    private String classificar (BigDecimal dado){
        if (dado.compareTo(new BigDecimal("40")) < 0){
        return "Baixo";
    }
    // Substitui: else if (valor < 70)
    else if (dado.compareTo(new BigDecimal("70")) < 0){
        return "Moderado";
    }
    return "Alto";
}

    private String calcularRisco(String tipoSensor,BigDecimal dado){
        if(tipoSensor.equals("UMID_SOLO")){
        // Substitui: if (valor > 70)
        if(dado.compareTo(new BigDecimal("70")) > 0){
            return "Alto";
        }
        // Substitui: else if (valor > 40)
        else if(dado.compareTo(new BigDecimal("40")) > 0){
            return "Moderado";
        }
        return "Baixo";
    }
    return "Sem risco";
}
}



    

