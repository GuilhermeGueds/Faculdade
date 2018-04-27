/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import Arquivos.Repositorio.RepositorioPedidos;

/**
 * Classe Pedidos.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Pedidos {
   
    /**
     * Próximo código.
     */
    private static int ProximoCodigo = 1;
   
    /**
     * Código do pedido.
     */
    private int codigo ;
   
    /**
     * Informações do cliente.
     */
    private Cliente cliente;
    
    /**
     * Vetor de Item Pedido.
     */
    private ArrayList<ItemPedido> itemPedido = new ArrayList<>();
   
    /**
     * Confirmação do pedido.
     */
    private  boolean confirmar;
   
    /**
     * Construtor para classe Pedidos.
     */
    public Pedidos() {
       codigo = ProximoCodigo;
       ProximoCodigo++;
       this.save();
    }

    /**
     * @param posicao
     * @return item pedido na posição.
     */
    public ItemPedido getItemPedido(int posicao) {
        return itemPedido.get(posicao);
    }
    
    /**
     * @return o tamanho do item pedido.
     */
    public int quantidadeItens(){
        return this.itemPedido.size();
    }
    
    /**
     * @param pedido 
     */
    public void setItemPedido(ItemPedido pedido) {
        this.itemPedido.add(pedido) ;
    }
    
    /**
     * @return o codigo do pedido.
     */
    public int getCodigo(){
        return codigo;
    }
    
    /**
     * @param cliente 
     */
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    /**
     * @return a informação do cliente.
     */
    public Cliente getCliente(){
        return this.cliente;
    }
    
    /**
     * @return a confirmação do pedido.
     */
    public boolean isConfirmar() {
        return this.confirmar;
    }

    /**
     * @param confirmar 
     */
    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar.equals("confirmado");
    }
    
    /**
     * Salvar o pedido.
     */
    private void save(){
        RepositorioPedidos.save(this);
    }
    
    /**
     * @return total do pedido.
     */
    public BigDecimal totalPedido(){
        BigDecimal valor = new BigDecimal(0);
        for(int i=0; i< this.itemPedido.size();i++){
            valor = valor.add(itemPedido.get(i).getItens().getPreco(i));
        }
        return valor;
    }

    /**
     * @return o status do pedido.
     */
    public String getStatus() {
        String status;
        if(this.confirmar){
            status = "Confirmado";
        }else{
            status = "Cancelado";
        }
        return status;
    }
}
