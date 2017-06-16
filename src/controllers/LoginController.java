package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.UsuarioService;
import entities.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "login"}, method=RequestMethod.GET) //URL
	public String form(ModelMap map){
		Usuario usuario = new Usuario();
		map.addAttribute("usuario", usuario);
		return "login"; //busca jsp
	}
	
	@RequestMapping(value="/logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario usuario, ModelMap map, HttpSession session){
		
		System.out.println("ENTROU /logar");
		if(usuario.getLogin().equals("") || usuario.getSenha().equals("") ){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			map.addAttribute("erro", "Login ou senha vazios");
			return "login";
		}
		
		Usuario usuarioLogado = usuarioService.efetuarLogin(usuario.getLogin(), usuario.getSenha());
		
		if(usuarioLogado == null){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			map.addAttribute("erro", "Login ou senha inválidos!");
			return "login";
		}
		
		session.setAttribute("usuario", usuarioLogado);
		map.addAttribute("usuario", usuarioLogado);
		//return "redirect:/conta/listar";  //redireciona pela url, perde tudo
		return "redirect:/home";
	}
	
	@RequestMapping(value={"/logout"}, method=RequestMethod.GET)
	public String logout(ModelMap map, HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value={"/principal","/home"}, method=RequestMethod.GET)
	public String principal(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		//session.setAttribute("usuario", usuarioLogado);
		map.addAttribute("usuario", usuarioLogado);
		//return "redirect:/conta/listar";  //redireciona pela url, perde tudo
		return "principal";
	}
	

}
