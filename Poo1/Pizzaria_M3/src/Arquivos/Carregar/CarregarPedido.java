/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Carregar;

import Entidades.ItemPedido;
import Entidades.Pedidos;
import Entidades.MontarPizza;
import Arquivos.Repositorio.RepositorioClientes;
import Arquivos.Repositorio.RepositorioPedidos;
import Arquivos.Repositorio.RepositorioPizzaMontada;

/**
 * Classe Carregar o Pedido.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class CarregarPedido extends CarregarArquivos {

    /**
     * Fazer o controle de cada linha.
     */
    private int controle = 0;

    /**
     * Quantidade de clientes.
     */
    private int quantidadeClientes = 0;

    /**
     * Nome da pizza.
     */
    private String nomePizza;
    
    /**
     * Descrição do tamanho da pizza.
     */
    private String descricaoTamanho;

    /**
     * Carregar o template com o pedido.
     */
    public void carregarTemplate() {
        carregarPedido();
    }

    /**
     * Carregar o pedido do cliente.
     */
    public void carregarPedido() {
        this.quantidadeClientes = Integer.parseInt(this.getConteudo(controle));
        controle++;
        for (int i = 0; i < quantidadeClientes; i++) {
            Pedidos pedido = new Pedidos();
            pedido.setCliente(RepositorioClientes.buscarPorNome(this.getConteudo(controle)));
            controle++;
            comprarPizzas(pedido);
            controle++;
            pedido.setConfirmar(this.getConteudo(controle));
            controle++;
        }
        this.removerPizzasNaoVendidas();
        this.contadorDePizzasVendidas();
    }

    /**
     * Comprar as pizzas.
     * @param pedido 
     */
    private void comprarPizzas(Pedidos pedido) {
        int qtdeItens = Integer.parseInt(getConteudo(controle));
        for (int i = 0; i < qtdeItens; i++) {
            ItemPedido item = new ItemPedido();
            controle++;
            nomePizza = getConteudo(controle);
            controle++;
            descricaoTamanho = getConteudo(controle);
            MontarPizza pizza = RepositorioPizzaMontada.buscarPorNome(nomePizza, descricaoTamanho);
            item.setItens(pizza);
            pedido.setItemPedido(item);
        }
    }

    /**
     * Remover as pizzas que não foram vendidas.
     */
    private void removerPizzasNaoVendidas() {
        for (int i = 0; i < RepositorioPedidos.tamanho(); i++) {
            if (!RepositorioPedidos.getPedidos(i).isConfirmar()) {
                RepositorioPedidos.savePedidosCancelado(RepositorioPedidos.getPedidos(i));
                RepositorioPedidos.remover(i);
            }
        }
    }

    /**
     * Contador de quantas pizzas foram vendidas.
     */
    private void contadorDePizzasVendidas() {
        for (int i = 0; i < RepositorioPedidos.tamanho(); i++) {
            if (RepositorioPedidos.getPedidos(i).isConfirmar()) {
                for (int j = 0; j < RepositorioPedidos.getPedidos(i).quantidadeItens(); j++) {
                    RepositorioPedidos.getPedidos(i).getItemPedido(j).getItens().pizzaVendida();
                }
            }
        }
    }
}
