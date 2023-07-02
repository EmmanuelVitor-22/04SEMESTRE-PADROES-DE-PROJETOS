package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

import java.util.ArrayList;
import java.util.List;

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
	

	public String getNome() {
		return this.nome;
	};
	
	public String randomize() {
		return null;
	};
	
	public String execute() {
		return null;
	}	

}
