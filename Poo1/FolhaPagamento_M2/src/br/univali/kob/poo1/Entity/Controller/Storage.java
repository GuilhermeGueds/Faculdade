/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Entity.Controller;

/**
 * Enum Armazenamento.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public enum Storage {
    
    DIRECTOR("Director",1),
    MANAGEMENTER("Managmenter",2),
    PRODUCTION("Production",3),
    FREELANCER("FreeLancer",4);

    /**
     * Descrição do armazenamento.
     */
    private String description;
    
    /**
     * Id do armazenamento.
     */    
    private int id;

    private Storage(String description, int id) {
        this.description = description;
        this.id = id;
    }

    /**
     * @return descrição do armazenamento.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return id do armazenamento.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
