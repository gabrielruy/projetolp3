package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {
	
	private Connection connection;
	
	public AlunoDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public Boolean create(Aluno a) {
		
		Boolean state = false;
		
		String sql = "INSERT INTO Aluno (nome, rg, cpf, email, telefone, logradouro, numero, cep, bairro, cidade, estado) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getRg());
			stmt.setString(3, a.getCpf());
			stmt.setString(4, a.getEmail());
			stmt.setString(5, a.getTelefone());
			stmt.setString(6, a.getLogradouro());
			stmt.setInt(7, a.getNumero());
			stmt.setString(8, a.getCep());
			stmt.setString(9, a.getBairro());
			stmt.setString(10, a.getCidade());
			stmt.setString(11, a.getEstado());
			
			stmt.execute();
			stmt.close();
			
			state = true;
			
		} catch (SQLException e) {
			if (e.getMessage().toString().contains("UN_ALUNO_CPF")) 
				InfoAlert.errorAlert("Erro ao cadastrar", "O CPF informado já está cadastrado.");
			
			/* State settado como TRUE aqui para haver maior controle de erro.
			   O erro acima só será exibido em caso de CPF duplicado. Em outros casos o erro será genérico. */
			state = true;
		}		
		return state;
	}
}
