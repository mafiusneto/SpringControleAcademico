package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.UsuarioDAO;
import entities.Usuario;


@Transactional
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	public Usuario efetuarLogin(String login, String senha){
		return usuarioDao.efetuaLogin(login, senha);
	
	}
	
	
}
