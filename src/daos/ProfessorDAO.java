package daos;

import org.springframework.stereotype.Repository;

import entities.Professor;

@Repository
public class ProfessorDAO extends AbstractDAO<Professor> {

	public Class<Professor> entityClass() {
		return Professor.class;
	}
	
}
