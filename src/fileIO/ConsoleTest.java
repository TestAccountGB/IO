package fileIO;

import java.io.Console;

public class ConsoleTest {
	public static void main(String[] args) {
		
		//Possivelmente voce nunca vai usar essa classe, por isso eu vou passar por ela bem rapido, so pra voce conhecer
		//Mesmo
		
		Console c = System.console(); //Estou usando o metodo console() porque e so assim que a gente consegue puxar
		//Informacoes digitadas no console
		
		
		while(true) {
			char[] password = c.readPassword("%s", "Password: ");//O %s significa que a gente vai receber em formato de String
			for(char pass : password) {
				c.format("%s", pass); //Vai mostrar no console uma string com os chars
			}
			c.format("\n"); //E quando acabar vai pular uma linha
			
			//Como vc viu aqui usamos o readPassword, por que? Porque ele retorna um array de char, e como ja expliquei
			//Senhas a gente nao usa String, porque fica na pool de String e isso e uma falha de seguranca
			
			//Usando o readLine() normal...
			
			String texto;
			
			texto = c.readLine("%s", "Digite: ");
			c.format("\nTexto digitado: %s", texto);//No %s vai ser substituido pelo texto
			
			//Ta, mas como mostra tudo em um console agr? Primeiramente crie um arquivo de texto, coloque o nome da classe
			//E bote a extensao dele como java, assim: ConsoleTest.java, depois disso edite ele com um bloco de notas e cole
			//Esse codigo inteiro dentro dele, menos a parte do package. Depois abra o console do windows (cmd) e depois 
			//Vai ate o Desktop no cmd e digite assim: javac ConsoleTest.java, se nao der nenhum erro ta safe, se der algum
			//Erro procure na Net como arrumar, e depois coloque assim: java ConsoleTest
			
			//Se o windows nao reconhecer o comado "javac" instale o jdk mais recente no site da Oracle
			
			//E pronto :D
		}
	}
}