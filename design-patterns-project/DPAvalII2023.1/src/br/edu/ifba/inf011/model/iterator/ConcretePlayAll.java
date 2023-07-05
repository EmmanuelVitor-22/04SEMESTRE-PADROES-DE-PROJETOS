package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

import java.util.List;
/* Concrete Iterator no padrão de projeto Iterator  */
public class ConcretePlayAll implements IteratorPlaylist {

    private final List<ComponentPlaylistItem> itemList;
    private Integer index;

    public ConcretePlayAll(List<ComponentPlaylistItem> itemList) {
        this.itemList = itemList;
        this.reset();
    }

    @Override
    public boolean temProximo() {
        return this.index < this.itemList.size();
    }

    @Override
    public ComponentPlaylistItem proximo() {
        if(this.temProximo()) return itemList.get(index++);
        return null;
    }
    public  void  reset(){
         this.index = 0;
    }
}
