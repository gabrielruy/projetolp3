package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservaDAO {
	
	private static Connection connection;
	
	public ReservaDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public static Boolean create(Reserva r) {
		
		Boolean state = false;
		
		/* Foi necessário abrir a conexão neste método pois a IDE não estava reconhecendo o Path da mesma */
		connection = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO Reserva (id_livro, id_aluno, data_retirada, data_devolucao, tipo, ativo) " +
				"VALUES (?, ?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, r.getLivro().getId());
			stmt.setInt(2, r.getAluno().getId());
			
			Date retirada = convertToDate(r.getDataRetirada()); 
			Date devolucao = convertToDate(r.getDataDevolucao()); 
			
			stmt.setDate(3, retirada);
			stmt.setDate(4, devolucao);
			stmt.setString(5, r.getTipo());
			stmt.setBoolean(6, r.getAtivo());
			
			stmt.execute();
			stmt.close();
			
			state = true;
			
		} catch (SQLException e) {
			InfoAlert.errorAlert("Erro.", "Erro ao cadastrar o empréstimo. \nLog de erro: " + e);
		}		
		return state;
	}
	
	private static Date convertToDate(LocalDate locDate) {
		return (locDate == null ? null : Date.valueOf(locDate));
	}
}
