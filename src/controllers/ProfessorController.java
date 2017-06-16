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

import entities.Professor;
import entities.Usuario;
import services.ProfessorService;


@Controller
@RequestMapping(value="/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	//@Autowired
	//private ProfessorService professorService;
	
	
	@RequestMapping(value={"","/","/listar"}, method=RequestMethod.GET)
	public String lista(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		List<Professor> professores = professorService.lista();		
		map.addAttribute("professores", professores);
		
		return "professor/listar";
		
		//return "redirect:/professor/listar";  //redireciona pela url, perde tudo
		//return "forward:/professor/listar";  	//encaminha
		//return "professor/listar"				//normal
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String novo(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		Professor professor = new Professor();
		map.addAttribute("professor", professor);
		
		
		
		return "professor/novo";
	}
	
	@RequestMapping(value={"{id}/update"}, method=RequestMethod.GET)
	public String update(@PathVariable("id") Long id,ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);

		
		Professor professor = professorService.buscaPorId(id);
		map.addAttribute("professor", professor);
		
		return "professor/novo";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("professor") @Valid Professor professor, BindingResult resultados, ModelMap map, HttpSession session, RedirectAttributes attributes){
		if(resultados.hasErrors()){
			map.addAttribute("professor",professor);
			return "professor/new";
		}
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		if(professor.hasValidId()){
			professorService.atualizar(professor);
			attributes.addFlashAttribute("mensagem", "professor atualizado com sucesso");
			
		}else{
			professorService.inserir(professor);
			attributes.addFlashAttribute("mensagem","professor inserido com sucesso");
			
		}
		
		return "redirect:/professor/";		
	}
	
	@RequestMapping(value="{id}/excluir" ,method= RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, ModelMap map ){
		professorService.excluirPorId(id);
		map.addAttribute("mensagem", "professor excluida com sucesso");
		return "forward:/professor/";
	}
}
