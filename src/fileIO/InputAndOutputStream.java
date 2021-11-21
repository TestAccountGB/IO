package fileIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputAndOutputStream {
	public static void main(String[] args) {
		
		//O que Input e Output Stream? Input e quando a gente recebe um valor e Output a gente manda. Basicamente
		//O Input e um Reader e Output e um Writer, e o que significa Stream? E um Streaming, imagina que voce esta
		//Assistindo algo, e sua net fica lenta, o video vai comecar a travar ne? Por que? Porque a transmissao de dados 
		//Por bytes (Stream) foi intemrropida, mas o que isso tem a ver com o Input e Output Stream? O Input e o Output
		//Sao iguais ao Writer e Reader (Na verdade o Writer e o Reader extendem o Input e Output), mas trabalham 
		//Com bytes ao inves de chars e Strings, que e a logica usada para comprimir arquivos. Pelo que eu entendi
		//Eles transformam char em byte
		
		//Criando array para escrever...
		byte[] todosOsBytes = new byte[127];
		for(byte i = 1; i < todosOsBytes.length; i++) {
			todosOsBytes[i] = i;
		}
		
		//Se quiser aprender sobre paths va ate o projeto "NIO"
		Path path = Paths.get(System.getProperty("user.home")+"/Desktop/GravadorByte.txt");
		Path pathBolado = Paths.get(System.getProperty("user.home")+"/Desktop/GravadorByteBolado.txt");
		
		gravadorByte(todosOsBytes, path);
		leitor(path);
		
		System.out.println("\n========Gravador e Leitor Bolado========\n");
		
		gravadorBolado(todosOsBytes, pathBolado);
		leitorBolado(pathBolado);
	}
	
	public static void gravadorByte(byte[] texto, Path caminho) {
		
		try(FileOutputStream gravador = new FileOutputStream(caminho.toFile())){//Obs.: Tambem podemos passar uma String
			//Aqui a gente passa um arquivo, se o arquivo nao estiver criado, ele vai criar automaticamente, e caso ja exista, 
			//Ele vai sobrecresver, podemos mudar isso botando um "true" em seu construtor, assim ao inves de sobrescrever
			//O arquivo ele vai adicionar (append)
			
			gravador.write(texto);//Write normal, mas aqui passamos um array de byte
			
			gravador.flush(); //Flush para garantir. Nao faz muito sentido essa classe ter o flush, porque o flush serve para
			//Ter a certeza que o arquivo em memoria foi "empurrado", ou seja, ele funciona com as classes Buffered
			//Que trabalham na memoria, as classes sem o Buffered trabalham direto no disco rigido, por isso que as classes
			//Buffered normalmente sao mais rapidas, porque elas abrem apenas um canal de transmissao de dados para
			//Receber tudo de vez, enquanto trabalhar diretamente pelo disco rigido, ele abre e fecha um canal a cada 
			//Byte passado
			
			System.out.println("Escrito com sucesso!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Leitor...
	
	public static void leitor(Path caminho) {
		
		try(FileInputStream leitor = new FileInputStream(caminho.toFile())){//Aqui usamos um File, mas vou usar path pq eu quero :D
			
			int leitura; //Por que um int? Porque o read() do input retorna um int, mas por que ele retorna um int sendo que
			//Trabalha com bytes? Sla pora
			
			//Uma coisa interessante que da pra falar, e que o .read() do Input quando chega no final ele retorna -1, por que?
			//Nao sei, mas retorna -1, e podemos fazer uma estrura como esta abaixo
			
			System.out.println("Arquivo de texto (Em bytes):");
			
			while((leitura = leitor.read()) != -1) {//Quando leitura chegar a -1, quer dizer que acabou o texto
				byte Byte = (byte) leitura;//Cast pra ficar em byte bunitinho
				System.out.println(Byte);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Gravador e Leitor Buffered...
	
	public static void gravadorBolado(byte[] texto, Path path) {
		
		//Como voce ja deve saber, todo Buffered em seu construtor pra ser instanciado ele pede a versao dele nao
		//Buffered ._.
		
		try(BufferedOutputStream gravadorBolado = new BufferedOutputStream(new FileOutputStream(path.toFile()))) {
			
			//Seu codigo nao muda em nada alem do construtor...
			
			gravadorBolado.write(texto);
			gravadorBolado.flush();
			System.out.println("Escrito com sucesso Boladamente!");
			
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public static void leitorBolado(Path path) {
		
		try(BufferedInputStream leitorBolado = new BufferedInputStream(new FileInputStream(path.toFile()))){
			
			int leitura;
			
			System.out.println("Leitor de Texto Bolado (Em bytes):");
			
			byte[] v = new byte[12];
			while((leitura = leitorBolado.read(v)) != -1) {
				byte Byte = (byte) leitura;
				System.out.println(Byte);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
