/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Entidades.Pizzaria;
import Arquivos.Relatorios.RelatorioPedidosConfirmados;
import Arquivos.Relatorios.RelatorioMenu;
import Arquivos.Relatorios.RelatorioPedidosCancelados;
import Arquivos.Relatorios.RelatorioPizzasNaoVendidas;
import Arquivos.Relatorios.RelatorioPizzasVendidas;
import Arquivos.Carregar.CarregarPizzaria;
import Arquivos.Carregar.CarregarMenu;
import Arquivos.Carregar.CarregarClientes;
import Arquivos.Carregar.CarregarPedido;

/**
 * Classe Sistema da Pizzaria.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class SistemaPizzaria {
    
    /**
     * Informações da pizzaria.
     */
    private Pizzaria pizzaria;
 
    /**
     * Carregar arquivos.
     */
    public void carregarArquivos(){
        CarregarMenu menu = new CarregarMenu();
        CarregarClientes clientes = new CarregarClientes();
        CarregarPizzaria pizzaria = new CarregarPizzaria();
        CarregarPedido pedidos = new CarregarPedido();
        menu.carregarArquivo("menu.txt");
        clientes.carregarArquivo("clientes.txt");
        pizzaria.carregarArquivo("pizzaria.txt");
        this.pizzaria = pizzaria.getPizzaria();
        pedidos.carregarArquivo("pedidoPizza.txt");   
    }

    /**
     * Gerar Relatorios.
     */
    private void gerarRelatorios(){
        RelatorioMenu relatorioMenu = new RelatorioMenu();
        RelatorioPizzasVendidas relatorioPizzasVendidas = new RelatorioPizzasVendidas();
        RelatorioPizzasNaoVendidas relatorioPizzasNaoVendidas = new RelatorioPizzasNaoVendidas();
        RelatorioPedidosConfirmados relatorioPedidosConfirmado = new RelatorioPedidosConfirmados();
        RelatorioPedidosCancelados relatorioPedidosCancelado = new RelatorioPedidosCancelados();
       
        relatorioMenu.salvar("relatorioMenu.txt");
        relatorioPizzasVendidas.salvar("relatorioPizzasVendidas.txt");
        relatorioPizzasNaoVendidas.salvar("relatorioPizzasNaoVendidas.txt");
        relatorioPedidosConfirmado.salvar("relatorioPedidosConfirmados.txt");
        relatorioPedidosCancelado.salvar("relatorioPedidosCancelados.txt");
         
        System.out.println("\n#################################################"
                + "########################################################\n");
        System.out.println("                        Pizzaria:" + pizzaria.getNome());
        System.out.println(relatorioMenu.toString());
        System.out.println("\n#################################################"
                + "########################################################\n");
        System.out.println(relatorioPedidosConfirmado.toString());
        System.out.println("\n#################################################"
                + "########################################################\n");
        System.out.println(relatorioPedidosCancelado.toString());
        System.out.println("\n#################################################"
                + "########################################################\n");
        System.out.println(relatorioPizzasVendidas.toString());
        System.out.println("\n#################################################"
                + "########################################################\n");
        System.out.println(relatorioPizzasNaoVendidas.toString());     
        System.out.println("\n#################################################"
                + "########################################################\n");
    }

    /**
     * Carregar arquivos.
     * Gerar relatorios.
     */
    public void run(){
        this.carregarArquivos();
        this.gerarRelatorios();
    }
}