/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.Cliente;
import java.util.ArrayList;

/**
 * Classe Repositório de Clientes.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioClientes {
    
    /**
     * Vetor de clientes.
     */
    private static final ArrayList<Cliente> clientes = new ArrayList<>();
   
    /**
     * Salvar os clientes.
     * @param cliente 
     */
    public static void salvar(Cliente cliente){
        RepositorioClientes.clientes.add(cliente);
    }
    
    /**
     * Mostrar todos os clientes.
     */
    public static void TodosClientes(){
        for (int i=0; i<clientes.size(); i++){
            System.out.println(clientes.get(i).getNome());
        }
    } 
     
    /**
     * Buscar cliente pelo nome.
     * @param nome
     * @return
     */
    public static Cliente buscarPorNome(String nome){
        Cliente aux = new Cliente();
        for(int i=0; i<clientes.size(); i++){
            if(nome.equals(clientes.get(i).getNome()))  
                aux = clientes.get(i);
        }
        return aux;
    }
    
    /**
     * @return quantidade de clientes.
     */
    public static int quantidadeClientes(){
        return clientes.size();
    }
}
