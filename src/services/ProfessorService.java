package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.ProfessorDAO;
import entities.Professor;


@Transactional
@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorDAO professorDao;
		
	public List<Professor> lista(){
		return professorDao.listar();
		
	}
	
	public void inserir(Professor professor){
		professorDao.inserir(professor);
		
	}

	public void atualizar(Professor professor) {
		professorDao.atualizar(professor);
		
	}

	public Professor buscaPorId(Long id) {
		return professorDao.buscarPorId(id);
		
	}

	public void excluirPorId(Long id) {
		Professor professor =professorDao.buscarPorId(id);
		if (professor != null){
			professorDao.excluir(professor);
		}
		
	}
	
	
}
