package br.edu.ifba.inf011.model.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.MusicaNotas;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorLetra;
import br.edu.ifba.inf011.model.decorator.ConcreteDecoratorLetraTraducao;
import br.edu.ifba.inf011.model.decorator.DecoratoMusica;

public class ResourceLoader {
	
	public static String DIR_NAME = "C:\\Users\\emane\\OneDrive\\Documentos\\IFBA2023\\PADROES\\design-patterns\\design-patterns-project\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		
	
	public static ResourceLoader loader;
	
	public static ResourceLoader instance() {
		if(ResourceLoader.loader == null)
			ResourceLoader.loader = new ResourceLoader();
		return ResourceLoader.loader;
	}
	
	//Entender esse metodo de criação que não está sendo usado em lugar algum
	public MusicaNotas createMusica(String nome) throws IOException {
		MusicaNotas musica = new MusicaNotas(nome);
		musica.setAcordes(this.loadNotas(nome));
		return musica;
	}
	public DecoratoMusica createMusicaNotaELetra(String nome) throws IOException {
		MusicaNotas musicaNotas = new MusicaNotas(nome);
		ConcreteDecoratorLetra componentLetra = new ConcreteDecoratorLetra(musicaNotas);
		return  componentLetra;
	}

	public DecoratoMusica createrMusicaComLetraOriginalTraduzida(String nome, String extensao)
			throws IOException {
		MusicaNotas musicaComLetraOriginalTraduzida = new MusicaNotas(nome);
		ConcreteDecoratorLetra componentLetra = new ConcreteDecoratorLetra(musicaComLetraOriginalTraduzida);
		return new ConcreteDecoratorLetraTraducao(componentLetra, "pt");
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
