/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * Classe Item do Pedido.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class ItemPedido {
    
    /**
     * Itens para Montar a pizza.
     */
    private  MontarPizza itens; 
 
    /**
     * @return itens da pizza
     */
    public MontarPizza getItens() {
        return itens;
    }

    /**
     * @param itens 
     */
    public void setItens(MontarPizza itens) {
        this.itens = itens;
    }
}

    
    

