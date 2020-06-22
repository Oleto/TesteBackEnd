package br.com.RodrigoOleto.TesteBackEnd.DAO;

import br.com.RodrigoOleto.TesteBackEnd.Entidades.Associados;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadosDAO extends CrudRepository<Associados,Integer> {
}
