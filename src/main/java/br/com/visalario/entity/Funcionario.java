package br.com.visalario.entity;

public abstract class Funcionario {

    protected Integer id;

    protected String nome;

    protected double horasTrab;

    protected double valorHora;

    protected double salario;

    protected String cargo;

    public Funcionario(Integer id, String nome, double valorHora, double horasTrab, double salario, String cargo) {
        this.id = id;
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrab = horasTrab;
        this.salario = salario;
        this.cargo = cargo;
    }

    public void calcularSalario(){
        this.salario = this.horasTrab * this.valorHora;
    }

    public void imprimirInformacao(){
        System.out.println("Nome: " + this.nome +
                 ", Cargo: " + this.cargo
                + ", Horas trabalhadas: " + this.horasTrab
                + ", Valor hora: R$" + this.valorHora
                + ", Salário: R$" + this.salario);
    }
}
