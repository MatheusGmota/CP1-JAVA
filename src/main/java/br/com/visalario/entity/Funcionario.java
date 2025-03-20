package br.com.visalario.entity;

import br.com.visalario.annotations.Coluna;
import br.com.visalario.annotations.Tabela;

@Tabela(nome = "TB_FUNCIONARIO")
public abstract class Funcionario {

    @Coluna(nome = "id_func")
    protected Integer id;

    @Coluna(nome = "cargo_func", tamanho = 50)
    protected String cargo;

    @Coluna(nome = "nome_func", tamanho = 100)
    protected String nome;

    @Coluna(nome = "nome_func", precisao = 10, escala = 2)
    protected double horasTrab;

    @Coluna(nome = "valor_hr_func", precisao = 10, escala = 2)
    protected double valorHora;

    @Coluna(nome = "salario_func", precisao = 10, escala = 2)
    protected double salario;

    public Funcionario(Integer id, String nome, String cargo, double valorHora, double horasTrab, double salario) {
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
