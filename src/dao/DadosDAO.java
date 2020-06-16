/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Classes.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DadosDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    
    private ArrayList<Dados> selecao = new ArrayList<>();
    
    public DadosDAO(){
        conn = new ConnectionFactory().getConecao();
    }
    
    public void updateDados(int valor,String nome){
        String sql = "UPDATE Dados Set Comprado = "+ valor +" where NomePessoa ="+nome;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
    
    public int PegarDadosBanco(String nome){
          String sql = "Select Comprado from Dados where NomePessoa ="+nome;
        try{
            st=conn.createStatement();
            rs = st.executeQuery(sql); 
            st.close();
            return (rs.getInt("Comprado"));
            
        }catch(Exception erro){
            throw new RuntimeException("Erro5" + erro);
        }
      
      }
    
   public void updatecompletos(int valor){
        String sql = "UPDATE ajuda Set completos = "+ valor;
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro3" + erro);
        }
    
    }
   
   public int Pegarcompletos(){
          String sql = "Select completos from ajuda";
        try{
            st=conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs != null && rs.next()){
              int resposta = rs.getInt("completos");
              return resposta;
            }
            return (rs.getInt("completos"));
            
        }catch(Exception erro){
            throw new RuntimeException("Erro5" + erro);
        }
      
      }
      
   public void zerarcompletos(){
        this.updatecompletos(0);
    }
}
