package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class controllerTest {

    @FXML
    private Button bntClose;

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) bntClose.getScene().getWindow();
		stage.close();

    }



	/*@FXML
	public void fechar() {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}*/
}
