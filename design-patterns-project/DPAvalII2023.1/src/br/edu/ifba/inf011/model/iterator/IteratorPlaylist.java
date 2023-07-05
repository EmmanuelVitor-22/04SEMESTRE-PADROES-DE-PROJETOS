package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

/* Iterator:no padrao de projeto Iterator */
public interface IteratorPlaylist {

    boolean temProximo();
    ComponentPlaylistItem proximo();
}
