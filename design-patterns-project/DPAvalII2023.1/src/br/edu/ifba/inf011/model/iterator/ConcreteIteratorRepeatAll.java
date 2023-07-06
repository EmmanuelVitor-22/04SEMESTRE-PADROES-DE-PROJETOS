package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

import java.util.List;

// Concrete Iterator no pattern Iterator

public class ConcreteIteratorRepeatAll implements IteratorPlaylist {

    private final List<ComponentPlaylistItem> itemList;
    private Integer index;

    public ConcreteIteratorRepeatAll(List<ComponentPlaylistItem> itemList) {
        this.reset();
        this.itemList = itemList;
    }
    public void reset() {
        this.index = 0;
    }
    @Override
    public boolean temProximo() {
        return true;
    }

    @Override
    public ComponentPlaylistItem proximo() {
        if (index >= itemList.size()) {
            this.reset();
        }
        return itemList.get(index++);
    }


}
