package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.Musica;

import java.io.IOException;
import java.util.List;

public class ConcreteComponentLetra extends  DecoratoMusica{
    private List<String>  letra;
    public ConcreteComponentLetra(Musica musica) throws  IOException {
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
        return null;
    }
}
