package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Composite no pattern  Composite
public class Playlist implements PlaylistItem {

	private final String nome;
	private List<PlaylistItem> items;


	public Playlist(String nome) {
		this.nome = nome;
		this.items = new ArrayList<>();

	}

	public void insert(PlaylistItem item) {
		this.items.add(item);
	}



	public String getNome() {
		return this.nome;
	};

	public String randomize() {
		if (!items.isEmpty()){
			Random random = new Random();
			int sorteadado = random.nextInt(items.size());
			PlaylistItem playlistItemItemAleatorio = items.get(sorteadado);
			if (playlistItemItemAleatorio instanceof  Musica){
				return playlistItemItemAleatorio.execute();
			}
			Playlist playlistRandom = (Playlist) playlistItemItemAleatorio;
			return playlistRandom.randomize();
		}
		return null;
	};

	public String execute() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append( this.getNome() + "\n");
		for (PlaylistItem item: items){
			stringBuffer.append( item.execute() + "\n");

		}

		return stringBuffer.toString();
	}

}
