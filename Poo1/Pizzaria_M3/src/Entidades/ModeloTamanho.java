/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * Classe Modelo do Tamanho.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class ModeloTamanho {

    /**
     * Modelo da pizza.
     */
    private ModeloPizza modeloPizza;
    
    /**
     * Tamanho da pizza.
     */
    private Tamanho tamanho;

    /**
     * Construtor para classe Modelo Tamanho.
     * @param modeloPizza
     * @param tamanho 
     */
    public ModeloTamanho(ModeloPizza modeloPizza, Tamanho tamanho) {
        this.modeloPizza = modeloPizza;
        this.tamanho = tamanho;
    }

    /**
     * @return modelo da pizza.
     */
    public ModeloPizza getModeloPizza() {
        return modeloPizza;
    }

    /**
     * @param modeloPizza 
     */
    public void setModeloPizza(ModeloPizza modeloPizza) {
        this.modeloPizza = modeloPizza;
    }

    /**
     * @return tamanho da pizza.
     */
    public Tamanho getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho 
     */
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
}
