package senai.infoA.com.SMMDS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senai.infoA.com.SMMDS.models.Local;
import senai.infoA.com.SMMDS.repositories.LocalRepository;

@Service
public class LocalService {



    @Autowired
    private LocalRepository localRepository;

    // Listar todosno localRepository
    public List<Local> listarTodos() {
        return localRepository.findAll();
    }

    // Buscar por ID
    public Local buscarPorId(Integer id) {
        return localRepository.findById(id).get();
    }

    // Salvar
    public Local salvar(Local local) {
        return localRepository.save(local);
    }

    // Atualizar
    public Local atualizar(Integer id, Local localAtualizado) {

        Local local = buscarPorId(id);

        local.setNomeLocal(localAtualizado.getNomeLocal());
        local.setLatitude(localAtualizado.getLatitude());
        local.setLongitude(localAtualizado.getLongitude());
        local.setTipoSolo(localAtualizado.getTipoSolo());

        return localRepository.save(local);
    }

    // Deletar
    public void deletar(Integer id) {
        localRepository.deleteById(id);
    }
    
}
