package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

/* Aggregate: Iterator pattern */
public interface AgregatePlayer {
    void addItem(ComponentPlaylistItem item);
    void removeItem(ComponentPlaylistItem item);
    IteratorPlaylist createIterator();
}