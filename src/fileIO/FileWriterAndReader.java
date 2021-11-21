package fileIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAndReader {
	public static void main(String[] args) {
		
		//Primeiramente para escrever e ler um arquivo, precisamos claramente criar um arquivo ._.
		
		File file = new File("C:\\Users\\Test\\Desktop\\Arquivo.txt");//Vai ta na desktop
		
		//FileWriter fw = new FileWriter("C:\\Users\\Test\\Desktop\\Arquivo.txt");
		//Podemos fazer isso
		
		try(FileWriter fw = new FileWriter(file/*, true*/); //Podemos escrever true aqui que vai o .write() vai ficar com a
				//A mesma funcao do append(), ou seja, ele nao vai sobrescrever, ele vai adicionar. Testa ai, executa o codigo
				//Varias vezes sem o true e depois executa varias fazer com true. Em padrao fica false, nao precisa escrever
				//False no construtor
				
				//Try With Resource, para que feche (.close) automaticamente
				FileReader fr = new FileReader(file)){ //No construtor podemos passar igual no File que ele vai criar um File
			//Automaticamente, mas as boas praticas dizem para criar um separado, porque fica mais organizado e mais facil
			//De se achar no codigo
			fw.write("Teste\r\nVoce e gay");// \r\n Para pular uma linha
			fw.flush();//Esse comando serve para limpar toda a memoria que pode ter ficado dentro do Writer, a gente nao
			//E obrigado a usar esse comando, mas serve para garantir que nada ficou dentro do escritor. Porque quando
			//A gente escreve algo no Writer o Sistema Operacional abre que tipo um canal que podemos se comunicar por
			//Ele e escrever por la e fica na memoria isso, e esse comando serve pra limpar, como ele faz isso? sla porra kkk
			
			//Agora vamos falar do Reader...
			
			//E bem interessante como ele funciona, imagina que ele esta tentando ler um arquivo que esta fora do codigo,
			//E como String e algo que nao "existe" e e apenas um array de char, entao vamos pegar cada letra do arquivo
			//E adicionar a um array de char
			
			char[] stringBugada = new char[400];//Se voce nao souber o tamanho do arquivo que vai ler, so bota um numero
			//Grande ai fds kk
			
			int size = fr.read(stringBugada); //fr.read devolve um numero, esse numero significa o tanto de chars que o Reader conseguiu
			//Ler, mesmo que a gente esteja botando em uma variavel, o comando .read() vai executar.
			
			StringBuilder StringBuilder = new StringBuilder();
			String stringNormal= "";
			for(char string : stringBugada) {
				System.out.print(string);//Nao podemos usar o println, porque se nao ele vai pular uma linha a cada char
				//Testa ai pra vc ver, e engracado kk
				
				StringBuilder.append(string);//Aqui estamos adicionando char por char em uma StringBuilder
			}
			
			//Podemos apenas passar em uma StringBuilder, pois o codigo vai ficar muito mais leve, porque imagina, criar
			//Uma String nova a cada char passado (Por causa da StringPool), e caso depois voce quiser trabalhar com String,
			//Voce pode passar uma StringBuilder para uma StringNormal com esse comando...
			
			stringNormal = StringBuilder.toString(); //Assim eu acho que fica bem mais leve, do que criar uma String nova
			//A cada loop no for
			
			
			System.out.println("\n=============\n\nNa StringBuilder: ");
			System.out.println(StringBuilder);
			System.out.println("\n=============\n\nNa StringNormal: ");
			System.out.println(stringNormal);
			System.out.println("\n=============\n\nQuantidade de chars lido: ");
			System.out.println(size);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
