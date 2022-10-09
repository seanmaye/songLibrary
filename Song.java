package songlibrary;

public class Song {

	private String name;
	private String artist;
	private String album;
	private int year;
	
	public Song(String name, String artist) {
		this.name = name;
		this.artist = artist;
	}
	public Song(String name, String artist, String album) {
		this.name = name;
		this.artist = artist;
		this.album = album;
	}
	public Song(String name, String artist, int year) {
		this.name = name;
		this.artist = artist;
		this.year = year;
	}
	public Song(String name, String artist, String album, int year) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}

	public void editName(String name) {
		this.name = name;
	}

	public  void editArtist(String artist) {
		this.artist = artist;
	}

	public  void editAlbum(String album) {
		this.album = album;
	}

	public void editYear(int year) {
		this.year = year;
	}

	public String getName() {
		return this.name;
	}

	public String getArtist() {
		return this.artist;
	}

	public String getAlbum() {
		return this.album;
	}

	public int getYear() {
		return this.year;
	}

	public String toString() {
		return "\"" + name + "\", " + artist;
	}
}