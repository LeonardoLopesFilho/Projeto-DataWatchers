package dao;

/*import Classes.Economia;*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
public class EconomiaDao {

    private final Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    public int moedasdobanco;
    
    
    public EconomiaDao(){
        conn = new ConnectionFactory().getConecao();
    }
    
    public void inserir(int valor){
        String sql = "INSERT INTO Economia (moedas) VALUES("+valor+")";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.execute(sql);
            stmt.close();
            
        }catch(SQLException erro){
            throw new RuntimeException("Erro2" + erro);
        }
    
    }
    
     public void updatemoedas(int valor){
        String sql = "UPDATE Economia Set moedas = "+valor;
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
      
      public int PegarMoedasBanco(){
          String sql = "Select * from Economia";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql); 
            if(rs != null && rs.next()){
                return (rs.getInt("moedas"));
            }
            return (rs.getInt("moedas"));
        }catch(SQLException erro){
            throw new RuntimeException("Erro5" + erro);
        }
      
      }
    
}
