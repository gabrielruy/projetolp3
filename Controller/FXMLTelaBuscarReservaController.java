package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Livro;
import Model.LivroDAO;
import Model.Reserva;
import Model.ReservaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLTelaBuscarReservaController implements Initializable {

    @FXML
    private Button btnBuscar;
    @FXML
    private TextField txtBuscarReserva;
    @FXML
    private Button btnCancelarReserva;
    @FXML
    private Button btnEfetivarReserva;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblNomeLivro;
    @FXML
    private Label lblNomeAutor;
    @FXML
    private Label lblRaAluno;
    @FXML
    private Label lblNomeAluno;
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblDataRetirada;
    @FXML
    private DatePicker dateDevolucao;
    
    @FXML
    private TableView<Livro> grdBuscarReserva;
    @FXML
    private TableColumn<Livro, Integer> clmnId;
    @FXML
    private TableColumn<Livro, String> clmnNome;
    @FXML
    private TableColumn<Livro, String> clmnAutor;
    @FXML
    private TableColumn<Livro, Integer> clmnEdicao;

    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {       	
       	try {
   			populaTabela(null);
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
    }
    
    @FXML
    private void voltar() {
    	fechaStage();
    }
    
    @FXML
    private void buscar() throws SQLException {
    	if(txtBuscarReserva.getText().trim().isEmpty()) {
			populaTabela(null);
		} else {
			populaTabela(txtBuscarReserva.getText());
		}
    }

    @FXML
    private void cancelar() {

    }

    @FXML
    private void cancelarReserva() {

    }

    @FXML
    private void efetivarReserva() {

    }
    
    @FXML
    private void tableSelect(MouseEvent event) throws SQLException {
    	exibeReserva();
    }
    
    private void populaTabela(String filtro) throws SQLException {
		ObservableList<Livro> list = FXCollections.observableArrayList();
		
		grdBuscarReserva.getItems().removeAll(grdBuscarReserva.getItems());
		
		if	(filtro == null) {
			try {
				list = LivroDAO.listBySituation("Reservado", null);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} else {
			list = LivroDAO.listBySituation("Reservado", txtBuscarReserva.getText().toString());
		}
				
		clmnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		clmnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		clmnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		clmnEdicao.setCellValueFactory(new PropertyValueFactory<>("nroEdicao"));
		
		grdBuscarReserva.setItems(list);
	}
    
    private void exibeReserva() throws SQLException {
		Livro l = grdBuscarReserva.getSelectionModel().getSelectedItem();
		
		setDTO(l);
	}
    
    private void setDTO(Livro l) throws SQLException {
    	Reserva r = ReservaDAO.read(l.getId());
    	lblNomeLivro.setText(r.getLivro().getNome());
    	lblNomeAutor.setText(r.getLivro().getAutor());
    	lblNomeAluno.setText(r.getAluno().getNome());
    	lblRaAluno.setText(r.getAluno().getRa().toString());
    	lblDataRetirada.setText(r.getDataRetirada().toString());
	}

    private void fechaStage() {
    	Stage stage = (Stage) txtBuscarReserva.getScene().getWindow();
		stage.close();
    }
}
