package controllers;

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
import entities.Professor;
import entities.Turma;
import entities.Usuario;
import services.DisciplinaService;
import services.ProfessorService;
import services.TurmaService;


@Controller
@RequestMapping(value="/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	
	@RequestMapping(value={"","/","/listar"}, method=RequestMethod.GET)
	public String lista(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		List<Turma> turmas = turmaService.lista();		
		map.addAttribute("turmas", turmas);
		
		return "turma/listar";
		
		//return "redirect:/turma/listar";  //redireciona pela url, perde tudo
		//return "forward:/turma/listar";  	//encaminha
		//return "turma/listar"				//normal
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String novo(ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		Turma turma = new Turma();
		turma.setProfessor(null);
		map.addAttribute("turma", turma);
		
		List<Professor> professores = professorService.lista();
		map.addAttribute("professores", professores);
		
		List<Disciplina> disciplinas = disciplinaService.lista();
		map.addAttribute("disciplinas", disciplinas);
		
		
		return "turma/novo";
	}
	
	@RequestMapping(value={"{id}/update"}, method=RequestMethod.GET)
	public String update(@PathVariable("id") Long id,ModelMap map, HttpSession session){
				
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);

		
		Turma turma = turmaService.buscaPorId(id);
		map.addAttribute("turma", turma);
		
		List<Professor> professores = professorService.lista();
		map.addAttribute("professores", professores);
		
		List<Disciplina> disciplinas = disciplinaService.lista();
		map.addAttribute("disciplinas", disciplinas);
		
		return "turma/novo";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("turma") @Valid Turma turma, String profId, String disciplinaId, BindingResult resultados, ModelMap map, HttpSession session, RedirectAttributes attributes){
		if(resultados.hasErrors()){
			map.addAttribute("turma",turma);
			map.addAttribute("erro","erro no objeto!");
			return "turma/novo";
		}
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		map.addAttribute("usuario", usuarioLogado);
		
		Professor prof = professorService.buscaPorId(Long.parseLong(profId));
		if(prof != null){
			turma.setProfessor(prof);
		}
		
		Disciplina disciplina = disciplinaService.buscaPorId(Long.parseLong(disciplinaId));
		if(disciplina != null){
			turma.setDisciplina(disciplina);
		}
		
		if(turma.hasValidId()){
			turmaService.atualizar(turma);
			attributes.addFlashAttribute("mensagem", "turma atualizado com sucesso");
			
		}else{
			turmaService.inserir(turma);
			attributes.addFlashAttribute("mensagem","turma inserido com sucesso");
			
		}
		
		return "redirect:/turma/";		
	}
	
	@RequestMapping(value="{id}/excluir" ,method= RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, ModelMap map ){
		turmaService.excluirPorId(id);
		map.addAttribute("mensagem", "turma excluida com sucesso");
		return "forward:/turma/";
	}
}
