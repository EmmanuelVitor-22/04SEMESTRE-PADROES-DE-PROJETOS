package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Composite no pattern  Composite
public class Playlist implements ComponentPlaylistItem {

	private final String nome;
	private List<ComponentPlaylistItem> items;

	public Playlist(String nome) {
		this.nome = nome;
		this.items = new ArrayList<>();
	}

	public void insert(ComponentPlaylistItem item) {
		this.items.add(item);
	}

	public String getNome() {
		return this.nome;
	};

	public ComponentPlaylistItem randomize() {
		int random = new Random().nextInt(items.size());
		ComponentPlaylistItem item = items.get(random);
		if (item instanceof Playlist) {
			return ((Playlist) item).randomize();
		}
		return item;
	}

	public String execute() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(  this.getNome() + "\n");
		for (ComponentPlaylistItem item: items){
			stringBuffer.append( item.execute() + "\n");
			stringBuffer.append(" ----------------------------------- \n");
		}
		return stringBuffer.toString();
	}

}
