package senai.infoA.com.SMMDS.services;

import java.sql.Timestamp;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import senai.infoA.com.SMMDS.models.Leitura;
import senai.infoA.com.SMMDS.repositories.LeituraRepository;
import senai.infoA.com.SMMDS.repositories.SensorRepository;

@Service
public class ArduinoService {
    private final SensorRepository sensorRepository;
    private final LeituraRepository leituraRepository;

    public ArduinoService(SensorRepository sensorRepository, LeituraRepository leituraRepository) {
        this.sensorRepository = sensorRepository;
        this.leituraRepository = leituraRepository;
    }
    public void iniciarLeitura(){
        SerialPort porta= SerialPort.getCommPort("nome da porta LINUX");
        porta.setBaudRate(9600);
    if (porta.openPort()){
        System.out.println("Arduíno conectado!");
        Scanner scanner = new Scanner(porta.getInputStream());
        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
        processarLinha(linha);
    }
    
    }
    else {
        System.out.println("Erro ao conectar USB");
        }
    }
    private void processarLinha(String linha){
        String[] partes = linha.split(";");
        for (String parte: partes){
            String[] chaveValor = parte.split(":");
            String tipoSensor = chaveValor[0];
            Double valor = Double.parseDouble(chaveValor[1]);
    Sensor sensor = sensorRepository.findByTipoSensor(tipoSensor).orElse(null);
    if (sensor == null){
        System.out.println("Sensor não encontrado:" + tipoSensor);
        continue;
    }
    Leitura leitura = new Leitura();
    leitura.setSensor(sensor);
    leitura.setDado(valor);
    leitura.setUltimaAtualizacao(new Timestamp(System.currentTimeMillis()));
    leitura.setClassificacaoDado(classificar(valor));
    leitura.setRiscoDdao(calcularRisco(tipoSensor, valor));
    leituraRepository.save(leitura);
    System.out.println("Leitura salva:" + tipoSensor + "-->" + valor);

        }
    }


    
}
