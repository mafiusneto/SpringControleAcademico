package daos;

import org.springframework.stereotype.Repository;

import entities.Turma;

@Repository
public class TurmaDAO extends AbstractDAO<Turma> {

	public Class<Turma> entityClass() {
		return Turma.class;
	}
	
}
