package Model;

import java.util.Date;

public class Livro {
	
	private String nome;
	private Integer id;
	private String autor;
	private Date publicacao;
	private String editora;
	private Integer nroEdicao;
	private String isbn;
	private Boolean emprestado;
	private Boolean reservado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Integer getNroEdicao() {
		return nroEdicao;
	}
	public void setNroEdicao(Integer nroEdicao) {
		this.nroEdicao = nroEdicao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Boolean getEmprestado() {
		return emprestado;
	}
	public void setEmprestado(Boolean emprestado) {
		this.emprestado = emprestado;
	}
	public Boolean getReservado() {
		return reservado;
	}
	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}
}
