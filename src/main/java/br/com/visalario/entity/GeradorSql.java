package br.com.visalario.entity;

import br.com.visalario.annotations.Coluna;
import br.com.visalario.annotations.Tabela;

import java.lang.reflect.Field;

public class GeradorSql {

    private String sql = "";

    public String gerarSqlInsert(Object o) {
        //Método retorna uma string do sql e imprime na tela
        Class<?> clazz = o.getClass();
        StringBuilder campos = new StringBuilder("(");

        Tabela nomeTabela = clazz.getSuperclass().getAnnotation(Tabela.class);
        Field[] fields = clazz.getSuperclass().getDeclaredFields();
        for(Field field : fields) {
            Coluna annt = field.getAnnotation(Coluna.class);
            if (annt != null) {
                campos.append(annt.nome()).append(",");
            }
        }

        campos.deleteCharAt(campos.length() -1);
        this.sql = "INSERT INTO " + nomeTabela.nome() + campos + ")" + " VALUES(" + o.toString() + ")";
        System.out.println(sql);
        return sql;
    }

    public String gerarSqlUpdate(Object o) {
        //Método retorna uma string do sql e imprime na tela
        return "";

    }

}
