package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

public interface PlayerIterable {
    void addItem(PlaylistItem item);
    void removeItem(PlaylistItem item);
    PlaylistIterator createIterator();
}