package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

// Iterator no pattern Iterator
public interface IteratorPlaylist {

    boolean temProximo();
    ComponentPlaylistItem proximo();
}
