/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import Sistema.AppConfig;
import Arquivos.Repositorio.RepositorioModeloPizza;

/**
 * Classe Modelo da Pizza.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class ModeloPizza {
   
    /**
     * Próximo id.
     */
    private static int nextId = 1;
    
    /**
     * Id da pizza.
     */
    private final int id;
    
    /**
     * Nome da pizza.
     */
    private  String nome;
    
    /**
     * Vetor de ingredientes.
     */
    private ArrayList<Ingredientes> ingredientes= new ArrayList<>();

    /**
     * Construtor para classe Modelo Pizza.
     */
    public ModeloPizza() {
        this.id = nextId++;   
        this.salvar();
    }
    
    /**
     * @return id da pizza.
     */
    public int getId() {
        return id;
    }

    /**
     * @return nome da pizza.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param ingrediente 
     */
    public void setIngredientes(Ingredientes ingrediente){
       this.ingredientes.add(ingrediente);
    }
    
    /**
     * @param contador
     * @return os ingredientes na posicao.
     */
    public Ingredientes getIngredientes(int contador){
        return this.ingredientes.get(contador);
    }
    
    /**
     * @return quantidade de ingredientes.
     */
    public int quantidadeDeIngredientes(){
        return this.ingredientes.size();
    }

    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getName() + "{" + AppConfig.NEW_LINE);
        output.append("  Pizza" + AppConfig.NEW_LINE);
        output.append("     Id = "+ id + AppConfig.NEW_LINE);
        output.append("     Nome = "+ nome + AppConfig.NEW_LINE);
        output.append("     Igredientes = ");
        for(int i = 0; i < this.quantidadeDeIngredientes(); i++){
            output.append(ingredientes.get(i));
        }
        output.append(AppConfig.NEW_LINE);
        output.append("}" + AppConfig.NEW_LINE);
        return output.toString();
    }
    
    /**
     * Salvar o Modelo da Pizza
     */
    private  void salvar(){
        RepositorioModeloPizza.salvar(this);
    }
}
