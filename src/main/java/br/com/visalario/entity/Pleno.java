package br.com.visalario.entity;

public class Pleno extends Funcionario{

    public Pleno(Integer id, String nome, double valorHora, double horasTrab, String cargo) {
        super(id, nome, cargo, valorHora, horasTrab);
    }

    @Override
    public void calcularSalario(){
        double bonus = (this.horasTrab/15) * 300;
        this.salario = (this.horasTrab * this.valorHora)+ bonus;
    }

}
