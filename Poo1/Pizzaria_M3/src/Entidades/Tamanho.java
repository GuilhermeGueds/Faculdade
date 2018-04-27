/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Arquivos.Repositorio.RepositorioTamanho;

/**
 * Classe Tamanho.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Tamanho {
    
    /**
     * Descrição do tamanho.
     */
    private String descricao;
    
    /**
     * Quantidade de fatias do tamanho.
     */
    private int quantidadeDeFatias;

    /**
     * Construtor para classe Tamanho.
     */  
    public Tamanho() {
        salvar();
    }
    
    /**
     * Construtor para classe Tamanho com quantidade de fatias e descrição.
     * @param qntFatias
     * @param descricao 
     */
    public Tamanho( int quantidadeDeFatias, String descricao) {
        this.descricao = descricao;
        this.quantidadeDeFatias = quantidadeDeFatias;
        this.salvar();
    }

    /**
     * @return descrição do tamanho
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return quantidades de fatias por tamanho.
     */
    public int getQuantidadeDeFatias() {
        return quantidadeDeFatias;
    }

    /**
     * @param quantidadeDeFatias 
     */
    public void setQuantidadeDeFatias(int quantidadeDeFatias) {
        this.quantidadeDeFatias = quantidadeDeFatias;
    }
    
    /**
     * Salvar tamanho.
     */
    public void salvar(){
       RepositorioTamanho.salvar(this);
    }
}
