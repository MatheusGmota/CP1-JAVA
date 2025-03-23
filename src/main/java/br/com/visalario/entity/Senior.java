package br.com.visalario.entity;

public class Senior extends Funcionario{

    public Senior(Integer id, String nome, double valorHora, double horasTrab, String cargo) {
        super(id, nome, cargo, valorHora, horasTrab);
    }

    @Override
    public void calcularSalario(){
        double bonus = (this.horasTrab/15) * 400;
        this.salario = (this.horasTrab * this.valorHora)+ bonus;
    }

}
