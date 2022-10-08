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
				System.out.println("POP UP0");
			}
		}

		if ((songField.getText() == null || songField.getText().trim().isEmpty())
				|| (artistField.getText() == null || artistField.getText().trim().isEmpty())) {
			System.out.println("POP UP1");
			// checks if year is less than 0
		} else if (yearField.getText().trim().isEmpty() == false && Integer.parseInt(yearField.getText().trim()) <= 0) {
			System.out.println("POP UP2");
			// checks if | character is in album/song/artist name
		} else if (artistField.getText().indexOf('|') != -1
				|| ((albumField.getText() == null || albumField.getText().trim().isEmpty()) == false
						&& albumField.getText().indexOf('|') != -1)
				|| songField.getText().indexOf('|') != -1) {
			System.out.println("POP UP3");
			// adds song to list
		} else {
			Song toAdd;
			if ((albumField.getText() == null || albumField.getText().trim().isEmpty())
					&& (yearField.getText() == null || yearField.getText().trim().isEmpty())) {
				String song = songField.getText().trim();
				String artist = artistField.getText().trim();
				toAdd = new Song(song, artist);
			} else if (albumField.getText() == null || albumField.getText().trim().isEmpty()) {
				String song = songField.getText().trim();
				String artist = artistField.getText().trim();
				int year = Integer.parseInt(yearField.getText().trim());
				toAdd = new Song(song, artist, year);
			} else if (yearField.getText() == null || yearField.getText().trim().isEmpty()) {
				String song = songField.getText().trim();
				String artist = artistField.getText().trim();
				String album = albumField.getText().trim();
				toAdd = new Song(song, artist, album);
			} else {
				String song = songField.getText().trim();
				String artist = artistField.getText().trim();
				String album = albumField.getText().trim();
				int year = Integer.parseInt(yearField.getText().trim());
				toAdd = new Song(song, artist, album, year);
			}

			if (HomeScreenController.checkElement(toAdd) == true) {
				System.out.println("Already in list (popup)");
			} else {
				HomeScreenController.editElement(editSong, toAdd);
				Parent root = FXMLLoader.load(getClass().getResource("homeScreenfx.fxml"));
				stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}

		}

	}
}