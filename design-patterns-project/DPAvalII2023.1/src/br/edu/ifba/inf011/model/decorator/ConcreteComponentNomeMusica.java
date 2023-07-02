package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.Musica;

// Componente Concreto no pattern Decorator
public class ConcreteComponentNomeMusica implements Musica {

    private final String nome;
    private Integer linha;

    public ConcreteComponentNomeMusica(String nome){
        this.nome = nome;
        this.reset();
    }
    @Override
    public String getNome() {
        return null;
    }
    @Override
    public String execute() {
        return " ";
    }
    @Override
    public void reset() {
        this.linha = 0;
    }

    @Override
    public Boolean finish() {
        return this.linha>0;
    }

    @Override
    public String play() {
        if (!this.finish()){
            this.linha++;
            return "\n---------:  \t\t" +this.getNome() + "\n";
        }
        return this.execute();
    }
}
