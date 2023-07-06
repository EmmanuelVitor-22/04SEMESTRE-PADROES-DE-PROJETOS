package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;
import br.edu.ifba.inf011.model.iterator.AgregatePlayer;
import br.edu.ifba.inf011.model.iterator.IteratorPlaylist;
import br.edu.ifba.inf011.model.observer.ObserverPlayerListener;

import java.util.ArrayList;
import java.util.List;

// Concrete Aggregate no pattern Iterator
// Subject no pattern Observer 
public class Player implements AgregatePlayer {

	private List<ComponentPlaylistItem> itemList;
	private List<ObserverPlayerListener> listenerList;
	private PlayerMode mode;


	public Player() {
		this.itemList = new ArrayList<>();
		this.listenerList = new ArrayList<>();
		this.mode = PlayerMode.PlayerAll;
	}

	public void setMode(PlayerMode mode) {
		this.mode = mode;
		notificarListener();
	}

	@Override
	public void addItem(ComponentPlaylistItem item) {
		this.itemList.add(item);
	}

	@Override
	public void removeItem(ComponentPlaylistItem item) {
		this.itemList.remove(item);
	}

	@Override
	public IteratorPlaylist generateIterator() {
		return this.mode.generateIterator(itemList);
	}
	public void addListenersItem(ObserverPlayerListener playerListener) {
		this.listenerList.add(playerListener);
	}

	public PlayerMode getMode(){
		return this.mode;
	}

	public void notificarListener() {
		for (ObserverPlayerListener playerListener : listenerList) {
			playerListener.onChangeMode();
		}
	}
}

