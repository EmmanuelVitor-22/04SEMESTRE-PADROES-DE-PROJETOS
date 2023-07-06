package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

// Aggregate no pattern Iterator
public interface AgregatePlayer {
    void addItem(ComponentPlaylistItem item);
    void removeItem(ComponentPlaylistItem item);
    IteratorPlaylist generateIterator();
}