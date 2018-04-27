/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Entity;

import br.univali.kob.poo1.Entity.Controller.Storage;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;
import java.util.Objects;

/**
 * Classe Funcionário.
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Employee extends Person implements Comparable<Employee> {

    /**
     * Quantidade de horas trabalhadas inicialmente do funcionário.
     */
    private static int amountHours = 160;

    /**
     * Data de contratação do funcionário.
     */
    private LocalDate hireDate;

    /**
     * Salário base do funcionário.
     */
    private BigDecimal salaryBase;
    
    /**
     * Descrição do funcionário.
     */
    private String description;

    /**
     * Armazenamento do funcionário.
     */
    private Storage storage;
    
    /**
     * Jornada de trabalho por mês do funcionário.
     */
    private BigDecimal workingHours;
    
    /**
     * Data de desligamento do funcionário.
     */
    private LocalDate terminationDate;

    /**
     * Valor da hora contratada do funcionário.
     */
    private BigDecimal hourlyRate;

    /**
     * Horas extras do funcionário.
     */
    private BigDecimal overtime;

    /**
     * Salário líquido do funcionário.
     */
    private BigDecimal netSalary;

    /**
     * Bônus do funcionário.
     */
    private BigDecimal bonus;

    /**
     * Descontos por faltas do funcionário.
     */
    private BigDecimal discount;

    /**
     * Total de descontos do funcionário.
     */
    private BigDecimal totalDiscount;

    /**
     * Imposto de renda do funcionário.
     */
    private BigDecimal incomeTax;

    /**
     * INSS do funcionário.
     */
    private BigDecimal socialInsurance;
    
    /**
     * Construtor para classe Employee.
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
     * @param workingHours
     */
    public Employee(String name, long cpf, long rg, LocalDate dateOfBirth, 
            String email, LocalDate hireDate, BigDecimal salaryBase, 
            String description, Storage storage, BigDecimal workingHours) {
        super(name, cpf, rg, dateOfBirth, email);
        this.hireDate = hireDate;
        this.salaryBase = salaryBase;
        this.description = description;
        this.storage = storage;
        this.discount = new BigDecimal(0);
        this.overtime = new BigDecimal(0);
        this.socialInsurance = new BigDecimal(0);
        this.incomeTax = new BigDecimal(0);
        this.hourlyRate = new BigDecimal(0);
        this.bonus = new BigDecimal(0);
        this.workingHours = workingHours;
        validateSalaryBase();
        validateWorkingHours();
    }

    /**
     * Construtor para classe Employee com formato String.
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
     * @param workingHours
     */
    public Employee(String name, String cpf, String rg, String dateOfBirth,
            String email, String hireDate, String salaryBase, String description,
            Storage storage, String workingHours) {
        this(name, Long.parseLong(cpf), Long.parseLong(rg), 
                LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), email,
                LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), new BigDecimal(salaryBase),
                description, storage, new BigDecimal(workingHours));
    }
   
    /**
     * @return quantidade de horas trabalhadas inicialmente do funcionário.
     */
    public static int getAmountHours() {
        return amountHours;
    }

    /**
     * @param amountHours
     */
    public static void setAmountHours(int amountHours) {
        Employee.amountHours = amountHours;
    }
    
    /**
     * @return data de contratação do funcionário.
     */
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    /**
     * @param hireDate
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * @return salário base do funcionário.
     */
    public BigDecimal getSalaryBase() {
        return salaryBase.setScale(2, RoundingMode.CEILING);
    }

    /**
     * @param salaryBase
     */
    public void setSalaryBase(String salaryBase) {
        this.salaryBase = new BigDecimal(salaryBase);
        validateSalaryBase();
    }    
    
    /**
     * @return descrição do funcionário.
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
     * @return armazenamento do funcionário.
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * @param storage
     */
    public void setStorage(Storage storage) {
        this.storage = storage;
    }    
    
    /**
     * @return jornada de trabalho por mês do funcionário.
     */
    public BigDecimal getWorkingHours() {
        return workingHours;
    }

    /**
     * @param workingHours
     */
    public void setWorkingHours(String workingHours) {
        this.workingHours = new BigDecimal(workingHours);
        validateWorkingHours();
    }

    /**
     * @return data de desligamento do funcionário.
     */
    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    /**
     * @param terminationDate
     */
    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }    
    
    /**
     * @return valor da hora contratada do funcionário.
     */
    public BigDecimal getHourlyRate() {
        return this.hourlyRate = salaryBase.divide(new BigDecimal(amountHours));
    }
    
    /**
     * @return horas extras do funcionário.
     */
    public BigDecimal getOvertime() {
        return overtime.setScale(2, RoundingMode.CEILING);
    }    
    
    /**
     * @return salário líquido do funcionário.
     */
    public BigDecimal getNetSalary() {
        return netSalary.setScale(2, RoundingMode.CEILING);
    }

    /**
     * @param netSalary
     */
    public void setNetSalary(String netSalary) {
        this.netSalary = new BigDecimal(netSalary);
    }    
    
    /**
     * @return bônus do funcionário.
     */
    public BigDecimal getBonus() {
        return bonus.setScale(2, RoundingMode.CEILING);
    }

    /**
     * @param bonus
     */
    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }    

    /**
     * @return descontos por faltas do funcionário.
     */
    public BigDecimal getDiscount() {
        return discount.setScale(2, RoundingMode.CEILING);
    }    
     
    /**
     * @return total de descontos do funcionário.
     */
    public BigDecimal getTotalDiscount() {
        return totalDiscount.setScale(2, RoundingMode.CEILING);
    }

    /**
     * @param totalDiscount
     */
    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * @return imposto de renda do funcionário.
     */
    public BigDecimal getIncomeTax() {
        return incomeTax.setScale(2, RoundingMode.CEILING);
    }

    /**
     * @param incomeTax
     */
    public void setIncomeTax(BigDecimal incomeTax) {
        this.incomeTax = incomeTax;
    }
    
    /**
     * @return INSS do funcionário.
     */
    public BigDecimal getSocialInsurance() {
        return socialInsurance.setScale(2, RoundingMode.CEILING);
    }

    /**
     * @param socialInsurance
     */
    public void setSocialInsurance(BigDecimal socialInsurance) {
        this.socialInsurance = socialInsurance;
    }    
   
    /**
     * Validação do Salário Base.
     */
    private void validateSalaryBase() {
        if (salaryBase.compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("Salario não pode ser menor ou igual a 0");
        }
    }

    /**
     * Validação da jornada de trabalho por mês do funcionário..
     */
    private void validateWorkingHours() {
        if (workingHours.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("Quantidades de horas  não pode ser menor ou igual a 0");
        }
    }

    /**
     * @return verdadeiro ou falso se é um funcionário.
     */
    public Boolean isEmployed() {
        return terminationDate == null;
    }
    
    /**
     * @return tenpo de serviço do funcionário.
     */
    public int getYearsOfService() {
        if (isEmployed()) {
            Period period = Period.between(hireDate, LocalDate.now());
            return period.getYears();
        } else {
            Period period = Period.between(hireDate, terminationDate);
            return period.getYears();
        }
    }   
    
    /**
     * Calcular horas extras de um funcionário.
     */
    public void calculateOvertime() {
        BigDecimal value = new BigDecimal(amountHours);
        if (workingHours.compareTo(value) == 1) {
            value = workingHours.subtract(new BigDecimal(160));
            value = value.multiply(new BigDecimal(1.5));
            overtime = value.multiply(getHourlyRate());
        } else {
            overtime = new BigDecimal(0);
        }
    }
      
    /**
     * @return calculo do salário líquido de um funcionário com as taxas. 
     */
    public BigDecimal calculateNetSalary() {
        calculateIncomeTax();
        return netSalary = salaryBase.add(overtime.subtract(discount)
                .subtract(incomeTax).subtract(socialInsurance).setScale(2, RoundingMode.CEILING));

    }
    
    /**
     * @return calculo do salário líquido de um funcionário sem as taxas.
     */
    public BigDecimal calculateNetSalaryWithoutTax() {
        return salaryBase.add(overtime.subtract(discount));
    }

    /**
     * Calculo do desconto por hora trabalhada do funcionário.
     */
    public void calculateDiscount() {
        BigDecimal value = new BigDecimal(amountHours * 0.9);
        if (workingHours.compareTo(value) <= 0) {
            discount = salaryBase.subtract(workingHours.multiply(getHourlyRate()));
        } else {
            discount = new BigDecimal(0);
        }
    }
    
    /**
     * Calcular o total de descontos do funcionário.
     */
    public void calculateTotalDiscount() {
        totalDiscount = discount.add(socialInsurance).add(incomeTax);
    }

    /**
     * Calcular o imposto de renda do funcionário.
     */
    public void calculateIncomeTax() {
        BigDecimal value;
        BigDecimal value2 = new BigDecimal(1499.15);
        BigDecimal value3 = new BigDecimal(2246.75);
        BigDecimal value4 = new BigDecimal(2995.70);
        BigDecimal value5 = new BigDecimal(3743.19);
        calculateSocialInsurance();
        value = calculateNetSalaryWithoutTax();
        value = value.subtract(socialInsurance);
        if (value.compareTo((value2)) <= 0) {
            incomeTax = new BigDecimal(0);
        } else if (value.compareTo((value3)) <= 0) {
            incomeTax = value.multiply(new BigDecimal(0.075 / 12));
        } else if (value.compareTo((value4)) <= 0) {
            incomeTax = value.multiply(new BigDecimal(0.15 / 12));
        } else if (value.compareTo((value5)) <= 0) {
            incomeTax = value.multiply(new BigDecimal(0.225 / 12));
        } else {
            incomeTax = value.multiply(new BigDecimal(0.275 / 12));
        }
    }

    /**
     * Calcular o INSS do funcionário.
     */
    public void calculateSocialInsurance() {
        BigDecimal value;
        BigDecimal ceiling = new BigDecimal(482.93);
        value = calculateNetSalaryWithoutTax();
        socialInsurance = value.multiply(new BigDecimal(0.11));
        if (socialInsurance.compareTo(ceiling) == 1) {
            socialInsurance = ceiling;
        }
    }

    /**
     * @return o bonus de um funcionário.
     */
    public BigDecimal bonus() {
        return null;
    }
    
    /**
     * Chamada de todos os calculos de um funcionário.
     */
    public void automaticCalculation() {
        calculateNetSalary();
        calculateOvertime();
        calculateDiscount();
        calculateIncomeTax();
        calculateTotalDiscount();
        bonus();
    }

    /**
     * @param otherName
     * @return redefinição para compareTo
     */
    @Override
    public int compareTo(Employee otherName) {
        return this.getName().compareTo(otherName.getName());
    }
    
    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    protected String appendToString() {
        StringBuilder output = new StringBuilder();
        output.append("  Cargo: " + this.getDescription() + AppConfig.NEW_LINE);
        output.append("  Contratado em: " + hireDate.format(AppConfig.DATE_FORMAT) + AppConfig.NEW_LINE);
        output.append("  Salario Base: " + salaryBase.toPlainString() + AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        return output.toString();
    }

    /**
     * @param obj
     * @return indica se algum outro objeto é "igual" a este.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return true;
    }
    
    /**
     * @return um valor de código de hash para o objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.hireDate);
        hash = 17 * hash + Objects.hashCode(this.terminationDate);
        hash = 17 * hash + Objects.hashCode(this.hourlyRate);
        hash = 17 * hash + Objects.hashCode(this.workingHours);
        hash = 17 * hash + Objects.hashCode(this.overtime);
        hash = 17 * hash + Objects.hashCode(this.salaryBase);
        hash = 17 * hash + Objects.hashCode(this.netSalary);
        hash = 17 * hash + Objects.hashCode(this.bonus);
        hash = 17 * hash + Objects.hashCode(this.discount);
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.storage);
        hash = 17 * hash + Objects.hashCode(this.incomeTax);
        hash = 17 * hash + Objects.hashCode(this.socialInsurance);
        return hash;
    }
}
