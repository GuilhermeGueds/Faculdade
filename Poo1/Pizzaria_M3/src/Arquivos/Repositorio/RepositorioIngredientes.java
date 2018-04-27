/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.Ingredientes;
import java.util.ArrayList;

/**
 * Classe Repositório de Ingredientes.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioIngredientes {
    
    /**
     * Vetor de ingredientes.
     */
    private static final ArrayList<Ingredientes> ingredientes = new ArrayList<>();
    
    /**
     * Salvar ingredientes.
     * @param ingrediente 
     */
    public static void salvar(Ingredientes ingrediente){
        RepositorioIngredientes.ingredientes.add(ingrediente);
    }
    
    /**
     * Ingredientes disponiveis.
     */
    public static void IngredientesDisponiveis(){
        for (int i=0; i<ingredientes.size(); i++){
            System.out.println(ingredientes.get(i).getIngredientes());
        }
    }
    
    /**
     * Buscar ingredientes pelo nome.
     * @param ingrediente
     * @return
     */
    public static Ingredientes buscarPorNome(String ingrediente){
        Ingredientes aux = new Ingredientes();
        for(int i=0; i<ingredientes.size(); i++){
          if(ingrediente.equals(ingredientes.get(i).getIngredientes()))  
              aux = ingredientes.get(i);
        }
        return aux;
    }
    
    /**
     * @return quantidade de ingredientes.
     */
    public static int quantidadeIngredientes(){
         return ingredientes.size();
     }
}

 