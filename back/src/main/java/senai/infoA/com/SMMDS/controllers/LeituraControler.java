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

import senai.infoA.com.SMMDS.models.Leitura;
import senai.infoA.com.SMMDS.services.LeituraService;

@RestController
@RequestMapping("/leitura")
public class LeituraControler {


    @Autowired
    private LeituraService leituraService;

    @GetMapping
    public List<Leitura> listarTodas() {
        return leituraService.listarTodas();
    }

    @GetMapping("/{id}")
    public Leitura buscarPorId(@PathVariable Integer id) {
        return leituraService.buscarPorId(id);
    }

    @PostMapping
    public Leitura salvar(@RequestBody Leitura leitura) {
        return leituraService.salvar(leitura);
    }

    @PutMapping("/{id}")
    public Leitura atualizar(
            @PathVariable Integer id,
            @RequestBody Leitura leituraAtualizada) {

        return leituraService.atualizar(id, leituraAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        leituraService.deletar(id);
    }
    
}
