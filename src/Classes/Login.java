/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Telas.TelaInicio;
import dao.LoginDAO;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author leo_z
 */
public class Login{
    protected String usuario;
    protected String senha;
    protected String valida;
    protected int logado;
    protected char senha22[];
    protected int economia;
    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getLogado() {
        return logado;
    }

    public void setLogado(int logado) {
        this.logado = logado;
    }

    public int getEconomia() {
        return economia;
    }

    public void setEconomia(int economia) {
        this.economia = economia;
    }

    public char[] getSenha22() {
        return senha22;
    }

    public void setSenha22(char[] senha22) {
        this.senha22 = senha22;
    }
    

    public void trasformarsenha(){
        this.setSenha(Arrays.toString(senha22));
    
    }
    
    
    LoginDAO banco = new LoginDAO();

    public String getUserName() {
        return this.usuario;
    }
    
    public String pegarlogado(){
        System.out.println(this.getNome());
        this.setUserName(banco.Pegarusuariologado());
        return banco.Pegarusuariologado();
    }
    public void setUserName(String UserName) {
        System.out.println(UserName);
        this.usuario = UserName;
    }

    public String getSenha() {
        return senha;
    }
    public void atualizareco(){
        System.out.println(this.getEconomia());
        System.out.println(banco.Pegarusuariologado());
        banco.updateeco(this.getEconomia(),banco.Pegarusuariologado());
    }

    public void setSenha(String Senha) {
        this.senha = Criptografar.encriptografar(Senha);
    }
    
   public void inserirnobanco(){
       banco.inserirlogin(this.usuario,this.senha);
       banco.updatetiralogados(0);
   }
    public Login(){
        
    }
    
    public String validalogin(){
        banco.PegarSenha(this.getUserName());
        banco.Pegarusuario(this.getUserName());
        
        if(banco.Pegarusuario(this.getUserName()).equals(this.getUserName())){
            banco.updatetiralogados(0);
          if(banco.PegarSenha(this.getUserName()).equals(this.getSenha())){
              banco.updatelogado(1, this.getUserName());
              TelaInicio novojogo = new TelaInicio();
              novojogo.setVisible(true);
              novojogo.setResizable(false);
            }else{
              System.out.println(banco.PegarSenha(this.getUserName()));
              System.out.println(this.getSenha());
              JOptionPane.showMessageDialog(null,"Senha Incorreta");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Username incorreto");
        }
        return null;
    }
    
    //login.setUserName("leonardo");
     //   login.setSenha("96014579leonardolopes");
       // login.setSenha(Criptografar.encriptografar(login.getSenha()));
        
       // login.inserirnobanco();
    
      

    
    
    
    
    
}
