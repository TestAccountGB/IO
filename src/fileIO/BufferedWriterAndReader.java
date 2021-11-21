package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterAndReader {
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Test\\Desktop\\Arquivo.txt"); //Ele ja cria o arquivo automaticamente
		
		//Qual e a diferenca de BufferedWriter para o FileWriter, ele e mais rapido do que o FileWriter (mesma que eu tenha
		//Testado com textos grandes e nao percebi nenhuma diferenca ._.), e tambem ele tem o metodo newLine(), que
		//Realiza a mesma funcao que "\r\n" mas a diferenca e que ele funciona em todos os Sistemas Operacionais, o
		//"\r\n" so funciona no Windows.
		
		//Construtor...
		
		//No seu construtor a gente cria um FileWriter dentro dos parametros do BufferedWriter. A mesma coisa com o
		//BufferedReader...
		
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				BufferedReader br = new BufferedReader(new FileReader(file))){
			bw.write("Texto Aleatorio kkk");
			bw.newLine();
			bw.write("kk Gay");
			bw.flush();
			
			//Como podemos perceber aqui nao muda porra nenhuma no Writer kkk
			
			//Mas a maior diferenca e com o Reader que realmente tem uma diferenca legal, nao precisamos criar um
			//Array de char, ele le uma linha inteira com o comando readLine(), ou seja, se tiver um newLine() ele vai criar 
			//Uma nova linha e vamos precisar de outro readLine().
			
			//Por isso precisamos colocar em loop, como mostra a comando abaixo.
			
			//E ele sim e realmente mais rapido do que o normal.
			
			String string;
			StringBuilder sb = new StringBuilder();
			sb.append("");
			String aux = "";//Aqui eu cria uma String auxiliar para que possamos passar tudo pra ela fora do loop while.
			
			br.mark(28);//Esse metodo apenas serve para usar o reset(), que em seu parametro a gente fala quantos
			//caracteres a gente quer resetar. Vou usar o reset() la em baixo
			
			while((string = br.readLine()) != null) {
				//Esta escrito assim: s = linha do texto (inteira), se ela for igual a null, quer dizer que o texto ja acabou e acaba
				//O loop
				
				aux += "\n" + string; //A cada loop ele vai adicionar um espaco, por que? Porque o loop so vai acontecer quando
				//Tiver em outra linha, como ele nao adiciona o newLine() pra gente, a gente adiciona aqui mesmo
				
				//Aqui nao muda usar uma StringBuilder, porque o readLine() ja retorna uma String, ou seja, essa String ja
				//Vai para o pool de String.
				
			}
			
			System.out.println(aux);
			
			//Observacao importantissima: Amigo, agora que voce viu esse comando readLine(), voce possivelmente so vai
			//Usar ele, ao inves do read(), mas pense bem, porque esse readLine() retorna uma String, e essa String vai
			//Automaticamente para a pool de String, entao imagina que eu tenho uma senha para passar pro banco,
			//Se eu usar o readLine() essa senha vai pro pool de String, e de la eu nao consigo tirar, e isso e uma falha de
			//Seguranca gravissima, porque um hacker pode facilmente pegar ela la, ou seja, quando tiver que ler arquivos
			//Importantes, use o read() porque ele vai retornar um array de char, e esse array eu consigo apagar de boa.
			
			//Obs.: Esse BufferedReader tambem tem os metodos do Reader normal.
			
			char[] array = new char[500];
			
			br.reset();//Precisamos resetar tudo, porque o Reader ja leu tudo la em cima
			
			br.read(array); //Demonstracao, que funciona do mesmo jeito do que o Reader normal
			
			System.out.println("\n\nDemonstracao");
			for(char Char : array) {
				System.out.print(Char);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	}