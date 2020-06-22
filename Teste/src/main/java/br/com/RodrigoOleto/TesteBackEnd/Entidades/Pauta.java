package br.com.RodrigoOleto.TesteBackEnd.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    private boolean sessao = false;
    private int votossim=0;
    private int votosnao=0;
    @ElementCollection
   private List<Integer> votantes;
    public List<Integer> getVotantes() {
        return votantes;
    }
    public  boolean getSessão(){
        return sessao;
    }
    public void setVotantes(List<Integer> votantes) {
        this.votantes = votantes;
    }

    public void setVotossim(int votossim) {
        this.votossim = votossim;
    }

    public int getVotossim() {
        return votossim;
    }

    public int getVotosnao() {
        return votosnao;
    }

    public void setVotosnao(int votosnao) {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setSessao(boolean sessão) {
        this.sessao = sessao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
