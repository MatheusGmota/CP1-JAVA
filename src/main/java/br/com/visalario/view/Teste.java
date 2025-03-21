package br.com.visalario.view;

import br.com.visalario.dao.FuncionarioDao;
import br.com.visalario.dao.FuncionarioDaoImpl;
import br.com.visalario.entity.Senior;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        EntityManager em = fabrica.createEntityManager();
        FuncionarioDao funcionarioDao = new FuncionarioDaoImpl(em);

        Senior jose = new Senior(1, "José", 20, 160, 3200,"Senior" );

        try {
            funcionarioDao.criar(jose);
            funcionarioDao.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
