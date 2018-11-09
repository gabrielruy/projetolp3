package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class FXMLTelaConfigController {

	@FXML
	private Menu mnAluno;
	@FXML
	private MenuItem mnCadastrarAluno;
	@FXML
	private MenuItem mnBuscarAluno;
	@FXML
	private Menu mnLivros;
	@FXML
	private MenuItem mnCadastrarLivro;
	@FXML
	private MenuItem mnBuscarLivros;
	@FXML
	private Menu mnEmprestimo;
	@FXML
	private MenuItem mnEmpLivro;
	@FXML
	private MenuItem mnBuscarEmp;
	@FXML
	private Menu mnReserva;
	@FXML
	private MenuItem mnFazerReserva;
	@FXML
	private MenuItem mnBuscarReserva;
	@FXML
	private Menu mnSair;
	@FXML
    private Text txtAux;

	// Menu: Sair
	@FXML
	void sair() throws IOException {
		Stage stage = (Stage) txtAux.getScene().getWindow();
		stage.close();
	}

	// Menu: Cadastrar Aluno
	@FXML
	void cadAluno() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaCadastroUsuario.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaCadastroUsuarioController controller = (Controller.FXMLTelaCadastroUsuarioController) loader.getController();
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Cadastro de Aluno");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Buscar Aluno
	@FXML
	void buscarAluno() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarUsuario.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaBuscarUsuarioController controller = (Controller.FXMLTelaBuscarUsuarioController) loader.getController();
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Buscar de Aluno");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Cadastrar Livro
	@FXML
	void cadLivro() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaCadastroLivro.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaCadastroLivroController controller = (Controller.FXMLTelaCadastroLivroController) loader.getController();
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Cadastrar de Livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Buscar Livro
	@FXML
	void buscarLivro() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarLivro.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaBuscarLivroController controller = (Controller.FXMLTelaBuscarLivroController) loader.getController();
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Buscar de Livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Emprestar Livro
	@FXML
	void empLivro() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaEmprestimo.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaEmprestimoController controller = (Controller.FXMLTelaEmprestimoController) loader.getController();
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Emprestimo de livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Buscar Empréstimo
	@FXML
	void buscarEmprestimo() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarEmprestimo.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaEmprestimoController controller = (Controller.FXMLTelaEmprestimoController) loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Listar livros emprestados");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Fazer Reserva
	@FXML
	void fazReserva() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaReserva.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaReservaController controller = (Controller.FXMLTelaReservaController) loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Fazer reserva de livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Buscar Reserva
	@FXML
	void buscarReserva() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaReserva.fxml"));
		Pane root = loader.load();
		
		//Controller.FXMLTelaReservaController controller = (Controller.FXMLTelaReservaController) loader.getController();
	
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("Livros reservados");
		stage.setScene(scene);
		stage.show();
	}

}
