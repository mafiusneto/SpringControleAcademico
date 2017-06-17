package daos;

import org.springframework.stereotype.Repository;

import entities.Aluno;

@Repository
public class AlunoDAO extends AbstractDAO<Aluno> {

	public Class<Aluno> entityClass() {
		return Aluno.class;
	}
	
}
