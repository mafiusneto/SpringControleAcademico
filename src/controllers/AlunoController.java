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

import entities.Aluno;
import entities.Usuario;
import services.AlunoService;


@Controller
@RequestMapping(value="/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	//@Autowired
	//private AlunoService alunoService;
	
	
	@RequestMapping(value={"","/","/listar"}, method=RequestMethod.GET)
	public String lista(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		List<Aluno> alunos = alunoService.lista();		
		map.addAttribute("alunos", alunos);
		
		return "aluno/listar";
		
		//return "redirect:/aluno/listar";  //redireciona pela url, perde tudo
		//return "forward:/aluno/listar";  	//encaminha
		//return "aluno/listar"				//normal
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String novo(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		Aluno aluno = new Aluno();
		map.addAttribute("aluno", aluno);
		
		
		
		return "aluno/novo";
	}
	
	@RequestMapping(value={"{id}/update"}, method=RequestMethod.GET)
	public String update(@PathVariable("id") Long id,ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);

		
		Aluno aluno = alunoService.buscaPorId(id);
		map.addAttribute("aluno", aluno);
		
		return "aluno/novo";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("aluno") @Valid Aluno aluno, BindingResult resultados, ModelMap map, HttpSession session, RedirectAttributes attributes){
		if(resultados.hasErrors()){
			map.addAttribute("aluno",aluno);
			return "aluno/new";
		}
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		if(aluno.hasValidId()){
			alunoService.atualizar(aluno);
			attributes.addFlashAttribute("mensagem", "aluno atualizado com sucesso");
			
		}else{
			alunoService.inserir(aluno);
			attributes.addFlashAttribute("mensagem","aluno inserido com sucesso");
			
		}
		
		return "redirect:/aluno/";		
	}
	
	@RequestMapping(value="{id}/excluir" ,method= RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, ModelMap map ){
		alunoService.excluirPorId(id);
		map.addAttribute("mensagem", "aluno excluida com sucesso");
		return "forward:/aluno/";
	}
}
