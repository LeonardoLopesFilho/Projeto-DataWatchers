package Chamadas;

import java.util.Scanner;

import Classes.Enigmas;
import Classes.Login;

public class Main {

	public static void main(String[] args) {
		Scanner teclado =  new Scanner(System.in);
		Login log = new Login();
		System.out.println("Digite o seu nome para cadastro");
		log.setNome(teclado.next());
		System.out.println("Digite a sua senha para cadastro");
		log.setSenha(teclado.next());
		
		String nome;
		String senha;
		
		System.out.println("Digite o seu Login");
		nome=teclado.next();
		System.out.println("Digite a sua senha");
		senha=teclado.next();
		
	
		if(log.validalogin(nome, senha) == true) {
			
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("1-Dados do Leonardo");
			System.out.println("2-Dados do ismael");
			System.out.println("3-Dados do marlon");
			System.out.println("4-Dados do felipe");
			System.out.println("5-Dados do gabriel");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			
			
			System.out.println("Digite o dado que vc quer");
			
			Enigmas enig =  new Enigmas(teclado.nextInt());
			
			enig.escolheEnig();
		    
			System.out.println("Digite a resposta do enigma");
		   
			enig.setRespostaUser(teclado.next());
		   
			enig.validaEnig();
			
			
		}else {
			System.out.println("Login incorreto");
			
		}
		

	}

}
