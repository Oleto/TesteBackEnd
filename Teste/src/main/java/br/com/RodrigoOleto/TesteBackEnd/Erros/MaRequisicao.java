package br.com.RodrigoOleto.TesteBackEnd.Erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MaRequisicao extends RuntimeException {
    public MaRequisicao(    String message){
        super(message);
    }

}
