package br.com.RodrigoOleto.TesteBackEnd.DAO;

import br.com.RodrigoOleto.TesteBackEnd.Entidades.Pauta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaDao extends CrudRepository<Pauta,Integer> {
}
