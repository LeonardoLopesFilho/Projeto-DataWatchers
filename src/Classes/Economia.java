/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import dao.EconomiaDao;
import dao.LoginDAO;

/**
 *
 * @author leo_z
 */
public class Economia extends Login {
    
    EconomiaDao eco = new EconomiaDao();
    LoginDAO logdao =  new LoginDAO();
    public float moedas = 0;
    public String user;
    public String User;
    
    
    
    
    public Economia(){
     user = logdao.Pegarusuariologado();
    }
    
    public Economia(float moedas) {
       this.moedas = moedas;
    }
    
    public void Ecologado(){
        eco.updatemoedas(logdao.PegarEco(user));
    }
     
    public float getMoedas() {
        return eco.PegarMoedasBanco();
    }

    public void setMoedas(float moedas) {
        this.moedas = moedas;
        eco.updatemoedas((int) this.getMoedas());
        
    }
    
    public void click(float moedasclick){
        eco.updatemoedas((int)(eco.PegarMoedasBanco() + moedasclick));
    }
    
    public void zerar(){
        eco.updatemoedas(0);
        
    }
    public void comprar(int valor){
        int moedasdobanco = eco.PegarMoedasBanco();
        eco.updatemoedas((int)(moedasdobanco - valor)); 
    }
    
    
    
    
}
