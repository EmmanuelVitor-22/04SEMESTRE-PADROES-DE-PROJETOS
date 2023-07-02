package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.Musica;

import java.io.IOException;
import java.util.List;

// Componente Concreto no pattern Decorator
/* Leaf: Composite pattern */
public class ConcreteDecoratorLetra extends  DecoratoMusica{
    private List<String>  letra;
    public ConcreteDecoratorLetra(Musica musica) throws  IOException {
        super(musica);
        this.reset();
        this.setLetra();


    }
    public void setLetra() throws IOException {
        this.letra = resourceLoader.loadLetra(getNome());
    }

    @Override
    public Boolean finish() {
        return  this.linha >=this.letra.size();
    }

    @Override
    public String play() {
        return this.musica.play() + "\n" + this.letra.get(this.linha++);
    }
}
