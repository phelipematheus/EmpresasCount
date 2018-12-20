package br.com.empresasController.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.empresasCount.model.Funcionario;

@Controller
public class FuncionarioService {

	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public ModelAndView funcionario() {
		return new ModelAndView("funcionario", "command", new Funcionario());
	}

	@RequestMapping(value = "/addFuncionario", method = RequestMethod.POST)
	public String adicionarFuncionario(
		@ModelAttribute("SpringWeb") Funcionario funcionario, ModelMap model, HttpServlet request) {
			
		model.addAttribute("CPF", funcionario.getCPF());
		model.addAttribute("nome", funcionario.getNome());
		model.addAttribute("eMail", funcionario.geteMail());
		
//		List<Funcionario> funcionarios = (List<Funcionario>) request.getSession().getAttribute("clientes")
//		if (funcionarios == null) {
//		      funcionarios = new ArrayList<Funcionario>();
//		   } 
//		   funcionarios.add(funcionario);
//		   request.getSession().setAttribute("clientes", funcionario);
				
		return "Phelipe";
	}

	@RequestMapping(value = "/listaFuncionarios", method = RequestMethod.GET)
	public String listarFuncionarios(@ModelAttribute("SpringWeb") ModelMap model, HttpServletRequest request) {

		List<Funcionario> clientes = (List<Funcionario>) request.getAttribute("funcionarios");

		model.addAttribute("funcionarios", clientes);

		return "listaFuncionarios";
	}

}
