/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Entity;

import java.time.LocalDate;

/**
 * Classe Empresa.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Company {
    
    /**
     * Nome da empresa.
     */
    private String name;
    
    /**
     * Email da empresa.
     */
    private String email;
    
    /**
     * Data de estabelecimento da empresa.
     */
    private LocalDate dateOfEstablishment;

    /**
     * Construtor para classe Company.
     * @param name
     * @param email
     * @param dateOfEstablishment
     */
    public Company(String name, String email, LocalDate dateOfEstablishment) {
        this.name = name;
        this.email = email;
        this.dateOfEstablishment = dateOfEstablishment;
    }

    /**
     * Construtor para classe Company com formato String.
     * @param name
     * @param email
     * @param dateOfEstablishment
     */
    public Company(String name, String email, String dateOfEstablishment) {
        this(name, email, LocalDate.parse(dateOfEstablishment, AppConfig.DATE_FORMAT));
    }
    
    /**
     * @return nome da empresa.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name da empresa.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return email da empresa.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @param email da empresa.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return data de estabelecimento da empresa.
     */
    public LocalDate getDateOfEstablishment() {
        return dateOfEstablishment;
    }
    
    /**
     * @param dateOfEstablishment da empresa.
     */
    public void setDateOfEstablishment(LocalDate dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }
       
    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getName()).append("{").append(AppConfig.NEW_LINE);
        output.append(" Empresa: ").append(AppConfig.NEW_LINE);
        output.append("         Nome: ").append(name).append(AppConfig.NEW_LINE);
        output.append("         Email: ").append(email).append(AppConfig.NEW_LINE);
        output.append("         Data de estabelecimento: ").append
            (dateOfEstablishment.format(AppConfig.DATE_FORMAT)).append(AppConfig.NEW_LINE);
        output.append("}").append(AppConfig.NEW_LINE);
        return output.toString();

    }
    
    /**
     * @param obj
     * @return indica se algum outro objeto é "igual" a este.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Company company = (Company) obj;

        return (name == company.name || name.equals(company.name))
                && (email == company.email || email.equals(company.email)
                && dateOfEstablishment == company.dateOfEstablishment || 
                dateOfEstablishment.equals(company.dateOfEstablishment));
    }

    /**
     * @return um valor de código de hash para o objeto.
     */
    @Override
    public int hashCode() {
        return (name.hashCode()) ^ (email.hashCode()) ^ (dateOfEstablishment.hashCode());
    }
}
