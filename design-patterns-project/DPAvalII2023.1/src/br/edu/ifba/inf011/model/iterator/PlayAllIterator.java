package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.PlaylistItem;

import java.util.List;

public class PlayAllIterator implements PlaylistIterator{

    private final List<PlaylistItem> items;
    private Integer index;

    public PlayAllIterator(List<PlaylistItem> items) {
        this.items = items;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.items.size();
    }

    @Override
    public PlaylistItem proximo() {
        if(this.temProximo()) return items.get(index++);
        return null;
    }
    public  void  reset(){
         this.index = 0;
    }
}
