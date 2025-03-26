package br.com.visalario.view;

import br.com.visalario.entity.GeradorSql;
import br.com.visalario.entity.Senior;

public class TesteGeradorSql {
    public static void main(String[] args) {
        Senior jose = new Senior(1, "José", 20, 160, "Senior" );
        jose.calcularSalario();

        new GeradorSql().gerarTabela(jose);
    }
}
