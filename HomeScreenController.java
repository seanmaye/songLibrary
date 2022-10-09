package songlibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeScreenController {

	@FXML
	private Label label;
	@FXML
	private Button addButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	@FXML
	private ListView<Song> listView;
	@FXML
	private TextField songText;
	@FXML
	private TextField artistText;
	@FXML
	private TextField albumYearText;

	private static ObservableList<Song> list = FXCollections.observableArrayList();
	private Scene scene;
	private Stage stage;
	private Parent root;
	private static Song passSong;

	public void initialize() {
		// Sorts List Alphabetically First by Song Name then by Artist Name
		Collections.sort(list, Comparator.comparing(Song::getName, String.CASE_INSENSITIVE_ORDER)
				.thenComparing(Song::getArtist, String.CASE_INSENSITIVE_ORDER));
		listView.setItems(list);

		// Sets our information display to be un-editable
		songText.setEditable(false);
		songText.setMouseTransparent(true);
		songText.setFocusTraversable(false);
		artistText.setEditable(false);
		artistText.setMouseTransparent(true);
		artistText.setFocusTraversable(false);
		albumYearText.setEditable(false);
		albumYearText.setMouseTransparent(true);
		albumYearText.setFocusTraversable(false);

		// Still need a way to select top song and make persistence

	}

	/*
	 * public void start(Stage primaryStage) {
	 * 
	 * // Add change listener booleanProperty.addListener(new
	 * ChangeListener<Boolean>() {
	 * 
	 * @Override public void changed(ObservableValue<? extends Boolean> observable,
	 * Boolean oldValue, Boolean newValue) { System.out.println("changed " +
	 * oldValue + "->" + newValue); myFunc(); } });
	 */

	public static Song getPassSong() {
		return passSong;
	}

	public static void setPassSong(Song song) {
		passSong = song;
	}

	public static ObservableList<Song> getList() {
		return list;
	}

	public static void addElement(Song song) {
		list.add(song);
	}

	public static void editElement(Song toReplace, Song toAdd) {
		int index = list.indexOf(toReplace);
		list.set(index, toAdd);
	}

	public static void removeElement(Song toRemove) {
		list.remove(toRemove);
	}

	public static boolean checkElementAdd(Song toCheck) {
		boolean ret = false;
		for (int i = 0; i < list.size(); i++) {
			Song test = list.get(i);
			if (test.getName().compareTo(toCheck.getName()) == 0
					&& test.getArtist().compareTo(toCheck.getArtist()) == 0) {
				ret = true;
			}
		}
		return ret;
	}

	public static boolean checkElementEdit(Song toCheck) {
		boolean ret = false;
		for (int i = 0; i < list.size(); i++) {
			Song test = list.get(i);
			int toAvoid = list.indexOf(toCheck);
			if (i == toAvoid) {
				// Avoid, this is the item were changing
			} else if (test.getName().compareTo(toCheck.getName()) == 0
					&& test.getArtist().compareTo(toCheck.getArtist()) == 0) {
				ret = true;
			}
		}
		return ret;
	}

	public void addSong(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("addScreenfx.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void editSong(ActionEvent e) throws IOException {
		passSong = listView.getSelectionModel().getSelectedItem();
		if (passSong == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("No song selected!");
			alert.showAndWait();
		} else {
			Parent root = FXMLLoader.load(getClass().getResource("editScreenfx.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

	}

	public void deleteSong(ActionEvent e) throws IOException {
		passSong = listView.getSelectionModel().getSelectedItem();
		if (passSong == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setContentText("No song selected!");
			alert.showAndWait();
		} else {
			Parent root = FXMLLoader.load(getClass().getResource("deleteScreenfx.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

	}

}