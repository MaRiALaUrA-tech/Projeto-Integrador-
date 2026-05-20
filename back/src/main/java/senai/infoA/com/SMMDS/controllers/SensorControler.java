package senai.infoA.com.SMMDS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import senai.infoA.com.SMMDS.models.Sensor;
import senai.infoA.com.SMMDS.services.SensorService;

@RestController
@RequestMapping("/sensor")
public class SensorControler {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> listarTodos() {
        return sensorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Sensor buscarPorId(@PathVariable Integer id) {
        return sensorService.buscarPorId(id);
    }

    @PostMapping
    public Sensor salvar(@RequestBody Sensor sensor) {
        return sensorService.salvar(sensor);
    }

    @PutMapping("/{id}")
    public Sensor atualizar(
            @PathVariable Integer id,
            @RequestBody Sensor sensorAtualizado) {

        return sensorService.atualizar(id, sensorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        sensorService.deletar(id);
    }
    
}
