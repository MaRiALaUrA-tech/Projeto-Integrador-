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

import senai.infoA.com.SMMDS.models.Local;
import senai.infoA.com.SMMDS.services.LocalService;

@RestController
@RequestMapping("/local")
public class LocalControler {

    @Autowired
    private LocalService localService;

    @GetMapping
    public List<Local> listarTodos() {
        return localService.listarTodos();
    }

    @GetMapping("/{id}")
    public Local buscarPorId(@PathVariable Integer id) {
        return localService.buscarPorId(id);
    }

    @PostMapping
    public Local salvar(@RequestBody Local local) {
        return localService.salvar(local);
    }

    @PutMapping("/{id}")
    public Local atualizar(
            @PathVariable Integer id,
            @RequestBody Local localAtualizado) {

        return localService.atualizar(id, localAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        localService.deletar(id);
    }
    
}
