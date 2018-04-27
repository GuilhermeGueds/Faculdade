/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.Preco;
import java.util.ArrayList;

/**
 * Classe Repositório de Preço.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioPreco {
    
    /**
     * Vetor de preços.
     */
    private static final ArrayList<Preco> precos = new ArrayList<>();

    /**
     * @param posicao
     * @return preço em uma posição.
     */
    public static Preco getPrecos(int posicao) {
        return precos.get(posicao);
    }
    
    /**
     * @return preço.
     */
    public static ArrayList<Preco> retornaArray(){
        return precos;
    }
    
    /**
     * Salvar preços.
     * @param preco 
     */
    public static void salvar(Preco preco){
        RepositorioPreco.precos.add(preco);
    }
    
    /**
     * Mostrar preços disponiveis.
     */
    public static void PrecosDisponiveis(){    
        for (int i=0; i<precos.size(); i++){
            System.out.println(precos.get(i).getPreco());
        }
    } 
    
    /**
     * @param valor
     * @return buscar pelo valor.
     */
    public static Preco buscarPorValor(String valor){
        Preco aux = new Preco();
        for(int i=0; i<precos.size(); i++){
            if(valor.equals(precos.get(i).getPreco()))  
                aux = precos.get(i);
        }
        return aux;
    }
     
    /**
     * @return quantidade de preços. 
     */
    public static int quantidadePreco(){
        return precos.size();
    }
}
    

