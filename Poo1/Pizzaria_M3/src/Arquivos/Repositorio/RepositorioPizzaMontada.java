/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Repositorio;

import Entidades.MontarPizza;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Repositório de Pizza Montada.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class RepositorioPizzaMontada {

    /**
     * Vetor de pizza montada.
     */
    private static final ArrayList<MontarPizza> pizzaMontada = new ArrayList<>();

    /**
     * Salvar pizza montada.
     * @param pizzaMontada 
     */
    public static void salvar(MontarPizza pizzaMontada) {
        RepositorioPizzaMontada.pizzaMontada.add(pizzaMontada);   
    }
    
    /**
     * @param posicao
     * @return pizza montada em uma posição.
     */
    public static MontarPizza getPizzaMontada(int posicao){
        return pizzaMontada.get(posicao);
    }

    /**
     * Mostrar tamanhos disponiveis.
     */
    public static void TamanhosDisponiveis() {
        for (int i = 0; i < pizzaMontada.size(); i++) {
            System.out.println(pizzaMontada.get(i));
        }
    }

    /**
     * Buscar pizza pela descrição.
     * @param descricao
     * @return 
     */
    public static MontarPizza buscarPorNome(String descricao) {
        MontarPizza aux = new MontarPizza();
        for (int i = 0; i < pizzaMontada.size(); i++) {
            if (descricao.equals(pizzaMontada.get(i).getPizza().getNome())) {
                aux = pizzaMontada.get(i);
            }
        }
        return aux;
    }

    /**
     * @return quantidade de pizzas montadas.
     */
    public static int quantidadePizzasMontadas() {
        return pizzaMontada.size();
    }

    /**
     * @return pizza montada.
     */
    public static ArrayList<MontarPizza> getAll() {
        return pizzaMontada;
    }

    /**
     * Buscar pizza pelo nome e descrição.
     * @param nomePizza
     * @param descricaoTamanho
     * @return 
     */
    public static MontarPizza buscarPorNome(String nomePizza, String descricaoTamanho) {
        for (int i = 0; i < pizzaMontada.size(); i++) {
            if (nomePizza.equals(pizzaMontada.get(i).getPizza().getNome())) {
                for (int j = 0; j < RepositorioTamanho.quantidadeTamanhos(); j++) {
                    if (descricaoTamanho.equals(pizzaMontada.get(i).getTamanho().get(j).getDescricao())) {
                        return pizzaMontada.get(i);
                    }
                }
            }
        }
        return null;
    } 
}