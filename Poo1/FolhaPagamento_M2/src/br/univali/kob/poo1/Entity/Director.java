/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Entity;

import br.univali.kob.poo1.Entity.Controller.Storage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

/**
 * Classe Diretor.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Director extends Employee {

    /**
     * Data de inicio do diretor.
     */    
    private LocalDate startDate;

    /**
     * Construtor para classe Director.
     * 
     * @param name
     * @param cpf
     * @param rg
     * @param dateOfBirth
     * @param email
     * @param hireDate
     * @param salaryBase
     * @param description
     * @param storage
     * @param startDate
     * @param workingHours
     */
    public Director(String name, long cpf, long rg, LocalDate dateOfBirth,
            String email, LocalDate hireDate, BigDecimal salaryBase, String description, 
            Storage storage, LocalDate startDate, BigDecimal workingHours) {
        super(name, cpf, rg, dateOfBirth, email, hireDate, salaryBase,
                description, storage, workingHours);
        this.startDate = startDate;

    }

    /**
     * Construtor para classe Director com formato String.
     * 
     * @param name
     * @param cpf
     * @param rg
     * @param dateOfBirth
     * @param email
     * @param hireDate
     * @param salaryBase
     * @param description
     * @param storage
     * @param startDate
     * @param workingHours
     */
    public Director(String name, String cpf, String rg, String dateOfBirth,
            String email, String hireDate, String salaryBase, String description,
            Storage storage, String startDate, String workingHours) {
        this(name, Long.parseLong(cpf), Long.parseLong(rg), 
                LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT),
                email, LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), 
                new BigDecimal(salaryBase), description, storage, 
                LocalDate.parse(startDate, AppConfig.DATE_FORMAT), 
                new BigDecimal(workingHours));

    }

    /**
     * @return data de inicio do diretor.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @param startDate do diretor.
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return anos que foi diretor a partir de sua data de inicio até hoje.
     */  
    public int yearsOfDirector() {
        Period period = Period.between(startDate, LocalDate.now());
        return period.getYears();

    }
    
    /**
     * @return o bonus para cada ano que atuou como diretor.
     */
    @Override
    public BigDecimal bonus() {
        BigDecimal value = super.calculateNetSalaryWithoutTax().multiply(new BigDecimal(0.4));
        setBonus(new BigDecimal((yearsOfDirector() * 0.05)));
        setBonus(getBonus().multiply(calculateNetSalaryWithoutTax()));
        if (getBonus().compareTo(value.setScale(2, RoundingMode.HALF_EVEN)) == 1) {
            setBonus(super.calculateNetSalaryWithoutTax().multiply(new BigDecimal(0.4)));
        }
        return getBonus();
    }
    
    /**
     * @return calculo do salário líquido de um funcionário com as taxas.
     */
    @Override
    public BigDecimal calculateNetSalary() {
        return super.calculateNetSalary().add(getBonus()).setScale(2, RoundingMode.CEILING);
    }
}
