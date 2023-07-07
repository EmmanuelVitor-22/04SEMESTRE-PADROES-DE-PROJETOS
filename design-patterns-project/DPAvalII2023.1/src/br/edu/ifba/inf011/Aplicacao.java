package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.*;
import br.edu.ifba.inf011.model.composite.ComponentPlaylistItem;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorLetra;
import br.edu.ifba.inf011.model.decorator.DecoratoMusica;
import br.edu.ifba.inf011.model.iterator.IteratorPlaylist;
import br.edu.ifba.inf011.model.observer.ObserverPlayerListener;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

// Concrete Observer no pattern Observer
public class Aplicacao implements ObserverPlayerListener {

	private  Player player;
	private  int count =0;

	public Aplicacao() {
		this.player = new Player();
		this.player.addListenersItem(this);
	}

	@Override
	public void onChangeMode() {
		System.out.println("\n ***** Modo "+player.getMode()+" ativado.");

	}

	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		var resourceInstance = ResourceLoader.instance();

		/*Declarando os decoradores que serão usados avulsos ou em playlist */

		/*Decorador da musica: GodSaveTheQueen*/
		DecoratoMusica GodSaveTheQueenNotas = resourceInstance.createMusicaNota("GodSaveTheQueen");
		DecoratoMusica GodSaveTheQueenNotaLetra = resourceInstance.createMusicaNotaLetra("GodSaveTheQueen");
		DecoratoMusica GodSaveTheQueenNotaLetraTraducao = resourceInstance.createMusicaNotaLetraTraducao("GodSaveTheQueen","pt");
        /*Exemplos de outras formas de decorar
		 DecoratoMusica musicaLetraTraducao = resourceInstance.createMusicaLetraTraducao("GodSaveTheQueen","pt");
		 DecoratoMusica musicaTraducao = resourceInstance.createMusicaTraducao("GodSaveTheQueen","pt");*/

		/* Decorador da musica: AndreaDorea*/
		DecoratoMusica AndreaDoreaNotas = resourceInstance.createMusicaNota("AndreaDorea");
		DecoratoMusica AndreaDoreaNotaLetra = resourceInstance.createMusicaNotaLetra("AndreaDorea");

		/*Decorador da musica: Lullaby */
		DecoratoMusica LullabyNotas = resourceInstance.createMusicaNota("Lullaby");
		DecoratoMusica LullabyNotaLetra = resourceInstance.createMusicaNotaLetra("Lullaby");
		DecoratoMusica LullabyNotaLetraTraducao = resourceInstance.createMusicaNotaLetraTraducao("Lullaby","pt");

		/*Decorador da musica: ReelAroundFountain */
		DecoratoMusica ReelAroundFountainNotas = resourceInstance.createMusicaNota("ReelAroundFountain");
		DecoratoMusica ReelAroundFountainNotaLetra = resourceInstance.createMusicaNotaLetra("ReelAroundFountain");
		DecoratoMusica ReelAroundFountainNotaLetraTraducao = resourceInstance.createMusicaNotaLetraTraducao("ReelAroundFountain","pt");


		Playlist playlist = new Playlist("My Playlis de Ferias");
		System.out.println("\n");
//
		playlist.insert(LullabyNotaLetraTraducao);
		playlist.insert(GodSaveTheQueenNotaLetraTraducao);
		playlist.insert(ReelAroundFountainNotaLetraTraducao);
//		playlist.insert(AndreaDoreaNotaLetra);

		System.out.println("\n");
		System.out.println("\n");

		Playlist playlist2 = new Playlist("Vamos passar baby");
		playlist2.insert(LullabyNotaLetra);
		playlist2.insert(playlist);
		System.out.println(playlist2.execute());

	}

	private void musicPlayer() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

		var resourceInstance = ResourceLoader.instance();

		/*Decorador da musica: GodSaveTheQueen*/
		DecoratoMusica GodSaveTheQueenNotas = resourceInstance.createMusicaNota("GodSaveTheQueen");
		DecoratoMusica GodSaveTheQueenNotaLetra = resourceInstance.createMusicaNotaLetra("GodSaveTheQueen");
		DecoratoMusica GodSaveTheQueenNotaLetraTraducao = resourceInstance.createMusicaNotaLetraTraducao("GodSaveTheQueen","pt");
		/* Decorador da musica: AndreaDorea*/
		DecoratoMusica AndreaDoreaNotas = resourceInstance.createMusicaNota("AndreaDorea");
		DecoratoMusica AndreaDoreaNotaLetra = resourceInstance.createMusicaNotaLetra("AndreaDorea");
		/*Decorador da musica: Lullaby */
		DecoratoMusica LullabyNotas = resourceInstance.createMusicaNota("Lullaby");
		DecoratoMusica LullabyNotaLetra = resourceInstance.createMusicaNotaLetra("Lullaby");
		DecoratoMusica LullabyNotaLetraTraducao = resourceInstance.createMusicaNotaLetraTraducao("Lullaby","pt");
		/*Decorador da musica: ReelAroundFountain */
		DecoratoMusica ReelAroundFountainNotas = resourceInstance.createMusicaNota("ReelAroundFountain");
		DecoratoMusica ReelAroundFountainNotaLetra = resourceInstance.createMusicaNotaLetra("ReelAroundFountain");
		DecoratoMusica ReelAroundFountainNotaLetraTraducao = resourceInstance.createMusicaNotaLetraTraducao("ReelAroundFountain","pt");


		Playlist playlistNova = new Playlist("My Playlis de Acalmar Fred");
		System.out.println("\n");

		playlistNova.insert(AndreaDoreaNotas);
		playlistNova.insert(ReelAroundFountainNotaLetra);

		//System.out.println("\n");
		//System.out.println("\n");

		Playlist playlistNova2 = new Playlist("Padroes de projeto lofi");
		playlistNova2.insert(GodSaveTheQueenNotaLetraTraducao);
		playlistNova2.insert(playlistNova);

		System.out.println(playlistNova2.execute());

		player.addItem(ReelAroundFountainNotaLetraTraducao);
		player.addItem(LullabyNotas);
		player.addItem(playlistNova);
		player.addItem(GodSaveTheQueenNotaLetra);
		player.addItem(playlistNova2);

		IteratorPlaylist iteratorPlaylist = player.generateIterator();

		while (iteratorPlaylist.temProximo() && count<30) {
			ComponentPlaylistItem playlistItem = iteratorPlaylist.proximo();
			String content = playlistItem.execute();
			System.out.println(content);
			player.setMode(PlayerMode.RepeatAll);
			iteratorPlaylist = player.generateIterator();
			//player.setMode(PlayerMode.RepeatAll);
			//iteratorPlaylist = player.generateIterator();

			count++;
		}
	}

	public static void main(String[] args) throws IOException {
		Aplicacao app = new Aplicacao();
//		app.musica();
		app.musicPlayer();

	}


}
