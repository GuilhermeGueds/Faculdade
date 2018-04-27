/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import Arquivos.Repositorio.RepositorioModeloPizza;
import Arquivos.Repositorio.RepositorioPizzaMontada;
import Arquivos.Repositorio.RepositorioTamanho;

/**
 * Classe Montar a Pizza.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class MontarPizza {
    
    /**
     * Quantidade de pizzas vendidas.
     */
    private  int quantidadeDePizzaVendida = 0;
    
    /**
     * Vetor de preços.
     */
    private ArrayList<BigDecimal> preco = new ArrayList<>();
    
    /**
     * Informações da pizza.
     */
    private ModeloPizza pizza;
    
    /**
     * Vetor de tamanhos.
     */
    private ArrayList<Tamanho> tamanho = new ArrayList<>();

    /**
     * Construtor para classe Modelo Tamanho.
     */
    public MontarPizza() {
        salvar();
    }

    /**
     * @param posicao
     * @return preço na posição.
     */
    public BigDecimal getPreco(int posicao) {
        return preco.get(posicao);     
    }

    /**
     * @param preco 
     */
    public void setPreco(String preco) {
        this.preco.add(new BigDecimal(preco));
    }

    /**
     * @return pizza.
     */
    public ModeloPizza getPizza() {
        return pizza;
    }

    /**
     * @param pizza 
     */
    public void setPizza(ModeloPizza pizza) {
        this.pizza = pizza;
    }
    
    /**
     * @return tamanho da pizza
     */
    public ArrayList<Tamanho> getTamanho () {
        return tamanho;
    }
    
    /**
     * Salvar pizza montada.
     */
    public  void salvar(){
        RepositorioPizzaMontada.salvar(this);
       
    } 
    
    /**
     * @param tamanhos 
     */
    public void setTamanho(ArrayList<Tamanho> tamanhos){
        this.tamanho = tamanhos;
    }
    
    /**
     * Acrescentar o número de pizzas vendidas.
     */
    public void pizzaVendida(){
        this.quantidadeDePizzaVendida++;
    }
    
    /**
     * @return quantidade de pizzas vendidas.
     */
    public int quantidadePizza(){
        return quantidadeDePizzaVendida;
    }
    
    /**
     * Mostrar o modelo de pizza montada.
     * @param modelo 
     */
    public  void mostrarModeloPizzaMontada(String modelo) {
        for (int i = 0; i < RepositorioModeloPizza.quantidadeModeloPizza(); i++) {
            if (modelo.equals(RepositorioModeloPizza.buscarPorPosicao(i).getNome())) {
                System.out.println(RepositorioModeloPizza.buscarPorPosicao(i).getNome());
                for (int j = 0; j < RepositorioTamanho.quantidadeTamanhos(); j++) {
                    System.out.println("RepositorioModeloPizza{"
                            + " TAMANHO : "
                            + RepositorioTamanho.getTamanhos(j).getDescricao()
                            + "} {QTD DE FATIAS:  "
                            + RepositorioTamanho.getTamanhos(j).getQuantidadeDeFatias()
                            + "} {PREÇO:  "
                            + this.getPreco(j)
                            + '}');
                }
            }
        }
    }
     
    /**
     * Montar a pizza.
     * @param pizza 
     */
    public void montar(ModeloPizza pizza){
           this.setPizza(pizza);          
           this.setTamanho(RepositorioTamanho.retornaArray());
    }
}     
   
   
    
    

