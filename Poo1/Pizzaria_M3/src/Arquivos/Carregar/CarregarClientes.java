/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Carregar;

import Entidades.Cliente;

/**
 * Classe Carregar os Clientes.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class CarregarClientes extends CarregarArquivos {
    
    /**
     * Fazer o controle de cada linha.
     */
    private int controle = 0;
    
    /**
     * Carregar o template dos Clientes e suas informações.
     */
    @Override
    public void carregarTemplate() {
        int quantidadeDeClientes = Integer.parseInt(this.getConteudo(controle));
        controle++;
        for(int i=0; i< quantidadeDeClientes; i++){
            Cliente cliente = new Cliente();          
            cliente.setNome(this.getConteudo(controle));
            controle++;           
            cliente.setTelefone(Integer.parseInt(this.getConteudo(controle)));
            controle++;           
            cliente.setCpf(Long.parseLong(this.getConteudo(controle)));
            controle++;           
            cliente.setEndereco(this.getConteudo(controle));
            controle++;
        }
    }
}
