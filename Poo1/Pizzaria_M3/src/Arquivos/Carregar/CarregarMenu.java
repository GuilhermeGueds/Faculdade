/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Carregar;

import Entidades.ModeloPizza;
import Entidades.Ingredientes;
import Entidades.MontarPizza;
import Entidades.Tamanho;

/**
 * Classe Carregar o Menu.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
    public class CarregarMenu extends CarregarArquivos{
    
    /**
     * Fazer o controle de cada linha.
     */
    private  int controle = 0;
    
    /**
     * Quantidade de opções de tamanho.
     */
    private int quantidadeTamanho;

    /**
     * Carregar o template com os tamanhos da Pizza e a Pizza.
     */
    public void carregarTemplate(){    
       this.criarTamanho();
       this.criarPizza();
    }
    
    /**
     * Criar o tamanho da pizza.
     */
    private void criarTamanho(){
        quantidadeTamanho = Integer.parseInt(this.getConteudo(controle));
        controle++;
        for(int i=0; i<quantidadeTamanho;i++){
           Tamanho tamanho = new Tamanho();
           tamanho.setDescricao(this.getConteudo(controle));
           controle++;
           tamanho.setQuantidadeDeFatias(Integer.parseInt(this.getConteudo(controle)));
           controle++;
        }
    }
    
    /**
     * Criar a pizza.
     */
    private void criarPizza(){
        int quantidadeDePizza = Integer.parseInt(this.getConteudo(controle));
        controle++;
        for(int i=0; i<quantidadeDePizza;i++){
           ModeloPizza pizza = new ModeloPizza();
           pizza.setNome(this.getConteudo(controle));
           controle++;
           this.ingredientesPizza(pizza);
           MontarPizza montar = new MontarPizza();
           montar.montar(pizza);
           this.precoPizza(montar);
        }
    }
    
    /**
     * Ingredientes que a pizza possui.
     * @param pizza 
     */
    private void ingredientesPizza(ModeloPizza pizza){
        int quantidadeIngredientes = Integer.parseInt(this.getConteudo(controle));
        controle++;
        for(int i=0; i<quantidadeIngredientes; i++){
            pizza.setIngredientes( new Ingredientes(this.getConteudo(controle)));
            controle++;
         }
    }   
    
    /**
     * O preço da pizza.
     * @param pizza 
     */
    private void precoPizza(MontarPizza pizza){
        for(int i=0; i<this.quantidadeTamanho; i++){
            pizza.setPreco(this.getConteudo(controle));
            controle++;
        }
    }     
}       
