package br.org.serratec.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioInserirDTO {

	private String nome;
	private String email;
	private String senha;
	
	
	
	public UsuarioInserirDTO() {
		// TODO Auto-generated constructor stub
	}



	public UsuarioInserirDTO(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
