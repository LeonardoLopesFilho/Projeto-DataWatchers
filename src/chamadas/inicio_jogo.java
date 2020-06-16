/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamadas;

import Classes.Criptografar;
import Classes.Login;
import Classes.Menu;
import java.util.Scanner;


/**
 *
 * @author leo_z
 */
public class inicio_jogo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //System.out.println("Digite o login para entrar");
        //Scanner teclado = new Scanner(System.in);
        //Login login = new Login();
        //login.setUserName(teclado.next());
        //System.out.println("Agora digite sua senha");
        //login.setSenha(teclado.next());
        Menu men = new Menu();
        men.mostrar();
        //login.setSenha(Criptografar.encriptografar(login.getSenha()));
        //if(Criptografar.encriptografar(login.getSenha()).equals(login.comparasenha())){
         //Menu men = new Menu();
       // }else{
        //    System.out.println("Senha errada");
        //}
        //login.inserirnobanco();
    }
}
