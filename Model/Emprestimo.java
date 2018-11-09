package Model;

import java.util.Date;

public class Emprestimo {

	private Livro livro;
	private Aluno aluno;
	private Date dataDevolucao;
	private Date dataEmprestimo;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Aluno getUsuario() {
		return aluno;
	}
	public void setUsuario(Aluno aluno) {
		this.aluno = aluno;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
}
