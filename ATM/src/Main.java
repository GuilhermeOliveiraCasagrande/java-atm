import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		//Fazer salvar os dados dos usuarios em um array
		//Fazer ler o array para utilizar os dados dos usuarios
		//escrever nome do usuario -> se exisitr perguntar a senha -> se a senha estiver correta dar acesso
		//Guilherme 1234 5432 5000.0 SenhaSuperComplexa12345
		
		Scanner teclado = new Scanner(System.in);
		BufferedReader arqReader = new BufferedReader(new FileReader("users.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"));
		Object[] info = new Object[5];
		
		info[0] = arqReader.readLine();
		System.out.println(info[0]);
		
		String nome = (String) info[0];
		int numBanco = (int) info[1];
		int numAgencia = (int) info[2];
		double saldo = (double) info[3];
		String senha = (String) info[4];
		
		
		boolean sair = false;
		System.out.print("Usuario: ");
		String usr = teclado.next();
		System.out.print("Senha de acesso: ");
		String pswd = teclado.next();
		if (nome.contentEquals(usr)||senha.contentEquals(pswd)) {
			while (sair == false) {
				System.out.println("O quer fazer " + nome + "?");
				System.out.println("1 - ver dados da sua conta");
				System.out.println("2 - depositar quantia");
				System.out.println("3 - retirarquantia");
				System.out.println("4 - SAIR");
				System.out.println("******************************************************");
				int option = teclado.nextInt();
				switch (option) {
				case 1:
					System.out.println("Usuario da conta: " + nome);
					System.out.println("Numero do banco: " + Integer.toString(numBanco));
					System.out.println("Numero da agencia: " + Integer.toString(numAgencia));
					System.out.println("Saldo total na conta: " + Double.toString(saldo));
					System.out.println("******************************************************");
					break;
				case 2:
					System.out.print("Escreva a quantidade a ser adicionada: ");
					double add = teclado.nextDouble();
					saldo += add;
					System.out.println("A quantia foi adicionada com sucesso");
					System.out.println("******************************************************");
					break;
				case 3:
					System.out.print("Escreva a quantidade a ser retirada: ");
					double min = teclado.nextDouble();

					if (min > saldo) {
						System.out.println(
								"Nao eh possivel retirar essa quantidade, pois ela eh maior que o saldo na conta");
					} else {
						saldo -= min;
						System.out.println("Quantia retirada com sucesso");
					}
					System.out.println("******************************************************");
					break;
				case 4:
					teclado.close();
					bw.write((String) info[0]+ "," + (int) info[1] + "," + (int) info[2] + "," + (double) info[3] + "," + (String) info[4]);
					bw.close();
					arqReader.close();
					teclado.close();
					System.out.println("Saindo...");
					sair = true;
					break;
				}

			}
		} else {
			
			System.out.println("Senha incorreta, saindo");
			bw.close();
			arqReader.close();
			teclado.close();
		}

	}

}
