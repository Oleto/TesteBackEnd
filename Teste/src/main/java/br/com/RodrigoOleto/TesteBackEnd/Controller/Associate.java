package br.com.RodrigoOleto.TesteBackEnd.Controller;

import br.com.RodrigoOleto.TesteBackEnd.DAO.AssociadosDAO;
import br.com.RodrigoOleto.TesteBackEnd.DAO.PautaDao;
import br.com.RodrigoOleto.TesteBackEnd.Entidades.Associados;
import br.com.RodrigoOleto.TesteBackEnd.Entidades.Pauta;
import br.com.RodrigoOleto.TesteBackEnd.Erros.MaRequisicao;
import br.com.RodrigoOleto.TesteBackEnd.Erros.NaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Scanner;

@RequestMapping("/associados")
@RestController
public class Associate {
    @Autowired
    AssociadosDAO associadosDAO;
    @Autowired
    PautaDao pautaDao;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public Iterable<Associados>listar(){
        return associadosDAO.findAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Associados> recuperar(@PathVariable int id){
        return  associadosDAO.findById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Associados atualizar(@RequestBody Associados novoassociado , @PathVariable int id){
        if(associadosDAO.existsById(id)==true){
            associadosDAO.deleteById(id);
            return associadosDAO.save(novoassociado);
        }else{
            throw new RuntimeException("");
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deletar(@PathVariable int id){
        associadosDAO.deleteById(id);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Associados cadastrar(@RequestBody Associados associado){
        if(associadosDAO.findById(associado.getId()).isPresent()){

            throw new NaoEncontrado("Usuario já cadastrado");
        }else{
            return associadosDAO.save(associado);
        }
    }


    @PutMapping("/{associadoid}/votar/{pautaid}")
    public void votar(@PathVariable int associadoid , @PathVariable int pautaid){
        if(pautaDao.findById(pautaid).isPresent()){
            pautaaberta(pautaid);
            Pauta pauta = pautaDao.findById(pautaid).get(); for (int i = 0; i <pauta.getVotantes().size(); i++) {
                if(pauta.getVotantes().contains(associadoid)){System.out.println("Associado já votou nesta pauta");
                    break;}
            }
        }
                Pauta pauta = pautaDao.findById(pautaid).get();
        pauta.getVotantes().add(associadoid);

        votosimnao( pautaid,associadoid);



    }
    private void votosimnao(int pautaid, int associadoid){
        Pauta pauta = pautaDao.findById(pautaid).get();

        Associados associado = associadosDAO.findById(associadoid).get();
        Scanner sc = new Scanner (System.in);
        associado.setSim(sc.nextInt());
        sc.close();

        switch (associado.getSim()){
            case 1:pauta.setVotossim(pauta.getVotossim()+1);
                break;
            case 2:
                pauta.setVotosnao(pauta.getVotosnao()+1);
                break;
            default:
                throw new MaRequisicao("tipo de voto inválido");
        }
    }
    private   void pautaaberta(int pautaid)  {
        //Se a pauta estiver aberta o volto é autorizado, caso contrario será informado o erro

        if(pautaDao.findById(pautaid).get().getSessão()==true){


        }
        else{throw new MaRequisicao("Sessão da pauta já foi fechada"); }
    }
}
