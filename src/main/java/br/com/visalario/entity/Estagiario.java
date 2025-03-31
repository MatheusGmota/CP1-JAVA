package br.com.visalario.entity;

public class Estagiario extends Funcionario{

    public Estagiario(Integer id, String nome, double valorHora, double horasTrab, String cargo) {
        super(id, nome, cargo, valorHora, horasTrab);
    }

}
