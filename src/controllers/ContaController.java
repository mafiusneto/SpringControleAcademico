package controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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


import entities.Usuario;

@Controller
@RequestMapping(value="/conta")
public class ContaController {
	/*
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private TipoContaService tipoContaService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(ModelMap map){
		List<Conta> contas = contaService.listar();
		map.addAttribute("contas", contas);
		map.addAttribute("filtro", new Conta());
		return "conta/listar";
	}
	
	@RequestMapping(value="/filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Conta filtro, ModelMap map){
		List<Conta> contas = contaService.filtrar(filtro);
		map.addAttribute("contas", contas);
		map.addAttribute("filtro", filtro);
		return "conta/listar";
	}
	
	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String novo(ModelMap map){
		Conta conta = new Conta();
		conta.setTipoConta(new TipoConta());
		map.addAttribute("conta", conta);
		return "conta/novo";
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("conta") @Valid Conta conta, BindingResult resultados, ModelMap map, HttpSession session, RedirectAttributes attributes){
		if(resultados.hasErrors()){
			map.addAttribute("conta",conta);
			return "conta/novo";
		}
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		conta.setDataAbertura(new Date());
		conta.setUsuario(usuario);
		String mensagem="";
		if(conta.hasValidId()){
			contaService.atualizarConta(conta);
			attributes.addFlashAttribute("mensagem", "conta atualizada com sucesso");
			mensagem = "";
		}else{
			contaService.abreConta(conta);
			attributes.addFlashAttribute("mensagem","conta aberta com sucesso");
		}
		
		return "redirect:/conta/listar";
		
	}
	
	@RequestMapping(value="{id}/excluir" ,method= RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, ModelMap map ){
		contaService.excluirPorId(id);
		map.addAttribute("mensagem", "conta excluida com sucesso");
		return "forward:/conta/listar"; // repasse para o método listar
		//"redirect:/conta/listar"; redirecionamento para o metodo listar
		//"/conta/listar" repasse para listar.jsp que esta em WEB-INF/jsp/conta/listar.jsp
	}
	
	@RequestMapping(value="{id}/update" ,method= RequestMethod.GET)
	public String formUpdate(@PathVariable("id") Long id, ModelMap map){
		Conta conta = contaService.buscarContaPorId(id);
		map.addAttribute("conta", conta);
		return "/conta/novo"; // repasse para o método listar
		//"redirect:/conta/listar"; redirecionamento para o metodo listar
		//"/conta/listar" repasse para listar.jsp que esta em WEB-INF/jsp/conta/listar.jsp
	}
	
	
	@ModelAttribute("contasMap")
	public Map<Long, String> listarTiposContas(){
		List<TipoConta> tipoContas = tipoContaService.listar();
		Map<Long, String> contasMap = new TreeMap<Long, String>();
		for (TipoConta tipoConta : tipoContas) {
			contasMap.put(tipoConta.getId(), tipoConta.getNome());
		}
		return contasMap;
	}
	*/

		
}
