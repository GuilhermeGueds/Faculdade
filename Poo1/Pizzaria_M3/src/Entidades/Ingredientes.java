/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Arquivos.Repositorio.RepositorioIngredientes;

/**
 * Classe Ingredientes.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Ingredientes {
    
    /**
     * Nome dos Ingredientes.
     */
    private String ingrediente;

    /**
     * Construtor para classe Ingredientes.
     */
    public Ingredientes() {
        
    }
    
    /**
     * Construtor para classe Ingredientes.
     * @param ingrediente
     */
    public Ingredientes(String ingrediente) {
        this.ingrediente = ingrediente;
        salvar();
    }
 
    /**
     * @return nome do ingrediente.
     */
    public String getIngredientes() {
        return ingrediente;
    }

    /**
     * @param ingrediente 
     */
    public void setIngredientes(String ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    /**
     * Salvar os Ingredientes.
     */
    public  void salvar(){
        RepositorioIngredientes.salvar(this);
    }
}
