/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Persistence;

import br.univali.kob.poo1.Entity.AppConfig;
import br.univali.kob.poo1.Entity.Company;
import br.univali.kob.poo1.Entity.Controller.Storage;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe Folha de Pagamento. é um repositório tambem, que armazena as 
 * folhas de pagamentos dos funcionarios
 * 
 * @author Guilherme Guedes e Daniel Passos
 */
public class Payroll extends Repository implements Report<String> {

    /**
     * Folha de Pagamento da empresa.
     */  
    private final Company company;
    
    /**
     * Folha de Pagamento dos funcionários.
     */ 
    private final EmployeeRepository employee;
    
    /**
     * Histórico da Folha de Pagamento.
     */ 
    private final Repository historic;

    /**
     * Construtor para classe Payroll.
     * 
     * @param fileName
     * @param employee
     * @param company
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Payroll(String fileName, EmployeeRepository employee, Company company) throws IOException, ClassNotFoundException {
        super(fileName);
        this.historic = new Repository("Historico de folhas .dat") {} ;
       
        this.employee = employee;
        this.company = company;
        
    }
    
    /**
     * @return gerar a folha de pagamento.
     * @throws IOException
     */
    public String generatePayroll() throws IOException{
        this.clear();
        this.save(report());
        historic.save(report());
        return report();
    }
    
    /**
     * Limpar repositório da folha de pagamento.
     * @throws IOException
     */
    public void clearRepository() throws IOException{      
        clear();  
    }

    /**
     * @return uma string para representação de um objeto.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(AppConfig.NEW_LINE);
        output.append(AppConfig.NEW_LINE);
        for(int i=0; i < employee.size(); i++){
            if( employee.getEmployee(i).getStorage() != Storage.FREELANCER){
                employee.getEmployee(i).automaticCalculation();     
                output.append("RECIBO DE PAGAMENTO " + "               Data: " 
                        + LocalDate.now().format(AppConfig.DATE_FORMAT) 
                        + AppConfig.NEW_LINE + AppConfig.NEW_LINE);
                output.append("  Empresa: " + company.getName() 
                        + AppConfig.NEW_LINE + AppConfig.NEW_LINE);
                output.append("  Funcionario: " + employee.getEmployee(i).getName() 
                        + AppConfig.NEW_LINE);
                output.append("  CPF: " + employee.getEmployee(i).getCpf()
                        + AppConfig.NEW_LINE);
                output.append("  Cargo: " + employee.getEmployee(i).getDescription()
                        + AppConfig.NEW_LINE);
                output.append("  Admissao: " + employee.getEmployee(i).getHireDate().
                        format(AppConfig.DATE_FORMAT)+ AppConfig.NEW_LINE);
                output.append("  Salario Base: " + employee.getEmployee(i).getSalaryBase()
                        + AppConfig.NEW_LINE);
                output.append("  Horas Trabalhadas Mes: " + employee.getEmployee(i).getWorkingHours()
                        + AppConfig.NEW_LINE);
                if(employee.getEmployee(i).getDiscount().compareTo(new BigDecimal(i))!=0)
                    output.append("  Desconto: " + employee.getEmployee(i).getDiscount()
                            + AppConfig.NEW_LINE);
                if(employee.getEmployee(i).getOvertime().compareTo(new BigDecimal(i))!=0)
                    output.append("  Horas Extras: " + employee.getEmployee(i).getOvertime()
                            + AppConfig.NEW_LINE);
                if(employee.getEmployee(i).getBonus().compareTo(new BigDecimal(i))!=0)
                    output.append("  Bonus: " + employee.getEmployee(i).getBonus()
                            + AppConfig.NEW_LINE);
                output.append("  INSS: " + employee.getEmployee(i).getSocialInsurance()
                        + AppConfig.NEW_LINE);
                if(employee.getEmployee(i).getIncomeTax().compareTo(new BigDecimal(i))!=0)
                    output.append("  Imposto de Renda: " + employee.getEmployee(i).getIncomeTax()
                            + AppConfig.NEW_LINE);
                output.append("  Total De Descontos: " + employee.getEmployee(i).getTotalDiscount()
                        + AppConfig.NEW_LINE);
                output.append("  Salario Liquido: " + employee.getEmployee(i).getNetSalary()
                        + AppConfig.NEW_LINE);
                output.append(AppConfig.NEW_LINE);
                output.append("-----------------------------------------------------");
                output.append(AppConfig.NEW_LINE);
                output.append(AppConfig.NEW_LINE);
            }
        }
        return output.toString();
    }

    /**
     * @return relatório.
     */
    @Override
    public String report() {
        return this.toString();
    }
}
