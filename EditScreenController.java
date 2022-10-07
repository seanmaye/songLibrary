package songlibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditScreenController {

	@FXML
	private Label label;
	@FXML
	private TextField songField;
	@FXML
	private TextField albumField;
	@FXML
	private TextField yearField;
	@FXML
	private TextField artistField;
	private Scene scene;
	private Stage stage;
	private Parent root;
	private Song editSong;

	public void initialize() {
		editSong = HomeScreenController.getPassSong();
		songField.setText(editSong.getName());
		albumField.setText(editSong.getAlbum());
		artistField.setText(editSong.getArtist());
		yearField.setText(Integer.toString(editSong.getYear()));

	}

	// Switches back to main screen
	public void confirm(ActionEvent e) throws IOException {
		String song = songField.getText();
		String album = albumField.getText();
		String artist = artistField.getText();
		int year;
		// try{
		year = Integer.parseInt(yearField.getText());
		// } catch(NumberFormatException ex){ // handle your exception

		// }

		Song toAdd = new Song(song, artist, album, year);
		HomeScreenController.editElement(editSong, toAdd);

		Parent root = FXMLLoader.load(getClass().getResource("homeScreenfx.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}