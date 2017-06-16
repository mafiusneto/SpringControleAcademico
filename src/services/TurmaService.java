package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.TurmaDAO;
import entities.Turma;


@Transactional
@Service
public class TurmaService {
	
	@Autowired
	private TurmaDAO turmaDao;
		
	public List<Turma> lista(){
		return turmaDao.listar();
		
	}
	
	public void inserir(Turma turma){
		turmaDao.inserir(turma);
		
	}

	public void atualizar(Turma turma) {
		turmaDao.atualizar(turma);
		
	}

	public Turma buscaPorId(Long id) {
		return turmaDao.buscarPorId(id);
		
	}

	public void excluirPorId(Long id) {
		Turma turma =turmaDao.buscarPorId(id);
		if (turma != null){
			turmaDao.excluir(turma);
		}
		
	}
	
	
}
