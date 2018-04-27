/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Arquivos.Repositorio.RepositorioClientes;

/**
 * Classe Cliente.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Cliente {
    
    /**
     * Nome do cliente.
     */
    private String nome;
    
    /**
     * Telefone do cliente.
     */
    private int telefone;
    
    /**
     * CPF do cliente.
     */
    private  long  cpf;
    
    /**
     * Endereço do cliente.
     */
    private String endereco;

    /**
     * Construtor para classe Cliente.
     */
    public Cliente() {
        this.salvar();
    }
    
    /**
     * Construtor para classe Cliente com informações.
     */    
    public Cliente(String nome, int telefone, long cpf, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salvar();
    }
    
    /**
     * @return nome do cliente.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return telefone do cliente.
     */
    public int getTelefone() {
        return telefone;
    }
    
    /**
     * @param telefone 
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return cpf do cliente.
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf 
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Salvar os Clientes.
     */
    public void salvar(){
        RepositorioClientes.salvar(this);
    }
}
