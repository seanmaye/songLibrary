package songlibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
		artistField.setText(editSong.getArtist());
		albumField.setText(editSong.getAlbum());
		if (editSong.getYear() != 0) {
			yearField.setText(Integer.toString(editSong.getYear()));
		}
	}

	// Switches back to main screen

	public void confirm(ActionEvent e) throws IOException {
		int intTest;
		// tests if Input to year is an integer
		if (yearField.getText().trim().isEmpty() == false) {
			try {
				intTest = Integer.parseInt(yearField.getText());
				// Checks if Song or album field are empty
			} catch (NumberFormatException ex) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setContentText("Year must be a POSITIVE integer");
				alert.showAndWait();
			}
		}
		if ((songField.getText() == null || songField.getText().trim().isEmpty())
				|| (artistField.getText() == null || artistField.getText().trim().isEmpty())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Song needs at least a NAME and a ARTIST");
			alert.showAndWait();
			// checks if year is less than 0
		} else if (yearField.getText().trim().isEmpty() == false && Integer.parseInt(yearField.getText().trim()) <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Year must be a POSITIVE integer");
			alert.showAndWait();
			// checks if | character is in album/song/artist name
		} else if (artistField.getText().indexOf('|') != -1
				|| ((albumField.getText() == null || albumField.getText().trim().isEmpty()) == false
						&& albumField.getText().indexOf('|') != -1)
				|| songField.getText().indexOf('|') != -1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("Invalid character: | ");
			alert.showAndWait();
			// adds song to list
		} else {
			if ((albumField.getText() == null || albumField.getText().trim().isEmpty())
					&& (yearField.getText() == null || yearField.getText().trim().isEmpty())) {
				editSong.editName(songField.getText().trim());
				editSong.editArtist(artistField.getText().trim());
				editSong.editAlbum(null);
			} else if (albumField.getText() == null || albumField.getText().trim().isEmpty()) {
				editSong.editName(songField.getText().trim());
				editSong.editArtist(artistField.getText().trim());
				editSong.editAlbum(null);
				editSong.editYear(Integer.parseInt(yearField.getText().trim()));
			} else if (yearField.getText() == null || yearField.getText().trim().isEmpty()) {
				editSong.editName(songField.getText().trim());
				editSong.editArtist(artistField.getText().trim());
				editSong.editAlbum(albumField.getText().trim());
				editSong.editYear(0);
			} else {
				editSong.editName(songField.getText().trim());
				editSong.editArtist(artistField.getText().trim());
				editSong.editAlbum(albumField.getText().trim());
				editSong.editYear(Integer.parseInt(yearField.getText().trim()));
			}

			if (HomeScreenController.checkElementEdit(editSong) == true) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setContentText("Song is already in list!");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm Edit");
				alert.setContentText("Press OK to add edited song to the list");

				Optional<ButtonType> result = alert.showAndWait();

				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
					HomeScreenController.setPassSong(editSong);
					Parent root = FXMLLoader.load(getClass().getResource("homeScreenfx.fxml"));
					stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}
			}
		}
	}
}