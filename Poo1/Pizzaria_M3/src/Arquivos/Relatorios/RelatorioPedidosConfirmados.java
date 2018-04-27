/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Relatorios;

import Arquivos.Repositorio.RepositorioPedidos;
import Sistema.AppConfig;

/**
 * Classe Relatório de Pedidos Confirmados.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RelatorioPedidosConfirmados extends Relatorios {

    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String relatorio() {
        return toString();
    }

    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(AppConfig.NEW_LINE);
        output.append("                       Relatorio De Pedidos Confirmados " + AppConfig.NEW_LINE);
        output.append("                       -------------------------------- " + AppConfig.NEW_LINE);
        for (int i = 0; i < RepositorioPedidos.tamanho(); i++) {
            output.append("    Numero Pedido: " + RepositorioPedidos.getPedidos(i).getCodigo() + AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("    Cliente: " + RepositorioPedidos.getPedidos(i).getCliente().getNome() + AppConfig.NEW_LINE);
            output.append("    Telefone: " + RepositorioPedidos.getPedidos(i).getCliente().getTelefone() + AppConfig.NEW_LINE);
            output.append("    CPF: " + RepositorioPedidos.getPedidos(i).getCliente().getCpf() + AppConfig.NEW_LINE);
            output.append("    Endereco: " + RepositorioPedidos.getPedidos(i).getCliente().getEndereco() + AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("    Quantidade de itens: " + RepositorioPedidos.getPedidos(i).quantidadeItens() + AppConfig.NEW_LINE);
            for (int j = 0; j < RepositorioPedidos.getPedidos(i).quantidadeItens(); j++) {
                output.append(AppConfig.NEW_LINE);
                output.append("    Pizza: " + RepositorioPedidos.getPedidos(i).getItemPedido(j).getItens().getPizza().getNome() + AppConfig.NEW_LINE);
                output.append("    Ingredientes: (");
                for (int k = 0; k < RepositorioPedidos.getPedidos(i).getItemPedido(j).getItens().getPizza().quantidadeDeIngredientes(); k++) {
                    output.append(RepositorioPedidos.getPedidos(i).getItemPedido(j).getItens().getPizza().getIngredientes(k).getIngredientes());
                    output.append(", ");
                }
                output.append(")");
                output.append(AppConfig.NEW_LINE);
                output.append("    Tamanho " + RepositorioPedidos.getPedidos(i).getItemPedido(j).getItens().getTamanho().get(j).getDescricao());
                output.append(AppConfig.NEW_LINE);
                output.append("    Valor: " + RepositorioPedidos.getPedidos(i).getItemPedido(j).getItens().getPreco(j));
                output.append(AppConfig.NEW_LINE);
            }
            output.append(AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("    Status do Pedido: " + RepositorioPedidos.getPedidos(i).getStatus() + AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("    Total: " + RepositorioPedidos.getPedidos(i).totalPedido());
            output.append(AppConfig.NEW_LINE);
            output.append(AppConfig.NEW_LINE);
            output.append("----------------------------------------------------"
                    + "-----------------------------------------------------" + AppConfig.NEW_LINE);
        }
        return output.toString();
    }
}
