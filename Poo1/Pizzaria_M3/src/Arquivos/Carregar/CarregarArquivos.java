/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos.Carregar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe Abstrata Carregar os Arquivos.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public abstract class CarregarArquivos {
    
    /**
     * Conteúdo de cada linha com tamanho de 100 caracteres.
     */
    private String [] conteudo = new String [100];
    
    /**
     * Linha de cada arquivo.
     */
    private String linha ;

    /**
     * Retorna o conteudo em uma posição.
     * @param posicao
     * @return
     */
    public String getConteudo(int posicao) {
        return conteudo[posicao];
    }
    
    /**
     * Carregar e ler o arquivo.
     * @param caminho 
     */
    public void carregarArquivo(String caminho){    
        try{
            FileReader arquivo = new FileReader(caminho);
            BufferedReader lerArquivo = new BufferedReader(arquivo);        
            try{   
                this.linha = lerArquivo.readLine();
                int contador = 0;
                while(linha!=null){ 
                    this.conteudo[contador]= linha;
                    linha = lerArquivo.readLine();
                    contador++;
                }
                arquivo.close();
            }catch(IOException ex){
               System.out.println( "Erro: Linha dos arquivos");
            }       
        }catch(FileNotFoundException ex){
            System.out.println( "Erro: Arquivo não encontrado");
        }
        this.carregarTemplate();
    }

    /**
     * Método para as subclasses chamar o carregarArquivo.
     */
    public abstract void carregarTemplate();
}