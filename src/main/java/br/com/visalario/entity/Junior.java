package br.com.visalario.entity;

public class Junior extends  Funcionario{

    public Junior(Integer id, String nome, double valorHora, double horasTrab, double salario, String cargo) {
        super(id, nome, cargo, valorHora, horasTrab, salario);
    }

    @Override
    public void calcularSalario(){
        double bonus = (this.horasTrab/15) * 200;
        this.salario = (this.horasTrab * this.valorHora)+ bonus;
    }

}
