/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import dao.DadosDAO;

/**
 *
 * @author leo_z
 */
public class Dados extends Enigmas {
    public String NomePessoa;
    public Integer Valor;
    public Integer comprado;
    public String DadosPessoa;
    public String Site;
    DadosDAO dados = new DadosDAO();

    public String getNomePessoa() {
        return NomePessoa;
    }

    public void setNomePessoa(String NomePessoa) {
        this.NomePessoa = NomePessoa;
    }

    public Integer getValor() {
        return Valor;       
    }

    public void setValor(Integer Valor) {
        this.Valor = Valor;
    }
    public void setComprado( int comprado, String nome) {
        dados.updateDados(comprado, nome);
    }

    public int getCompradoPessoa(String nome) {
        return dados.PegarDadosBanco(nome);
        
    }

    public void setDadosPessoa(String DadosPessoa) {
        this.DadosPessoa = DadosPessoa;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String Site) {
        this.Site = Site;
    }
    
}
