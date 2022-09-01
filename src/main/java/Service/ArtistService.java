package Service;

import DAO.ArtistRepository;

import java.sql.SQLException;

public class ArtistService {
    ArtistRepository ar;
    public ArtistService() throws SQLException {
        ar = new ArtistRepository();
    }
    public ArtistService(ArtistRepository ar){
        this.ar = ar;
    }
    public int getArtistIDFromName(String name){
        return ar.getArtistIdFromName(name);
    }
}