/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.Tamanho;
import java.util.ArrayList;

/**
 * Classe Repositório de Tamanho.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioTamanho {
    
    /**
     * Vetor de tamanho.
     */
    private static final ArrayList<Tamanho> tamanhos = new ArrayList<>();
   
    /**
     * Salvar o tamanho.
     * @param tamanho 
     */
    public static void salvar(Tamanho tamanho){
        if(!tamanhos.contains(tamanho.getDescricao()) && !tamanhos.contains(tamanho.getQuantidadeDeFatias())){
            RepositorioTamanho.tamanhos.add(tamanho);
        }
    }
    
    /**
     * Mostrar os tamanhos disponiveis.
     */
    public static void TamanhosDisponiveis(){
        for (int i=0; i<tamanhos.size(); i++){
            System.out.println(tamanhos.get(i).getDescricao());
        }
    } 

    /**
     * @param posicao
     * @return tamanho em uma posição. 
     */
    public static Tamanho getTamanhos(int posicao) {
        return tamanhos.get(posicao);
    }
     
    /**
     * @param descricao
     * @return buscar tamanho pelo nome.
     */
    public static Tamanho buscarPorNome(String descricao){
        Tamanho aux = new Tamanho();  
        for(int i=0; i<tamanhos.size(); i++){
            if(descricao.equals(tamanhos.get(i).getDescricao()))  
                aux = tamanhos.get(i);
        }
        return aux;
    }
     
    /**
     * @return quantidade de tamanhos.
     */
    public static int quantidadeTamanhos(){
        return tamanhos.size();
    }
     
    /**
     * @return tamanhos.
     */
    public static ArrayList<Tamanho> retornaArray(){
        return tamanhos;
    }
}
    
    
  


    
   
        
    

