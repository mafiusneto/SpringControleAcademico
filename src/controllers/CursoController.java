package controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entities.Curso;
import entities.Usuario;
import services.CursoService;


@Controller
@RequestMapping(value="/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(value={"","/","/listar"}, method=RequestMethod.GET)
	public String lista(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		List<Curso> cursos = cursoService.lista();		
		map.addAttribute("cursos", cursos);
		
		return "curso/listar";
		
		//return "redirect:/curso/listar";  //redireciona pela url, perde tudo
		//return "forward:/curso/listar";  	//encaminha
		//return "curso/listar"				//normal
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String novo(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		Curso curso = new Curso();
		map.addAttribute("curso", curso);
		
		return "curso/novo";
	}
	
	@RequestMapping(value={"{id}/update"}, method=RequestMethod.GET)
	public String update(@PathVariable("id") Long id,ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);

		
		Curso curso = cursoService.buscaPorId(id);
		map.addAttribute("curso", curso);
		
		return "curso/novo";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("curso") @Valid Curso curso, BindingResult resultados, ModelMap map, HttpSession session, RedirectAttributes attributes){
		if(resultados.hasErrors()){
			map.addAttribute("curso",curso);
			return "curso/new";
		}
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		if(curso.hasValidId()){
			cursoService.atualizar(curso);
			attributes.addFlashAttribute("mensagem", "curso atualizado com sucesso");
			
		}else{
			cursoService.inserir(curso);
			attributes.addFlashAttribute("mensagem","curso inserido com sucesso");
			
		}
		
		return "redirect:/curso/";		
	}
	
	@RequestMapping(value="{id}/excluir" ,method= RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, ModelMap map ){
		cursoService.excluirPorId(id);
		map.addAttribute("mensagem", "curso excluido com sucesso");
		return "forward:/curso/";
	}
}
