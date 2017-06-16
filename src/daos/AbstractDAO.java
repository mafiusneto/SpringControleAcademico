package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> {
	
	
	@PersistenceContext
	EntityManager manager;
	
	public void inserir(T entity){
		manager.persist(entity);
	}
	
	public void atualizar(T entity){
		manager.merge(entity);
	}
	
	public void excluir(T entity){
		entity = manager.find(entityClass(), entity.getId());
		manager.remove(entity);
	}
	
	public abstract Class<T> entityClass();
	

	public T buscarPorId(Long id){
		return manager.find(entityClass(), id);
	}
	
	public List<T> listar(){
		Query query =  manager.createQuery("select c from "+ entityClass().getSimpleName()+" c");
		return  query.getResultList();
		
	}


}
