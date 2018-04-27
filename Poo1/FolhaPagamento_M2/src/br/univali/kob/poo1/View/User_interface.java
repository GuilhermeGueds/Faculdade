/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.View;

import br.univali.kob.poo1.Entity.Director;
import br.univali.kob.poo1.Entity.Employee;
import br.univali.kob.poo1.Entity.Controller.Storage;

/**
 * Classe Interface com o Usuário.
 *
 * @author Guilherme Guedes e Daniel Passos
 */
public class User_interface {

    /**
     *
     * @return opções do menu
     */
    public static int menuOption() {
        System.out.println("\n         Menu de Opção\n");
        System.out.println(" (1) Conultar Funcionário");
        System.out.println(" (2) Incluir Funcionário");
        System.out.println(" (3) Editar Funcionário");
        System.out.println(" (4) Excluir Funcionário");
        System.out.println(" (5) Consultar Funcionário com Maior Salário");
        System.out.println(" (6) Relatório de Funcionários");
        System.out.println(" (7) Relatório de Departamentos");
        System.out.println(" (8) Atualiza Horas Trabalhadas");
        System.out.println(" (9) Gerar Folha de Pagamento");
        System.out.println("(10) Limpar Repositórios ");
        System.out.println("(11) Sair");
        return DataIn.readlnInt("\nOpção ->", 1, 100);
    }

    /**
     * Consultar funcionário.
     *
     * @return nome.
     */
    public static String ConsultEmployee() {
        System.out.println("\nDigite o Nome do Funcionário");
        String name = "";
        while (name.isEmpty() || name.equals(" ") || name.equals("  ") || name.equals("   ")) {
            name = DataIn.readlnString(" ->");
            if (name.equals(null) || name.equals(" ") || name.equals("  ") || name.equals("   ")) {
                System.out.println("Nome Inválido");
            }
        }
        return name;
    }

    /**
     * Inserir um funcionário.
     *
     * @return funcionário
     */
    public static Employee insurceEmployee() {
        Employee employeee = null;
        String startDate = null;
        System.out.println("\nCadastro de Funcionário\n");
        int department = validateDepartment();
        if(department == 1)
            startDate = validateStartDirector();
        String name = validateName();
        String cpf = validateCpf();
        String rg = validateRg();
        String dateOfBirth = validateDateOfBirth();
        String email = validateEmail();
        String hireDate = validateHireDate();
        String SalaryBase = validateSalaryBase();
        String function = validateFunction();
        System.out.println("");
        if (department == 1) {
            Employee employee = new Director(name, cpf, rg, dateOfBirth, email,
                    hireDate, SalaryBase, function, Storage.DIRECTOR, startDate, "160");
            employeee = employee;
        } else if (department == 2) {
            Employee employee = new Employee(name, cpf, rg, dateOfBirth, email,
                    hireDate, SalaryBase, function, Storage.MANAGEMENTER, "160");
            employeee = employee;
        } else if (department == 3) {
            Employee employee = new Employee(name, cpf, rg, dateOfBirth, email,
                    hireDate, SalaryBase, function, Storage.PRODUCTION, "160");
            employeee = employee;
        } else {
            Employee employee = new Employee(name, cpf, rg, dateOfBirth, email,
                    hireDate, SalaryBase, function, Storage.FREELANCER, "160");
            employeee = employee;
        }
        System.out.println("Arquivo Salvo");
        return employeee;
    }

    /**
     * Validação do número.
     * @param word
     * @return validate
     */
    public static boolean validateNumber(String word) {
        boolean validate = false;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!(ch >= '0' && ch <= '9' || ch == '/')) {
                validate = true;
                System.out.println("Entrada Inválida");
                break;
            }
        }
        return validate;
    }

    /**
     * Validação do nome.
     * @return nome.
     */
    public static String validateName() {
        return DataIn.readlnString("Nome:  ");
    }

    /**
     * Validação do email.
     * @return email.
     */
    public static String validateEmail() {
        return DataIn.readlnString("Email:  ");
    }

    /**
     * Validação da função.
     * @return função.
     */
    public static String validateFunction() {
        return DataIn.readlnString("Função:  ");
    }

    /**
     * Validação do CPF.
     * @return CPF.
     */
    public static String validateCpf() {
        String cpf;
        cpf = DataIn.readlnString("CPF:  ");
        while (validateNumber(cpf)) {
            cpf = DataIn.readlnString("CPF:  ");
        }
        return cpf;
    }

    /**
     * Validação do RG.
     * @return RG.
     */
    public static String validateRg() {
        String rg;
        rg = DataIn.readlnString("RG:  ");
        while (validateNumber(rg)) {
            rg = DataIn.readlnString("RG:  ");
        }
        return rg;
    }
    
     /**
     * Valida quantidade de horas trabalhadas
     * @return 
     */
    public static String validateWorkingHours(){
     String workingHours;
        workingHours = DataIn.readlnString("Atualizar Hora Trabalhada:  ");
        while (validateNumber(workingHours)) {
            workingHours = DataIn.readlnString("\"Atualizar Hora Trabalhada:  \"");
        }
        return workingHours;
    }
    
    
    /**
     * Validação da data de nascimento.
     * @return data de nascimento.
     */
    public static String validateDateOfBirth() {
        String dateOfBirth;
        dateOfBirth = DataIn.readlnString("Data de nascimento (dia/mês/ano):  ");
        while (validateNumber(dateOfBirth)) {
            dateOfBirth = DataIn.readlnString("Data de nascimento (dia/mês/ano):  ");
        }
        return dateOfBirth;
    }

    /**
     * Validação da data de contratação.
     * @return data de contratação.
     */
    public static String validateHireDate() {
        String hireDate;
        hireDate = DataIn.readlnString("Admissão (dia/mês/ano):  ");
        while (validateNumber(hireDate)) {
            hireDate = DataIn.readlnString("Admissão (dia/mês/ano):  ");
        }
        return hireDate;
    }
    
    /**
     * Validação da data de inicio como diretor.
     * @return data de inicio como diretor.
     */
    public static String validateStartDirector() {
        String startDate;
        startDate = DataIn.readlnString("Data de Inicio como Diretor (dia/mês/ano):  ");
        while (validateNumber(startDate)) {
            startDate = DataIn.readlnString("Data de Inicio como Diretor (dia/mês/ano):  ");
        }
        return startDate;
    }

    /**
     * Validação do salário base.
     * @return salário base.
     */
    public static String validateSalaryBase() {
        String salaryBase;
        salaryBase = DataIn.readlnString("SalaryBase:  ");
        while (validateNumber(salaryBase)) {
            salaryBase = DataIn.readlnString("SalaryBase:  ");
        }
        return salaryBase;
    }

    /**
     * Validação do departamento.
     * @return opção de departamentos.
     */
    public static int validateDepartment() {
        return DataIn.readlnInt("Cargo:  (1) Diretor - (2) Administração - (3) Produção - (4) Freelancer\nOpção -> ", 1, 4);
    }

    /**
     * Mensagem de remoção de um funcionário.
     */
    public static void employeeRemoved() {
        System.out.println("\nFuncionário removido");
    }
    
    /**
     * Mensagem de repositorio vazio
     */
    public static void isEmpty(){
        System.out.println("Repositório esta vazio Favor fazer inserção");
    }
    
    public static void clearingRepositorys(){
        System.out.println("Repositórios foram limpos");
    }
}

