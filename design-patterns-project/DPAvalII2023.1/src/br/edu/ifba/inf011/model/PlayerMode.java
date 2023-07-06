package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;
import br.edu.ifba.inf011.model.iterator.ConcreteIteratorRandomMode;
import br.edu.ifba.inf011.model.iterator.ConcreteIteratorRepeatAll;
import br.edu.ifba.inf011.model.iterator.ConcreteIteratorPlayAll;
import br.edu.ifba.inf011.model.iterator.IteratorPlaylist;

import java.util.List;

public enum PlayerMode {

	PlayerAll {
		@Override
		public IteratorPlaylist generateIterator(List<ComponentPlaylistItem> itemList) {
			return new ConcreteIteratorPlayAll(itemList);
		}
	}, RepeatAll {
		@Override
		public IteratorPlaylist generateIterator(List<ComponentPlaylistItem> itemList) {
			return new ConcreteIteratorRepeatAll(itemList);
		}
	}, RandomMode {
		@Override
		public IteratorPlaylist generateIterator(List<ComponentPlaylistItem> itemList) {
			return new ConcreteIteratorRandomMode(itemList);
		}
	};

	public abstract IteratorPlaylist generateIterator(List<ComponentPlaylistItem> items);

}
