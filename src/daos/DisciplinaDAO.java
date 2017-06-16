package daos;

import org.springframework.stereotype.Repository;

import entities.Disciplina;



@Repository
public class DisciplinaDAO extends AbstractDAO<Disciplina> {

	public Class<Disciplina> entityClass() {
		return Disciplina.class;
	}
	
}
