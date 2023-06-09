package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

// Decorator (abstract decorator) no pattern Decorator
public abstract class DecoratoMusica implements Musica {

    protected Musica musica;
    protected ResourceLoader resourceLoader;
    protected int linha;

    public DecoratoMusica(Musica musica) {
        this.musica = musica;
        this.resourceLoader = ResourceLoader.instance();
    }

    @Override
    public String getNome() {
        return musica.getNome();
    }


    public String execute() {
        reset();
        StringBuilder builder = new StringBuilder();
        while (!finish()) {
            builder.append(play());
        }
        return builder.toString();
    }

    @Override
    public void reset() {
        this.linha = 0;
        musica.reset();
    }

}
