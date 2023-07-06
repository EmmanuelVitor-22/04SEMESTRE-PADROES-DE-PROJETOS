package br.edu.ifba.inf011.model.decorator;

import br.edu.ifba.inf011.model.Musica;

import java.io.IOException;
import java.util.List;

// Componente Concreto no pattern Decorator
// Leaf: no pattern Composite
public class ConcreteDecoratorLetraTraducao extends  DecoratoMusica {
    private List<String> letraTraducao;
    private final String extensaoDaTraducao;

    public ConcreteDecoratorLetraTraducao(Musica musica, String extensaoDaTraducao) throws IOException {
        super(musica);
        this.extensaoDaTraducao = extensaoDaTraducao;
        this.setLetraTraducao();
        reset();
    }

    public void setLetraTraducao() throws IOException {
        this.letraTraducao = resourceLoader.loadTraducao(getNome(), extensaoDaTraducao);
    }

    @Override
    public Boolean finish() {
        return this.linha >= this.letraTraducao.size();
    }

    @Override
    public String play() {
        return this.musica.play() + "\n" + this.letraTraducao.get(this.linha++);
    }
}