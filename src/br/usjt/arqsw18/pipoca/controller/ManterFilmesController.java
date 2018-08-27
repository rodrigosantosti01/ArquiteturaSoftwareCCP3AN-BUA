package br.usjt.arqsw18.pipoca.controller;

import javax.xml.ws.ServiceMode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;

@Controller
public class ManterFilmesController {
	private FilmeService filmeService;
	public ManterFilmesController() {
		filmeService = new FilmeService();
	}
	
	@RequestMapping("/novo")
	public String novoFilme() {
		return "NovoFilme";
	}
	@RequestMapping("/inserir")
	public ModelAndView inserirFilme(@ModelAttribute("filme") Filme filme) {
		ModelAndView andView = new ModelAndView("Resultado");
		andView.addObject("filme",filme);
;		return andView;
	}
}
