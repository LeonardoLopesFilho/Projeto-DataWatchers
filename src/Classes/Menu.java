/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author leo_z
 */
public class Menu {
    public Integer escolha;
    public Integer escolhadado;
    public String resposta;
    
    EcoComando eco = new EcoComando();
    public void mostrar(){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Digite a opção desejada");
        System.out.println("1-Para colocar BitCoins");
        System.out.println("2-Para Comprar Os Dados");
        System.out.println("3-Para Ver os dados Comprados");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
        this.direcionar();
    }
    
    public void direcionar(){
        Scanner teclado = new Scanner(System.in);
        escolha = teclado.nextInt();
        
        if(escolha == 1){
            System.out.println("Digite a quantidade de BitCoins desejada");
            eco.setMoedas(teclado.nextFloat());
            System.out.println("Dinheiro colocado com sucesso");
            this.mostrar();
            
        }else if(escolha == 2){
            System.out.println("=-=-=-=-=-=-=-=-=");
            System.out.println("1-Dados do ismael");
            System.out.println("40 bitcoins");
            System.out.println("=-=-=-=-=-=-=-=-=");
            System.out.println("2-Dados do leonardo");
            System.out.println("150 bitcoins");
            System.out.println("=-=-=-=-=-=-=-=-=");
            System.out.println("3-Dados do joao");
            System.out.println("9000 bitcoins");
            System.out.println("=-=-=-=-=-=-=-=-=");
            System.out.println("escolha uma opção");
            escolhadado = teclado.nextInt();
            this.enigmas();
        }
    }
    
    public void enigmas(){
        Scanner teclado = new Scanner(System.in);
        if (this.escolhadado == 1 && (eco.getMoedas() == 40)){
                System.out.println("Descubra o enigma");
                System.out.println("B dhr zngnzbf gbqbf bf qvnf znf aãb fbzbf cerfbf?");
                resposta = teclado.next();
                    if(resposta.equals("fome")){
                        System.out.println("Dados do ismael comprado!!");
                        this.mostrar();
                    }
            this.mostrar();
            }
            else if(this.escolhadado == 2 && (eco.getMoedas() == 150)){
                System.out.println("Descubra o enigma");
                System.out.println("vqnqr qr grfyn nb snyrpre");
                resposta = teclado.next();
                    if(resposta.equals("86")){
                        System.out.println("Dados do leonardo comprado!!");
                        this.mostrar();
                    }
            this.mostrar();
            }
            else if(this.escolhadado == 3 && (eco.getMoedas() == 9000)){
                System.out.println("Descubra o enigma");
                System.out.println("N ivqn ...... Wbnb 3:16");
                resposta = teclado.next();
                    if(resposta.equals("eterna")){
                        System.out.println("Dados do joao comprado!!");
                        this.mostrar();
                    }
            this.mostrar();
            }   
    }
}
