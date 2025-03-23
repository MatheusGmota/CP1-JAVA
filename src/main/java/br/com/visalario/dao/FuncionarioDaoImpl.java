package br.com.visalario.dao;

import br.com.visalario.entity.Funcionario;
import br.com.visalario.entity.GeradorSql;
import br.com.visalario.exceptions.CommitException;
import javax.persistence.EntityManager;

public class FuncionarioDaoImpl implements FuncionarioDao {

    private final EntityManager em;

    public FuncionarioDaoImpl(EntityManager em) {
        this.em = em;
    }

    private void criarTabela() {
        em.getTransaction().begin();
        String sql = "CREATE TABLE TB_FUNCIONARIO (" +
                 "id_func INTEGER NOT NULL," +
                 "cargo_func VARCHAR2(100)," +
                 "nome_func VARCHAR2(100)," +
                 "horas_trab NUMBER(5, 2)," +
                 "valor_hr_func NUMBER(10, 2)," +
                 "salario_func NUMBER(10, 2)" +
                 ")";

        em.createNativeQuery(sql).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public void criar(Funcionario funcionario) {
        em.getTransaction().begin();
        String sqlCreate = new GeradorSql().gerarSqlInsert(funcionario);

        em.createNativeQuery(sqlCreate)
                .setParameter(1, funcionario.getId())
                .setParameter(2, funcionario.getCargo())
                .setParameter(3, funcionario.getNome())
                .setParameter(4, funcionario.getHorasTrab())
                .setParameter(5, funcionario.getValorHora())
                .setParameter(6, funcionario.getSalario())
                .executeUpdate();
    }

    public void atualizar(Funcionario funcionario) {
        String sqlCreate = new GeradorSql().gerarSqlUpdate(funcionario);
        // implementar metodo...
    }

    public void commit() throws CommitException {
        try{
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
