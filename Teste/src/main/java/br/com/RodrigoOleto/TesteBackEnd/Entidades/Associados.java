package br.com.RodrigoOleto.TesteBackEnd.Entidades;

import javax.persistence.*;

@Entity
public class Associados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable =false)
    private String nomeassociado;
    private int sim=0;

    public void setSim(int sim) {
        this.sim = sim;
    }

    public int getSim() {
        return sim;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomeassociado() {
        return nomeassociado;
    }

    public void setNomeassociado(String nomeassociado) {
        this.nomeassociado = nomeassociado;
    }
}
