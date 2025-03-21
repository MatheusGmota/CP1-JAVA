package br.com.visalario.dao;

import br.com.visalario.entity.Funcionario;
import br.com.visalario.entity.GeradorSql;
import br.com.visalario.exceptions.CommitException;
import javax.persistence.EntityManager;

public class FuncionarioDaoImpl implements FuncionarioDao {

    private EntityManager em;

    public FuncionarioDaoImpl(EntityManager em) {
        this.em = em;
    }

    private void criarTabela() {
        em.getTransaction().begin();
        String sql = "CREATE TABLE TB_FUNCIONARIO (" +
                 "id INTEGER NOT NULL," +
                 "nome VARCHAR2(100)," +
                 "cargo VARCHAR2(100)," +
                 "horas_trabalhadas NUMERIC(5, 2)," +
                 "salario NUMERIC(10, 2)," +
                 "bonus NUMERIC(10, 2)" +
                 ")";

        em.createNativeQuery(sql).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public void criar(Funcionario funcionario) {
        String sqlCreate = new GeradorSql().gerarSqlInsert(funcionario);

        em.createQuery(sqlCreate).executeUpdate();
    }

    public void atualizar(Funcionario funcionario) {
        String sqlCreate = new GeradorSql().gerarSqlUpdate(funcionario);
        em.persist(funcionario);
    }

    public void commit() throws CommitException {
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }
}
