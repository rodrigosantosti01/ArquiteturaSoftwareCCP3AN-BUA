package br.usjt.arqsw18.pipoca.model.entity;

import java.util.ArrayList;

import antlr.collections.List;

public class Genero {
	private int id;
	private String nome;
	private ArrayList<Filme> filmes;
	
	public ArrayList<Filme> getFilmes() {
		return filmes;
	}
	public void setFilmes(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		return "Genero [id=" + id + ", nome=" + nome + "]";
	}
	
}
