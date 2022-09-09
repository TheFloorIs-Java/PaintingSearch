package Service;

import DAO.ArtistRepository;
import Model.Artist;

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
    public Artist getArtistFromId(int id){
        return ar.getArtistFromId(id);
    }
}