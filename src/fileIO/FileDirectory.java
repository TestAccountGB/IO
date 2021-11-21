package fileIO;

import java.io.File;
import java.io.IOException;

public class FileDirectory {
	public static void main(String[] args) {
		
		//E a mesma base do File...
		File diretorio = new File("C:\\Users\\Test\\Desktop\\Pasta Loka");//Caminho que queremos criar
		
		System.out.println("Pasta Criada? " + diretorio.mkdir());
		//Mkdir. O que significa? mk = Make. dir = Directory. Make Directory, apenas isso mesmo :)
		
		//Ta, mas se eu quiser criar um arquivo dentro desse diretorio?
		//Simple my friend
		
		File arquivo = new File(diretorio, "txtAleatorio.txt"); //Como nosso java e marivilhoso, nao precisamos especeficar
		//O caminho completo assim...
		
		//File arquivo = new File("C:\\Users\\Test\\Desktop\\Pasta Loka\\txtAleatorio.txt");
		
		//Depois e so criar normalmente...
		
		try {
			System.out.println("Arquivo Criado? " + arquivo.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Metodos uteis com arquivos e diretorios...
		
		//renameTo()
		
		//Como o nome ja diz ele consegue renomear, mas nao apenas renomear, ele pode tambem mudar o diretorio
		
		//Primeiro temos que criar um arquivo para usar, que vamos que tipo que usar ele como referencia
		
		File arquivoAux = new File(diretorio, "txtAleatorioRenamed.txt");//Aqui podemos mudar o diretorio, mas vou
		//Deixar o mesmo
		
		System.out.println("Arquivo Renomeado? " + arquivo.renameTo(arquivoAux));//Depois e so usar o metodo
		
		//Podemos fazer o mesmo com o diretorio...
		
		File diretorioAux = new File("C:\\Users\\Test\\Desktop\\Pasta");
		
		System.out.println("Diretorio Renomeado? " + diretorio.renameTo(diretorioAux));
		
		//Metodo list()
		
		//Ele lista tudos os arquivos/pastas que estao dentro do diretorio.
		
		String[] lista = diretorio.list(); //Tem que ter em mente que ele vai atras do diretorio que a variavel file ta referenciando
		//Obs.: O renameTo nao muda a variavel, entao ele ta indo atras da "Pasta Loka" nao de "Pasta", pode dar erro
		//Na primeira execucao porque Pasta Loka nao vai existir, porque vai ser renomeado para "Pasta", mas na segunda
		//Vai funcionar porque ele vai criar uma Pasta Loka e nao vai conseguir renomear pra "Pasta", porque ja existe uma
		//Pasta com esse nome
		
		for(String list : lista) {
			System.out.println(list);
		}
		
		
	}
}