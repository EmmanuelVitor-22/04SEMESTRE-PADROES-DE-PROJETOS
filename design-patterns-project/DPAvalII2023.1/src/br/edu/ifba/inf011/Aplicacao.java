package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.MusicaNotas;
import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorLetra;
import br.edu.ifba.inf011.model.decorator.DecoratoMusica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao {

	private void musica() throws IOException {
		int i =0;

		ResourceLoader.DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";

		System.out.println("\n");
		System.out.println("Aplicando Musica Somente");
		System.out.println("\n");

		Musica musica = new MusicaNotas("GodSaveTheQueen");
//		System.out.println(musica.execute());
//		System.out.println("\n");
//		DecoratoMusica decoratoMusica = ResourceLoader.instance().createMusicaNotaELetra("GodSaveTheQueen");
		DecoratoMusica decoratoMusicaNotaLetraETraduc = ResourceLoader.instance().createrMusicaComLetraOriginalTraduzida("GodSaveTheQueen","pt");

		System.out.println(decoratoMusicaNotaLetraETraduc.execute());

		System.out.println("\n");
		System.out.println("Aplicando Playlists");
		System.out.println("\n");

		DecoratoMusica m1 =  ResourceLoader.instance().createMusicaNotaELetra("AndreaDorea");
		DecoratoMusica m2 =  ResourceLoader.instance().createrMusicaComLetraOriginalTraduzida("GodSaveTheQueen","pt");

		Playlist playlist1 = new Playlist("Playlist 1");
		playlist1.insert(m1);
		playlist1.insert(m2);
		System.out.println(playlist1.execute());
	}

	private void teste() throws IOException {

		ResourceLoader.DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		Player player = new Player();
		int iCount = 0;

		// ......

		while (player.temProximo() && iCount < 30) {
			System.out.println(player.proximo());
			iCount++;
		}

	}

	public static void main(String[] args) throws IOException {
		Aplicacao app = new Aplicacao();
		app.musica();
		app.teste();

	}

}
