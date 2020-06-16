/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author leo_z
 */
public class EnigmaDAO {
    
    private final Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    public int moedasdobanco;
    
    
    public EnigmaDAO(){
        conn = new ConnectionFactory().getConecao();
    }
    
    public void inserir(int valor){
        String sql = "INSERT INTO Enigmas (comprado) VALUES("+valor+")";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro2" + erro);
        }
    
    }
    
    //Talvez o update nao use 
    public void updateunico(int valor,int id){
        String sql = "UPDATE Enigmas Set comprado = "+valor+" Where id_enigma = "+id;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
    
     public void update(int valor){
        String sql = "UPDATE Enigmas Set comprado = "+valor;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
     
      public void Excluir(int Valor){
        String sql = "Delete from Economia where moedas ="+Valor;
        try{
            st=conn.createStatement();
            st.execute(sql);
            st.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro4" + erro);
        }
    
    }
      
      public int CheckComprado(){
          String sql = "Select comprado from Enigmas";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if(rs != null && rs.next()){
                return (rs.getInt("comprado"));
            }
            return (rs.getInt("comprado"));
        }catch(SQLException erro){
            throw new RuntimeException("Erro5" + erro);
        }
      
      }
      
      public String CheckResposta(int id){
          String sql = "Select resposta from Enigmas where id_enigma = "+id;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs != null && rs.next()){
              String resposta = rs.getString("resposta");
              return resposta;
            }
        }catch(SQLException erro){
            throw new RuntimeException("Erro5 " + erro);
        }
        return null;
      
      }
      public String PegarEnigma(int id){
          String sql = "Select enigma from Enigmas where id_enigma ="+id;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs != null && rs.next()){
              String resposta = rs.getString("enigma");
              return resposta;
            }
        }catch(SQLException erro){
            throw new RuntimeException("Erro5 " + erro);
        }
        return null;
      
      }
      
      
      public void zerarcomprado(){
        this.update(0);
    }
}
