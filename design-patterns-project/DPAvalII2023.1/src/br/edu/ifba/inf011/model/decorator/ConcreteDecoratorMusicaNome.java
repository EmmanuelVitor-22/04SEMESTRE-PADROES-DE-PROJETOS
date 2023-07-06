package br.edu.ifba.inf011.model.decorator;

// Componente Concreto no pattern Decorator
// Leaf: no pattern Composite

//Esse será meu objeto base onde, a partir dele, irei decorar.
//Com ele posso fazer a criação de qualquer combinação (como por exemplo musica sem nota, só tradução, ou as combinações já solicitadas);
import br.edu.ifba.inf011.model.Musica;

import java.io.IOException;
import java.util.List;

public class ConcreteDecoratorMusicaNome implements Musica {
    private  String nome;
    private Integer linha;

    public ConcreteDecoratorMusicaNome(String nome) {
        this.nome = nome;
        this.reset();
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void reset() {
        this.linha = 0;
    }

    @Override
    public Boolean finish() {
        return this.linha > 0;
    }

    @Override
    public String play() {

        if (this.finish()) {
              return this.execute();
        }
        this.linha++;
        return "\n******** " + this.getNome() + " ******** \n";
    }
    @Override
    public String execute() {
        return "";
    }


}
