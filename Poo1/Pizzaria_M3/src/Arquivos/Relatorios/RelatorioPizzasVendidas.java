/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Relatorios;

import Arquivos.Repositorio.RepositorioPizzaMontada;
import Sistema.AppConfig;

/**
 * Classe Relatório de Pizzas Vendidas.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RelatorioPizzasVendidas extends Relatorios {

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
        output.append("                       Relatorio Pizzas Vendidas" + AppConfig.NEW_LINE);
        for (int i = 0; i < RepositorioPizzaMontada.quantidadePizzasMontadas(); i++) {
            if (RepositorioPizzaMontada.getPizzaMontada(i).quantidadePizza() > 0) {
                output.append(AppConfig.NEW_LINE);
                output.append("    Nome: " + RepositorioPizzaMontada.getPizzaMontada(i).getPizza().getNome() + AppConfig.NEW_LINE);
                output.append("    Ingredientes: (");
                for (int j = 0; j < RepositorioPizzaMontada.getAll().get(i).getPizza().quantidadeDeIngredientes(); j++) {
                    output.append(RepositorioPizzaMontada.getAll().get(i).getPizza().getIngredientes(j).getIngredientes());
                    output.append(", ");
                }
                output.append(")");
                output.append(AppConfig.NEW_LINE);
                output.append("    Quantidade De Vendas : " + RepositorioPizzaMontada.getPizzaMontada(i).quantidadePizza());
                output.append(AppConfig.NEW_LINE);
            }
        }
        return output.toString();
    }
}
