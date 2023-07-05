package br.edu.ifba.inf011.model.iterator;

import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;

import java.util.List;
import java.util.Random;

/* Concrete Iterator no padrão de projeto Iterator  */
public class ConcreteIteratorRandomMode implements IteratorPlaylist {

    private Random random;
    private List<ComponentPlaylistItem> itemList;

    public ConcreteIteratorRandomMode(List<ComponentPlaylistItem> itemList) {
        this.random = new Random();
        this.itemList = itemList;
    }
    private int nextRandom() {
        return random.nextInt(this.itemList.size());
    }
    @Override
    public boolean temProximo() {
        return true;
    }

    @Override
    public ComponentPlaylistItem proximo() {
        ComponentPlaylistItem item =itemList.get(nextRandom());
        if (item instanceof Playlist){
            return ((Playlist) item).randomize();
        }
        return item;
    }
}
