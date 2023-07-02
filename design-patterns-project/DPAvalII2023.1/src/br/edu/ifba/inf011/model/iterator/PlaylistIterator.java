package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

public interface PlaylistIterator {

    boolean temProximo();
    PlaylistItem proximo();
}
