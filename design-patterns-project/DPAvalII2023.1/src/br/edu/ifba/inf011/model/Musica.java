package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

//Component no pattern Decorator
//Component no pattern composit

public interface Musica extends PlaylistItem {
	public String getNome();
	public String execute();
	public void reset();
	public Boolean finish();
	public String play();
}
