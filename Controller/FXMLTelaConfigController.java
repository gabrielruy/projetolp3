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
    private Menu mnRelatórios;
    @FXML
    private MenuItem mnRelatorioQuitacao;
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

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Cadastro de Aluno");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Gerenciar Aluno
	@FXML
	void buscarAluno() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarUsuario.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Gerenciamento de Aluno");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Cadastrar Livro
	@FXML
	void cadLivro() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaCadastroLivro.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Cadastro de Livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Gerenciar Livro
	@FXML
	void buscarLivro() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarLivro.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Gerenciamento de Livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Emprestar Livro
	@FXML
	void empLivro() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaEmprestimo.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Empréstimo de Livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Baixa de Empréstimo
	@FXML
	void buscarEmprestimo() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarEmprestimo.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Baixa de Empréstimo");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Fazer Reserva
	@FXML
	void fazReserva() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaReserva.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Reserva de Livro");
		stage.setScene(scene);
		stage.show();
	}

	// Menu: Baixa de Reserva
	@FXML
	void buscarReserva() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaBuscarReserva.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Baixa de Reserva");
		stage.setScene(scene);
		stage.show();
	}
	
	//Menu: Relatório de Quitação
	@FXML
    void relatorioQuitacao() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLTelaRelatorioQuitacao.fxml"));
		Pane root = loader.load();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		stage.setResizable(false);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(txtAux.getScene().getWindow());
		stage.setTitle("BIBLIOTECA UNIVERSITÁRIA - Relatório de Quitação");
		stage.setScene(scene);
		stage.show();
    }

}
