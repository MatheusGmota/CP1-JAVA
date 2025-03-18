package br.com.visalario.entity;

public abstract class Funcionario {

    private Integer id;

    private String nome;

    private double horasTrab;

    private double valorHora;

    private double salario;

    private String cargo;

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
