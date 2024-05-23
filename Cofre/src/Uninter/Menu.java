package Uninter;
import java.util.Scanner;

public class Menu {

		private Scanner sc;
		private Cofrinho cofrinho;
		
		public Menu() {
			sc = new Scanner(System.in);
			cofrinho = new Cofrinho();
		}
		
		public void exibirMenuPrincipal() {
			System.out.println("----------------------");
			System.out.println("      COFRINHO");
			System.out.println("----------------------");
			System.out.println("1 - Adicionar moedas");
			System.out.println("2 - Remover moedas");
			System.out.println("3 - Listar moedas");
			System.out.println("4 - Total convertido para real");
			System.out.println("0 - Encerrar");
			
			String opcaoSelecionada = sc.next();
			
			switch(opcaoSelecionada) {
			case "0":
				System.out.println("OPERAÇÃO ENCERRADA!");
				break;
				
			case "1":
				exibirSubMenuAdicionarMoedas();
				exibirMenuPrincipal();
				break;
				
			case "2":
				exibirSubMenuRemoverMoedas();
				exibirMenuPrincipal();
				break;
				
			case "3":
				cofrinho.listagemMoedas();
				exibirMenuPrincipal();
				break;
				
			case "4":
				double valorTotalConvertido = cofrinho.totalConvertido();
				String valorTotalConvertidoTextual = String.format("%.2f" , valorTotalConvertido);
				valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace("." , ",");
				System.out.println("O valor total convertido para real é: " + valorTotalConvertidoTextual);
				exibirMenuPrincipal();
				break;
				
			default: 
				System.out.println("Opção inválida!");
				exibirMenuPrincipal();
				break;
			}
		}
		
		private void exibirSubMenuAdicionarMoedas() {
			System.out.println("Escolha uma moeda:");
			System.out.println("1 - REAL");
			System.out.println("2 - DOLAR");
			System.out.println("3 - EURO");
			
			int opcaoMoeda = sc.nextInt();
			
			
			System.out.println("Digite o valor:");
			
			String valorTextualMoeda = sc.next();

			valorTextualMoeda = valorTextualMoeda.replace("," , ".");
			double valorMoeda = Double.parseDouble(valorTextualMoeda);
			
				
			Moeda moeda = null;
			
			if (opcaoMoeda == 1) {
				  moeda = new Real(valorMoeda);
			} 
				else if (opcaoMoeda == 2) {
				 moeda = new Dolar(valorMoeda);
			} 
				else if (opcaoMoeda == 3) {
				 moeda = new Euro (valorMoeda);
			}
				else {
				System.out.println("Escolha uma moeda válida");
				exibirMenuPrincipal();
			} 
			cofrinho.adicionar(moeda);  
			System.out.println("Moeda adicionada!");
		 	
		}
		
		public void totalConvertido() {
			
		}
		
		private void exibirSubMenuRemoverMoedas() {
			System.out.println("Escolha uma moeda:");
			System.out.println("1 - REAL");
			System.out.println("2 - DOLAR");
			System.out.println("3 - EURO");
			
			int opcaoMoeda = sc.nextInt();
			
			
			System.out.println("Digite o valor:");
			
			String valorTextualMoeda = sc.next();

			valorTextualMoeda = valorTextualMoeda.replace("," , ".");
			double valorMoeda = Double.parseDouble(valorTextualMoeda);
			
				
			Moeda moeda = null;
			
			if (opcaoMoeda == 1) {
				  moeda = new Real(valorMoeda);
			} 
				else if (opcaoMoeda == 2) {
				 moeda = new Dolar(valorMoeda);
			} 
				else if (opcaoMoeda == 3) {
				 moeda = new Euro (valorMoeda);
			}
				else {
				System.out.println("Escolha uma moeda válida");
				exibirMenuPrincipal();
			} 
			
			boolean removeuMoeda = cofrinho.remover(moeda);
			if (removeuMoeda) {
				System.out.println("Moeda removida com sucesso");
			} else {
				System.out.println("A moeda com esse valor não foi encontrada!");
			}
		 	
		}
		
}
