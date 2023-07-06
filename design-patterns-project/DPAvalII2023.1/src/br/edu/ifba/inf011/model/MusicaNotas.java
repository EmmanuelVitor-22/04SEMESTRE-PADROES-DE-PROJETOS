package br.edu.ifba.inf011.model;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.decorator.DecoratoMusica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

// Concrete Decorator no pattern Decorator
// Leaf no pattern  Composite

public class MusicaNotas extends DecoratoMusica {
	private List<String> notas;
	
	public MusicaNotas(Musica musica) throws IOException {
		super(musica);
		this.setAcordes();
		this.reset();
	}
	

	public void setAcordes() throws  IOException{
		this.notas = resourceLoader.loadNotas(getNome());
	}
	public String play() {
		return this.musica.play() +  "\n" + this.notas.get(this.linha++);
	}
	public Boolean finish() {
		return this.linha >= this.notas.size();
	}
	public void reset() {
		 this.linha = 0;
	}






	

}
