package songlibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EditScreenController {

	@FXML
	private Label label;
	private Scene scene;
	private Stage stage;
	private Parent root;

	
	//Switches back to main screen
	public void confirm(ActionEvent e) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("homeScreenfx.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}