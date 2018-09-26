package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;

@Controller
public class ManterFilmesController {
	private FilmeService fService;
	private GeneroService gService;
	
	@Autowired    // ponto onde sera injetado dependencias
	public ManterFilmesController(FilmeService fs, GeneroService gs) {
		fService = fs;
		gService = gs;
	}

	@RequestMapping("/home")
	public String iniciar() {
		return "Home";
	}
	
	@RequestMapping("/novo_filme")
	public String novo(Model model,HttpSession session) {
		try {
			ArrayList<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	@RequestMapping("/editar_filme/{id}")
	public String editarFilme(@PathVariable Integer id,Filme filme,Model model,BindingResult errors) throws IOException {
			filme = fService.buscarFilme(id);
			ArrayList<Genero> generos = gService.listarGeneros();
			model.addAttribute("filme",filme);
			model.addAttribute("generos",generos);
			return "EditarFilme";
	}
	
	
	@RequestMapping("/atualizar")
	public String atualizarFilme(Filme filme,Model model) throws IOException {
		fService.updateFilme(filme);
		filme = fService.buscarFilme(filme.getId());
		System.out.println(filme);
		model.addAttribute("Filme",filme);
		return "redirect:/visualizar_filme/"+ filme.getId();
		
	}
	
	@RequestMapping("/excluir_filme")
	public String excluirFilme(Integer id) throws IOException {
		fService.excluirFilme(id);
		return "redirect:/listar_filmes";
	}
	
	@RequestMapping("/criar_filme")
	public String criarFilme(@Valid Filme filme, BindingResult erros, Model model) {
		
		try {
			if(!erros.hasErrors()) {
			Genero genero = new Genero();
			genero.setId(filme.getGenero().getId());
			genero.setNome(gService.buscarGenero(genero.getId()).getNome());
			filme.setGenero(genero);
			filme = fService.inserirFilme(filme);
			model.addAttribute("filme", filme);
			return "VisualizarFilme";
			
			}else {
				return "CriarFilme";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/reiniciar_lista")
	public String reiniciarLista(HttpSession session) {
		session.setAttribute("lista", null);
		return "ListarFilmes";
	}
	
	@RequestMapping("/visualizar_filme/{id}")
	public String visualizarLista(@PathVariable Integer id,Filme filme, Model model) throws IOException {
		filme = fService.buscarFilme(id);
		model.addAttribute("filme",filme);
		return "VisualizarFilme";
	}
	
	

	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session, Model model, String chave) {
		try {
			//HttpSession session = ((HttpServletRequest) model).getSession();

			ArrayList<Filme> lista;
			if (chave != null && chave.length() > 0) {
				lista = fService.listarFilmes(chave);
			} else {
				lista = fService.listarFilmes();
			}
			session.setAttribute("lista", lista);
			return "ListarFilmes";
			
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/generos")
	public String porGeneros(Model model) throws IOException {
		ArrayList <Genero> porGeneros = gService.listaGenFilmes();
		model.addAttribute("porGeneros",porGeneros);
		return "Generos";
	}
	
	@RequestMapping("/popularidade")
	public String porPopularidade(Model model) throws IOException {
		ArrayList<Filme> filmes1 = fService.listarPopulares(0,30);
		ArrayList<Filme> filmes2 = fService.listarPopulares(31,50);
		ArrayList<Filme> filmes3 = fService.listarPopulares(51,60);
		ArrayList<Filme> filmes4 = fService.listarPopulares(61,80);
		ArrayList<Filme> filmes5 = fService.listarPopulares(81,100);
		model.addAttribute("filmes1",filmes1);
		model.addAttribute("filmes2",filmes2);
		model.addAttribute("filmes3",filmes3);
		model.addAttribute("filmes4",filmes4);
		model.addAttribute("filmes5",filmes5);
		return "Popularidade";
	}
	
	@RequestMapping("/dtLancamentos")
	public String porDtLancamento(Model model) throws IOException {
		
		ArrayList<Filme> filmesAno = fService.porData("ano",1);
		
		ArrayList<Filme> filmesPenultimo = fService.porData("ano",2);
		ArrayList<Filme> filmesMes = fService.porData("mes",1);
		model.addAttribute("filmesAno",filmesAno);
		model.addAttribute("filmesMes",filmesMes);
		model.addAttribute("filmesPenultimo",filmesPenultimo);
		return "DataLancamento";
	}
}
