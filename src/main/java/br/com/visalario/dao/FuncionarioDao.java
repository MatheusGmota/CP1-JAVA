package br.com.visalario.dao;

import br.com.visalario.entity.Funcionario;
import br.com.visalario.exceptions.CommitException;

public interface FuncionarioDao {
    void criar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    void commit() throws CommitException;
}
