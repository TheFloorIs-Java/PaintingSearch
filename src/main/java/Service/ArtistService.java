package Service;

import DAO.ArtistRepository;

public class ArtistService {
    ArtistRepository ar;
    public ArtistService(){
        ar = new ArtistRepository();
    }
    public int getArtistIDFromName(String name){
        return ar.getArtistIdFromName(name);
    }
}
