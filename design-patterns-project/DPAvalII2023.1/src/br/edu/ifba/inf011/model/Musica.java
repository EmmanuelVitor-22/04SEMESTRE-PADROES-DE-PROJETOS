package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

//Component no pattern Decorator
//Component no pattern composit

public interface Musica extends ComponentPlaylistItem {
	public String getNome();
	public String execute();
	public void reset();
	public Boolean finish();
	public String play();
}
