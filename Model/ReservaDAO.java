package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	@SuppressWarnings("null")
	public static Reserva read (Integer codLivro) throws SQLException {
		
		/* Foi necessário abrir a conexão neste método pois a IDE não estava reconhecendo o Path da mesma */
		connection = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		Reserva reserva = new Reserva();
		reserva.setAluno(new Aluno());
		reserva.setLivro(new Livro());

		try {
			
			String sql = "SELECT r.id, r.id_livro, l.nome as nome_livro, l.autor, r.id_aluno, a.nome as nome_aluno, a.ra, r.data_retirada, r.data_devolucao" + 
					" from Aluno a INNER JOIN Reserva r ON a.id = r.id_aluno" + 
					" INNER JOIN Livro l ON r.id_livro = l.id" + 
					" WHERE l.id = ?";
			
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codLivro);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Reserva r = new Reserva();
				r.setAluno(new Aluno());
				r.setLivro(new Livro());
				
				r.setId(rs.getInt("id"));
				r.getLivro().setId(rs.getInt("id_livro"));
				r.getLivro().setNome(rs.getString("nome_livro"));
				r.getLivro().setAutor(rs.getString("autor"));
				r.getAluno().setId(rs.getInt("id_aluno"));
				r.getAluno().setNome(rs.getString("nome_aluno"));
				r.getAluno().setRa(rs.getInt("ra"));
				r.setDataRetirada(rs.getDate("data_retirada").toLocalDate());
				
				if(rs.getDate("data_devolucao") != null) {
					r.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
				}
				
				reserva = r;
			}			
		} catch (SQLException e) {
			InfoAlert.errorAlert("Erro.", "Erro ao consultar reserva. \nLog de erro: " + e);
		} finally {
			stmt.close();
		}
		
		return reserva;
	}
	
	public static Boolean update(Reserva r) {
		
		Boolean state = false;
		
		String sql = "UPDATE Reserva SET data_devolucao = ?, tipo = ?, ativo = ? WHERE id = ?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			Date devolucao = convertToDate(r.getDataDevolucao()); 
			
			stmt.setDate(1, devolucao);
			stmt.setString(2, r.getTipo());
			stmt.setBoolean(3, r.getAtivo());
			stmt.setInt(4, r.getId());
						
			stmt.execute();
			stmt.close();
			
			state = true;
			
		} catch (SQLException e) {
			InfoAlert.errorAlert("Erro.", "Erro atualizar a reserva/empréstimo. \nLog de erro: " + e);;
		}
		return state;
	}
	
	public static Boolean delete(Reserva r) throws SQLException {
		
		Boolean state = false;
		
		String sql = "DELETE FROM Reserva WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		try {						
			stmt.setInt(1, r.getId());
			stmt.execute();
			stmt.close();
			state = true;
		} catch (SQLException e) {
			InfoAlert.errorAlert("Erro.", "Erro excluir a reserva. \nLog de erro: " + e);
		} 
		
		return state;
	}
	
	private static Date convertToDate(LocalDate locDate) {
		return (locDate == null ? null : Date.valueOf(locDate));
	}
}
