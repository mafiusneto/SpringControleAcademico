package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DisciplinaDAO;
import entities.Disciplina;


@Transactional
@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaDAO disciplinaDao;
		
	public List<Disciplina> lista(){
		return disciplinaDao.listar();
		
	}
	
	public void inserir(Disciplina disciplina){
		disciplinaDao.inserir(disciplina);
		
	}

	public void atualizar(Disciplina disciplina) {
		disciplinaDao.atualizar(disciplina);
		
	}

	public Disciplina buscaPorId(Long id) {
		return disciplinaDao.buscarPorId(id);
		
	}

	public void excluirPorId(Long id) {
		Disciplina disciplina =disciplinaDao.buscarPorId(id);
		if (disciplina != null){
			disciplinaDao.excluir(disciplina);
		}
		
	}
	
	
}
