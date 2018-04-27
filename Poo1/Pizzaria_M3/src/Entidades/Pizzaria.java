/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * Classe Pizzaria.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public final class Pizzaria {
    
    /**
     * Nome da pizzaria.
     */
    private final String nome;
    
    /**
     * Email da pizzaria.
     */
    private final String email;
    
    /**
     * Telefone da pizzaria.
     */
    private final int telefone;
    
    /**
     * CNPJ da pizzaria.
     */
    private final long cnpj;
    
    /**
     * Construtor para classe Pizzaria.
     * @param nome
     * @param email
     * @param telefone
     * @param cnpj 
     */
    public Pizzaria(String nome, String email, int telefone, long cnpj) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }
    
    /**
     * @return nome da pizzaria.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return email da pizzaria.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return telefone da pizzaria.
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @return cnpj da pizzaria.
     */
    public long getCnpj() {
        return cnpj;
    } 
}
