package br.edu.ifba.inf011.model.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.MusicaNotas;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorLetra;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorLetraTraducao;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorMusicaNome;
import br.edu.ifba.inf011.model.decorator.DecoratoMusica;

public class ResourceLoader {

	public static String DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
	public static ResourceLoader loader = null;

	public static ResourceLoader instance() {
		if(ResourceLoader.loader == null) {
			ResourceLoader.loader = new ResourceLoader();
		}
		return ResourceLoader.loader;
	}
	public DecoratoMusica createMusicaNota(String nome) throws IOException {
		Musica musicaNome = new ConcreteDecoratorMusicaNome(nome);
		MusicaNotas musicaNota = new MusicaNotas(musicaNome);
		return musicaNota;
	}
	public DecoratoMusica createMusicaNotaLetra(String nome) throws IOException {
		Musica musicaNome = new ConcreteDecoratorMusicaNome(nome);
		MusicaNotas musicaNota= new MusicaNotas(musicaNome);
		ConcreteDecoratorLetra musicaNotaLetra = new ConcreteDecoratorLetra(musicaNota);
		return musicaNotaLetra;
	}

	public DecoratoMusica  createMusicaNotaLetraTraducao(String nome, String extensao) throws IOException {
		Musica musicaNome = new ConcreteDecoratorMusicaNome(nome);
		MusicaNotas musicaNota = new MusicaNotas(musicaNome);
		ConcreteDecoratorLetra  musicaLetra = new ConcreteDecoratorLetra(musicaNota);
		ConcreteDecoratorLetraTraducao  musicaTraducao = new ConcreteDecoratorLetraTraducao(musicaLetra, "pt");
		return musicaTraducao;
	}

	// Alguns exemplos de outras formas de decorar (pode fazer outros tipos de deocração)
	//Letra e tradução
	public DecoratoMusica  createMusicaLetraTraducao(String nome, String extensao) throws IOException {
		Musica musicaNome = new ConcreteDecoratorMusicaNome(nome);
		ConcreteDecoratorLetra componentLetra = new ConcreteDecoratorLetra(musicaNome);
		ConcreteDecoratorLetraTraducao letraTraducao = new ConcreteDecoratorLetraTraducao(componentLetra, "pt");
		return letraTraducao;
	}

	// Somente tradução
	public DecoratoMusica  createMusicaTraducao(String nome, String extensao) throws IOException {
		Musica musicaNome = new ConcreteDecoratorMusicaNome(nome);
		ConcreteDecoratorLetraTraducao letraTraducao = new ConcreteDecoratorLetraTraducao(musicaNome, "pt");
		return letraTraducao;
	}

	public List<String> loadNotas(String nome) throws IOException {
		return this.loadResource(nome, "notas");
	}

	public List<String> loadLetra(String nome) throws IOException {
		return this.loadResource(nome, "letra");
	}

	public List<String> loadTraducao(String nome, String extensao) throws IOException {
		return this.loadResource(nome, extensao);
	}

	public List<String> loadResource(String nome, String extensao) throws IOException {
		List<String> resource = new ArrayList<String>();
        Path path = Paths.get(ResourceLoader.DIR_NAME + nome + "." + extensao);
        Files.lines(path, StandardCharsets.ISO_8859_1).forEach(resource::add);
        return resource;
	}

}
