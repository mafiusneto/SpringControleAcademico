package daos;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entities.Usuario;

@Repository
public class UsuarioDAO extends AbstractDAO<Usuario> {

	public Class<Usuario> entityClass() {
		return Usuario.class;
	}
	
	public Usuario efetuaLogin(String login, String senha){
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		List<Usuario> usuarios = query.getResultList();
		if(!usuarios.isEmpty()){
			return usuarios.get(0);
		}
		return null;
		
	}
	


}
