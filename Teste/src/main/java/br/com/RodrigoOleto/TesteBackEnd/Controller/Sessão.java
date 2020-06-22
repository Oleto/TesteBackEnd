package br.com.RodrigoOleto.TesteBackEnd.Controller;


import br.com.RodrigoOleto.TesteBackEnd.DAO.PautaDao;
import br.com.RodrigoOleto.TesteBackEnd.Entidades.Pauta;
import org.springframework.beans.factory.annotation.Autowired;






public class Sessão {


    @Autowired
    PautaController pautaController;
    long a ;
    void abresessao(Pauta pauta) {
        pauta.setSessao(true);
        pautaController.atualizar(pauta,pauta.getId());
        contador(pauta);
    }

    private void contador(Pauta pauta){
        for (int i = 0; i < 60;i++) {
            System.out.println(i);
        }
        fechasessao( pauta);
    }
    void fechasessao(Pauta pauta) {
        pauta.setSessao(false);
        pautaController.atualizar(pauta,pauta.getId());}


}
