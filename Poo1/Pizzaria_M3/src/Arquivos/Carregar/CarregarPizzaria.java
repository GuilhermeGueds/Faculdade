/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Carregar;

import Entidades.Pizzaria;

/**
 * Classe Carregar a Pizzaria.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class CarregarPizzaria extends CarregarArquivos {
        
    /**
     * Informações da pizzaria.
     */
    private Pizzaria pizzaria;
    
    /**
     * Carregar a pizzaria.
     */
    @Override
    public void carregarTemplate() {
       pizzaria = new Pizzaria(this.getConteudo(0), this.getConteudo(1), Integer.parseInt(this.getConteudo(2)), Long.parseLong(this.getConteudo(3)));
    }
    
    /**
     * Retornar a pizzaria.
     * @return 
     */
    public Pizzaria getPizzaria(){
        return this.pizzaria;
    }

}
