package daos;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entities.Curso;


@Repository
public class CursoDAO extends AbstractDAO<Curso> {

	public Class<Curso> entityClass() {
		return Curso.class;
	}
	
}
