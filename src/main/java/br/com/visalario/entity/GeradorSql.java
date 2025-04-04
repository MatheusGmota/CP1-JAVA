package br.com.visalario.entity;

import br.com.visalario.annotations.Coluna;
import br.com.visalario.annotations.Tabela;

import java.lang.reflect.Field;

public class GeradorSql {

    // Método retorna uma string do sql e imprime na tela
    public String gerarSqlInsert(Object o) {

        Class<?> clazz = o.getClass();
        StringBuilder campos = new StringBuilder("(");
        StringBuilder values = new StringBuilder(" VALUES(");

        // Recuperando annotations Tabela e Coluna presentes na classe
        Tabela nomeTabela = clazz.getSuperclass().getAnnotation(Tabela.class);
        Field[] fields = clazz.getSuperclass().getDeclaredFields();

        for(int i = 0; i < fields.length; i++) {
            Coluna annt = fields[i].getAnnotation(Coluna.class);
            if (annt != null) {
                campos.append(annt.nome());
                if (i + 1 != fields.length) campos.append(",");
                else campos.append(")");
                values.append("?").append(",");
            }
        }

        // Inicializando stringBuilder do comando SQL
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(nomeTabela.nome()).append(campos);
        sql.append(values).replace(sql.length() -1, sql.length(),")");

        return sql.toString();
    }

    public String gerarTabela(Object o) {

        Class<?> clazz = o.getClass();
        StringBuilder tabela = new StringBuilder("CREATE TABLE ");
        StringBuilder campos = new StringBuilder("(");

        Tabela nomeTabela = clazz.getSuperclass().getAnnotation(Tabela.class);
        Field[] fields = clazz.getSuperclass().getDeclaredFields();

        for(int i = 0; i < fields.length; i++){
            Coluna coluna = fields[i].getAnnotation(Coluna.class);
            if(coluna.tamanho() != 255) {
                campos.append(coluna.nome()).append(" VARCHAR2(").append(coluna.tamanho()).append("),");
            } else if(coluna.precisao() != 0){
                String string = coluna.precisao() + "," + coluna.escala();
                campos.append(coluna.nome()).append(" NUMBER(").append(string).append("),");
            } else {
                campos.append(coluna.nome()).append(" INTEGER NOT NULL,");
            }
        }
        campos.delete(campos.length() - 1, campos.length());
        campos.append(")");
        tabela.append(nomeTabela.nome()).append(campos);

        return tabela.toString();
    }

}
