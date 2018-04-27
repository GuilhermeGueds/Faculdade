/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.ModeloPizza;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Classe Repositório de Modelo Pizza.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioModeloPizza {
    
    /**
     * Vetor de pizzas.
     */
    private static final ArrayList<ModeloPizza> pizzas = new ArrayList<>();
   
    /**
     * Tamanhos disponiveis.
     */
    public static void TamanhosDisponiveis(){ 
        for (int i=0; i<pizzas.size(); i++){
            System.out.println(pizzas.get(i));
        }
    } 
    
    /**
     * Buscar pizza pelo nome.
     * @param nome
     * @return 
     */
    public static ModeloPizza buscarPorNome(String nome){
        ModeloPizza aux = new ModeloPizza();
        for(int i=0; i<pizzas.size(); i++){
          if(nome.equals(pizzas.get(i).getNome()))  
              aux = pizzas.get(i);
        }
        return aux;
    }
     
    /**
     * Salvar Pizza.
     * @param pizza 
     */
    public static void salvar(ModeloPizza pizza){
        RepositorioModeloPizza.pizzas.add(pizza);
    }
     
    /**
     * @return quantidade de pizzas.
     */
    public static int quantidadeModeloPizza(){
        return pizzas.size();
    }
     
    /**
     * @param posicao
     * @return buscar pizza pela posição.
     */
    public static ModeloPizza buscarPorPosicao(int posicao){
        return pizzas.get(posicao);
    }
      
    /**
     * @return pizzas.
     */
    public static ArrayList<ModeloPizza> retornaArray(){
        return pizzas;
    }
}
