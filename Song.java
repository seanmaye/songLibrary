package songlibrary;

public class Song {

	private String name;
	private String artist;
	private String album;
	private int year;

	public Song(String name, String artist, String album, int year) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}

	public void editName(Song song, String name) {
		song.name = name;
	}

	public static void editArtist(Song song, String artist) {
		song.artist = artist;
	}

	public static void editAlbum(Song song, String album) {
		song.album = album;
	}

	public static void editYear(Song song, int year) {
		song.year = year;
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
		return "\""+ name + "\", " + artist;
	}
}