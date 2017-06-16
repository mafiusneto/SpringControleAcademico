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

import entities.Disciplina;
import entities.Usuario;
import services.DisciplinaService;


@Controller
@RequestMapping(value="/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@RequestMapping(value={"","/","/listar"}, method=RequestMethod.GET)
	public String lista(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		List<Disciplina> disciplinas = disciplinaService.lista();		
		map.addAttribute("disciplinas", disciplinas);
		
		return "disciplina/listar";
		
		//return "redirect:/disciplina/listar";  //redireciona pela url, perde tudo
		//return "forward:/disciplina/listar";  	//encaminha
		//return "disciplina/listar"				//normal
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String novo(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		Disciplina disciplina = new Disciplina();
		map.addAttribute("disciplina", disciplina);
		
		return "disciplina/novo";
	}
	
	@RequestMapping(value={"{id}/update"}, method=RequestMethod.GET)
	public String update(@PathVariable("id") Long id,ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);

		
		Disciplina disciplina = disciplinaService.buscaPorId(id);
		map.addAttribute("disciplina", disciplina);
		
		return "disciplina/novo";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("disciplina") @Valid Disciplina disciplina, BindingResult resultados, ModelMap map, HttpSession session, RedirectAttributes attributes){
		if(resultados.hasErrors()){
			map.addAttribute("disciplina",disciplina);
			return "disciplina/new";
		}
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		if(disciplina.hasValidId()){
			disciplinaService.atualizar(disciplina);
			attributes.addFlashAttribute("mensagem", "disciplina atualizado com sucesso");
			
		}else{
			disciplinaService.inserir(disciplina);
			attributes.addFlashAttribute("mensagem","disciplina inserido com sucesso");
			
		}
		
		return "redirect:/disciplina/";		
	}
	
	@RequestMapping(value="{id}/excluir" ,method= RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, ModelMap map ){
		disciplinaService.excluirPorId(id);
		map.addAttribute("mensagem", "disciplina excluida com sucesso");
		return "forward:/disciplina/";
	}
}
