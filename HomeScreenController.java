package songlibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
	private ObservableList<Song> list = FXCollections.observableArrayList();
	private Scene scene;
	private Stage stage;
	private Parent root;

	public void initialize() {
		listView.setItems(list);
		// put the songs
		// select the top one if there is one

	}

	public void addSong(ActionEvent e) throws IOException {
		// Just testing what adding a song looks like
		/*Song test = new Song("Yah Mean", "Playboi Carti", "Playboi Carti", 2017);
		list.add(test);*/
		Parent root = FXMLLoader.load(getClass().getResource("addScreenfx.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void editSong(ActionEvent e) throws IOException {
		// Just testing what editing a song looks like need to click on it to change
		/*System.out.println("Edit song");
		Song.editArtist(list.get(0), "Stop Breathing");
		Song.editAlbum(list.get(0), "Whole Lotta Red");
		Song.editYear(list.get(0), 2020);
		listView.setItems(list);*/
		Parent root = FXMLLoader.load(getClass().getResource("editScreenfx.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void deleteSong(ActionEvent e) throws IOException {
		/*System.out.println("delete song");
		 Just testing what removing a song looks like
		list.remove(0);
		listView.setItems(list);*/
		Parent root = FXMLLoader.load(getClass().getResource("deleteScreenfx.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}