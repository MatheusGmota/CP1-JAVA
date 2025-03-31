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

    public void criarTabela(Funcionario funcionario) {
        em.getTransaction().begin();
        String sql = new GeradorSql().gerarTabela(funcionario);

        em.createNativeQuery(sql).executeUpdate();

        System.out.println("Tabela criada com sucesso!");
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
