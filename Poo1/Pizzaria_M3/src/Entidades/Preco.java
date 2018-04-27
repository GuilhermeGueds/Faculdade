/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import Arquivos.Repositorio.RepositorioPreco;

/**
 * Classe Preço.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Preco {
    
    /**
     * Preço da pizza.
     */
    private BigDecimal preco;

    /**
     * Construtor para classe Preço.
     */
    public Preco() {
        this.salvar();
    }

    /**
     * Construtor para classe Preço.
     * @param preco 
     */
    public Preco(String preco) {
        this.preco = new BigDecimal(preco);
        this.salvar();
    }

    /**
     * @return preço.
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * @param preco 
     */
    public void setPreco(String preco) {
        this.preco = new BigDecimal(preco);
    }
    
    /**
     * Salvar o preço.
     */
    public  void salvar(){
        RepositorioPreco.salvar(this);  
    } 
}
