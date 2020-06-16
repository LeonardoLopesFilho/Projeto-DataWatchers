/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import dao.EnigmaDAO;

/**
 *
 * @author leo_z
 */
public class Enigmas extends Economia {
    public int id_enigma;
    public String enigma;
    public int comprado;
    public String ajuda;
    public String resposta;
    EnigmaDAO enig = new EnigmaDAO();

    public String getEnigma() {
        return enigma;
    }

    public int getComprado() {
        return comprado;
    }

    public String getAjuda() {
        return ajuda;
    }

    public void setComprado(int comprado) {
        this.comprado = comprado;
    }
    
    public void zerarcomprado(){
        enig.update(0);
    }
    
    
    
    
    
}
