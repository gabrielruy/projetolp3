package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class LivroDAO {

private Connection connection;
	
	public LivroDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public Boolean create(Livro l) {
		
		Boolean state = false;
		
		String sql = "INSERT INTO Livro (nome, autor, publicacao, editora, nro_edicao, isbn, situacao, reservado) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, l.getNome());
			stmt.setString(2, l.getAutor());
			
			Date publicacao = convertToEntityDate(l.getPublicacao()); 
			
			stmt.setDate(3, publicacao);
			stmt.setString(4, l.getEditora());
			stmt.setInt(5, l.getNroEdicao());
			stmt.setString(6, l.getIsbn());
			stmt.setString(7, l.getSituacao());
			stmt.setBoolean(8, l.getReservado());
			
			stmt.execute();
			stmt.close();
			
			state = true;
			
		} catch (SQLException e) {
			/* Não há um erro específico para Livro, portanto, teremos uma mensagem genérica para erro ao inserir no BD */
			InfoAlert.errorAlert("Erro ao cadastrar", "Não foi possível adicionar ao banco de dados.");
			
			state = true;
		}		
		return state;
	}
	
	private Date convertToEntityDate(LocalDate locDate) {
		return (locDate == null ? null : Date.valueOf(locDate));
	}
}
