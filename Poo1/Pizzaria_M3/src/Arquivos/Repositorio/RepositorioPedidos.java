/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.Pedidos;
import java.util.ArrayList;

/**
 * Classe Repositório de Pedidos.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioPedidos {
    
    /**
     * Vetor de pedidos.
     */
    private static final ArrayList<Pedidos> pedidos = new ArrayList<>();
   
    /**
     * Vetor de pedidos cancelados.
     */
    private static final ArrayList<Pedidos> pedidosCancelados = new ArrayList<>();
  
    /**
     * @param posicao
     * @return pedidos em uma posição.
     */
    public static Pedidos getPedidos(int posicao) {
        return pedidos.get(posicao);
    }
    
    /**
     * Salvar pedidos.
     * @param pedido 
     */
    public static void save(Pedidos pedido) {
        RepositorioPedidos.pedidos.add(pedido);
    }
    
    /**
     * @return quantidade de pedidos.
     */
    public static int tamanho(){
        return pedidos.size();
    }
    
    /**
     * Remover pedidos.
     * @param posicao 
     */
    public static void remover(int posicao){
        RepositorioPedidos.pedidos.remove(posicao);
    }

    /**
     * @param posicao
     * @return pedidos cancelados em uma posição.
     */
    public static Pedidos getPedidosCancelados(int posicao) {
        return pedidosCancelados.get(posicao);
    }
    
    /**
     * Salvar os pedidos cancelados.
     * @param pedido 
     */
    public static void savePedidosCancelado(Pedidos pedido) {
        RepositorioPedidos.pedidosCancelados.add(pedido);
    }
    
    /**
     * @return quantidades de pedidos cancelados.
     */
    public static int tamanhoPedidosCancelados(){
        return pedidosCancelados.size();
    }
}
