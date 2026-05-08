package senai.infoA.com.SMMDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.infoA.com.SMMDS.models.Sensor;
import senai.infoA.com.SMMDS.repositories.SensorRepository;

@Service
public class SensorService {


    @Autowired
    private SensorRepository sensorRepository;

    // Listar todos
    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    // Buscar por ID
    public Sensor buscarPorId(Integer id) {
        return sensorRepository.findById(id).get();
    }

    // Salvar
    public Sensor salvar(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    // Atualizar
    public Sensor atualizar(Integer id, Sensor sensorAtualizado) {

        Sensor sensor = buscarPorId(id);

        sensor.setLocal(sensorAtualizado.getLocal());


        return sensorRepository.save(sensor);
    }

    // Deletar
    public void deletar(Integer id) {
        sensorRepository.deleteById(id);
    }
    
}
