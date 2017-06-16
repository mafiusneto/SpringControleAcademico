package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.CursoDAO;
import entities.Curso;


@Transactional
@Service
public class CursoService {
	
	@Autowired
	private CursoDAO cursoDao;
		
	public List<Curso> lista(){
		return cursoDao.listar();
		
	}
	
	public void inserir(Curso curso){
		cursoDao.inserir(curso);
		
	}

	public void atualizar(Curso curso) {
		cursoDao.atualizar(curso);
		
	}

	public Curso buscaPorId(Long id) {
		return cursoDao.buscarPorId(id);
		
	}

	public void excluirPorId(Long id) {
		Curso curso =cursoDao.buscarPorId(id);
		if (curso != null){
			cursoDao.excluir(curso);
		}
		
	}
	
	
}
