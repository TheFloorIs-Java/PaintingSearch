package Model;

public class Painting {
    public String title;
    public int artistID;
    public Painting(){

    }
    public Painting(String title, int artistID) {
        this.title = title;
        this.artistID = artistID;
    }

    @Override
    public String toString() {
        return title + ": artist id "+ artistID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }
}