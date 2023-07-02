package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist implements ComponentPlaylistItem {

	private final String nome;
	private List<ComponentPlaylistItem> componenteItems;
//	private List<Playlist> musicas;
//	private List<Playlist> playlists;

	public Playlist(String nome) {
		this.nome = nome;
		this.componenteItems = new ArrayList<>();
//		this.musicas = new ArrayList<Musica>();
//		this.playlists = new ArrayList<Playlist>();
	}

	public void insert(ComponentPlaylistItem componenteItem) {
		this.componenteItems.add(componenteItem);
	}

	public void remove(ComponentPlaylistItem componentPlaylistItem) {
		this.componenteItems.remove(componentPlaylistItem);
	}

	public String getNome() {
		return this.nome;
	};

	public String randomize() {
		if (!componenteItems.isEmpty()){
			Random random = new Random();
			int sorteadado = random.nextInt(componenteItems.size());
			ComponentPlaylistItem componentItemAleatorio = componenteItems.get(sorteadado);
			if (componentItemAleatorio instanceof  Musica){
				return componentItemAleatorio.execute();
			}
			Playlist playlistRandom = (Playlist) componentItemAleatorio;
			return playlistRandom.randomize();
		}
		return null;
	};

	public String execute() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append( this.nome + "\n");
		for (ComponentPlaylistItem componenteItems: this.componenteItem){
			stringBuffer.append( componenteItems.execute() + "\n");

		}

		return stringBuffer.toString();
	}

}
