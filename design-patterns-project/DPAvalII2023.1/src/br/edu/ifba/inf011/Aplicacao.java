package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.MusicaNotas;
import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.decorator.DecoratoMusica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao {

	private void musica() throws IOException {
		int i =0;

		ResourceLoader.DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";



		Musica musica = new MusicaNotas("AndreaDorea");
		System.out.println(musica.execute());
		System.out.println("\n");
		DecoratoMusica decoratoMusica = ResourceLoader.instance().createrMusicaComLetraOriginalTraduzida("GodSaveTheQueen","pt");

		System.out.println(decoratoMusica.execute());

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
