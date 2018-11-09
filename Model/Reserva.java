package Model;

import java.util.Date;

public class Reserva {

	private Livro livro;
	private Aluno aluno;
	private Date dataRetirada;
	
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
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
}
