package br.com.RodrigoOleto.TesteBackEnd.Controller;

import br.com.RodrigoOleto.TesteBackEnd.DAO.PautaDao;
import br.com.RodrigoOleto.TesteBackEnd.Entidades.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/pautas")
@RestController
public class PautaController {
    @Autowired
    PautaDao pautaDao;

    @GetMapping("/")
    public Iterable<Pauta>listar(){
        return pautaDao.findAll();
    }

    @PostMapping(path="/")

    public Pauta salvar(@RequestBody Pauta pauta){
        return pautaDao.save(pauta);

    }
    @GetMapping("/")
    public Optional<Pauta> recuperar(@RequestParam int id){

        return pautaDao.findById(id);
    }
    @PutMapping("/")
    public void atualizar(Pauta pautanova,int id){
        pautaDao.deleteById(id);
        pautaDao.save(pautanova);

    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        pautaDao.deleteById(id);

    }
}
