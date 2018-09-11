package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;

import javax.xml.ws.ServiceMode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;
import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;

@Controller
public class ManterFilmesController {
	private FilmeService filmeService;
	private GeneroService generoService;
	
	
	
	public ManterFilmesController() {
		filmeService = new FilmeService();
		generoService = new GeneroService();
	}
	
	@RequestMapping("/novo")
	public String novoFilme(Mode model) {
		try 
		{
			ArrayList<Genero> generos = generoService.listarGeneros();
			model.addAttribute("generos",generos);
			return "NovoFilme";
		}
		
		
		return "NovoFilme";
	}
	
	@RequestMapping("/inserir")
	public ModelAndView inserirFilme(@ModelAttribute("filme") @Valid Filme filme) {
		
		ModelAndView andView = new ModelAndView("Resultado");
		andView.addObject("filme",filme);
		return andView;
		
	}
	
//	@RequestMapping("/inserir")
//	public String inserirFilme(@Valid Filme filme, Model model) {
//		try {
//			filme = filmeService.inserirFilme(filme);
//			model.addAttribute("filme",filme);
//			return "Resultado";
//			}
//			catch (IOException e ){
//				e.printStackTrace();
//				model.addAttribute("erro",e);
//				return "erro";
//		}
//	}
}
