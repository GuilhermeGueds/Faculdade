/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Relatorios;

import Arquivos.Repositorio.RepositorioPizzaMontada;
import Sistema.AppConfig;

/**
 * Classe Relatório Menu.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RelatorioMenu extends Relatorios {
  
    /**
     * @return quantidades de pizzas vendidas.
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
        output.append( "                                Menu" + AppConfig.NEW_LINE);
        for (int i = 0; i < RepositorioPizzaMontada.quantidadePizzasMontadas(); i++) {
            output.append(AppConfig.NEW_LINE);
            output.append("    " + (i + 1) + ". " + RepositorioPizzaMontada.getAll().get(i).getPizza().getNome() + AppConfig.NEW_LINE);
            output.append("   (");
            for (int j = 0; j < RepositorioPizzaMontada.getAll().get(i).getPizza().quantidadeDeIngredientes(); j++) {
                output.append(RepositorioPizzaMontada.getAll().get(i).getPizza().getIngredientes(j).getIngredientes());
                output.append(",");   
            }
            output.append(")");
            output.append(AppConfig.NEW_LINE);
            for (int j = 0; j < RepositorioPizzaMontada.getAll().get(i).getTamanho().size(); j++) {
                output.append("    " + RepositorioPizzaMontada.getAll().get(j).getTamanho().get(j).getDescricao() + " R$ "
                        + RepositorioPizzaMontada.getAll().get(i).getPreco(j) + ",");
            }    
            output.append(AppConfig.NEW_LINE);
        }
        return output.toString();
    }
}

