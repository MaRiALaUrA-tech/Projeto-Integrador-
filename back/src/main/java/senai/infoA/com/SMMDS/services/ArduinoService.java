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


@Service
public class ArduinoService {
    private final SensorRepository sensorRepository;
    private final LeituraRepository leituraRepository;

    public ArduinoService(SensorRepository sensorRepository, LeituraRepository leituraRepository, GroqService groqService) {
        this.sensorRepository = sensorRepository;
        this.leituraRepository = leituraRepository;
    }
    public void iniciarLeitura(){
        SerialPort porta= SerialPort.getCommPort("/dev/ttyUSB0");
        porta.setBaudRate(9600);
    if (porta.openPort()){
        System.out.println("Arduíno conectado!");  //Define velocidade de comunicação (9600) e abre as portas para o arduíno
        try (Scanner scanner = new Scanner(porta.getInputStream())){  //Java assume o controle de comunicação entre o arduíno
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                processarLinha (linha); //Enquanto houver comunicação, os dados serão enviados para a programação "processar linha" (definida em baixo)
            }
        }catch (Exception e){
            System.out.println("Erro na leitura dos dados:" + e.getMessage()); // Se o cabo for retirado ou falha na comunicação, mostra o erro e a mensagem
        } finally {
            porta.closePort();    // Independente do que aconteceu antes, faça o que está antes de mim
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

    Leitura leitura = new Leitura();
    leitura.setSensor(sensor);
    leitura.setDado(dado);
    leitura.setUltimaAtualizacao(new Timestamp(System.currentTimeMillis()));
    leitura.setClassificacaoDado(classificar(dado));
    leitura.setRiscoDado(calcularRisco(tipoSensor, dado));
 
    leituraRepository.save(leitura);
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



    

