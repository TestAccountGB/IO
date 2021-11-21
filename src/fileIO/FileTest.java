package fileIO;

import java.io.File;
import java.io.IOException;
import java.util.Date;
public class FileTest {
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Test\\Desktop\\Arquivo.txt");
		//Uma classe basica da java.IO e a File, ela basicamente cria arquivos em caminhos que botamos em seu construtor,
		//Botamos a extensao no final, por exemplo: .exe, .txt, .png etc.
		
		//Obs.: Precisamos usar duas contra-barras porque uma contra-barra usa para comandos do java.
		
		//Comandos uteis...
		
		try {
			System.out.println("Arquivo criado? "+file.createNewFile());
			//Nao e so porque esta em sysout que nao vai executar o codigo ele vai executar o codigo dentro do sysout.
		} catch (IOException e) {
			System.out.println("Deu errado pora");;
		}
		
		//Precisamos usar um try...catch, porque as vezes o java nao vai conseguir criar um arquivo
		
		System.out.println("Podemos executar? " + file.canExecute());
		System.out.println("Temos permisao de escrever? " + file.canWrite());
		System.out.println("O arquivo existe? " + file.exists());
		System.out.println("Caminho que escrevemos no construtor do file: " + file.getPath());
		System.out.println("Caminho que ele esta: " + file.getAbsolutePath());
		System.out.println("E um diretorio? " + file.isDirectory());
		System.out.println("E um arquivo? " + file.isFile());
		System.out.println("Esta oculto? " + file.isHidden());
		System.out.println("Ultima vez modificado: " + file.lastModified());//Retorna varios numeros, porque esta em
		//Milisegundos (date), para pegarmos a data exata, vamos fazer assim...
		System.out.println("Ultima vez modificado: " + new Date(file.lastModified()));
		if(file.exists()) {
			System.out.println("Deletado? " + file.delete());
		}
		
	}
}