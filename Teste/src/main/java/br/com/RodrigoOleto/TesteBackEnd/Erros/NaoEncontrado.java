package br.com.RodrigoOleto.TesteBackEnd.Erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoEncontrado extends RuntimeException{
public NaoEncontrado(String message){
    super(message);
}}
