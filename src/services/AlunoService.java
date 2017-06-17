package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.AlunoDAO;
import entities.Aluno;


@Transactional
@Service
public class AlunoService {
	
	@Autowired
	private AlunoDAO alunoDao;
		
	public List<Aluno> lista(){
		return alunoDao.listar();
		
	}
	
	public void inserir(Aluno aluno){
		alunoDao.inserir(aluno);
		
	}

	public void atualizar(Aluno aluno) {
		alunoDao.atualizar(aluno);
		
	}

	public Aluno buscaPorId(Long id) {
		return alunoDao.buscarPorId(id);
		
	}

	public void excluirPorId(Long id) {
		Aluno aluno =alunoDao.buscarPorId(id);
		if (aluno != null){
			alunoDao.excluir(aluno);
		}
		
	}
	
	
}
