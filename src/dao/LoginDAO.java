/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Classes.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author leo_z
 */
public class LoginDAO {
    private final Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;

    public LoginDAO() {
        conn = new ConnectionFactory().getConecao();
    }
    
    public void inserirlogin(String username,String senha ){
        String sql = "INSERT INTO Login (usuario,senha) values (?,?)";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,senha);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro2 " + erro);
        }
    
    }
    
    public void updatelogado(int logado,String usuario){
        String sql = "UPDATE Login Set logado = "+logado+" where usuario = '"+usuario+"'";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
    
    public void updateeco(int valor,String usuario){
        String sql = "UPDATE Login Set economia = "+valor+" where usuario = '"+usuario+"'";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
    
    public void updatetiralogados(int logado){
        String sql = "UPDATE Login Set logado = "+logado+" where usuario != 'usuario'";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
    
    
    public String Pegarusuario(String usuario){
          String sql = "Select usuario from Login where usuario ='"+usuario+"'";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if(rs != null && rs.next()){
                return (rs.getString("usuario"));
            }
            return (rs.getString("usuario"));
        }catch(SQLException erro){
            throw new RuntimeException("falha no usuario:" + erro);
        }
      
    }
    
    public String PegarSenha(String usuario){
          String sql = "Select senha from Login where usuario ='"+usuario+"'";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if(rs != null && rs.next()){
                return (rs.getString("senha"));
            }
            return (rs.getString("senha"));
        }catch(SQLException erro){
            throw new RuntimeException("Erro5" + erro);
            
        }
      
    }
    
    public String Pegarusuariologado(){
          String sql = "Select usuario from Login where logado = 1";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if(rs != null && rs.next()){
                return (rs.getString("usuario"));
            }
            return (rs.getString("usuario"));
        }catch(SQLException erro){
            throw new RuntimeException("falha no usuario:" + erro);
        }
      
    }
    
    public int PegarEco(String usuario){
          String sql = "Select economia from Login where usuario ='"+usuario+"'";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if(rs != null && rs.next()){
                return (rs.getInt("economia"));
            }
            return (rs.getInt("economia"));
        }catch(SQLException erro){
            throw new RuntimeException("falha no usuario:" + erro);
        }
      
    }
    
    
    
}
