package Service;

import DAO.PaintingRepository;
import Model.Painting;

import java.util.List;

public class PaintingService {
    PaintingRepository pr;
    ArtistService as;
    public PaintingService(){
        as = new ArtistService();
        pr = new PaintingRepository();
    }
    public List<Painting> getAllPaintings(){
        return pr.getAllPaintings();
    }
    public List<Painting> getAllPaintingsByArtistID(int id){
        return pr.getAllPaintingsByArtistID(id);
    }
    public void addPainting(String title, int id){
        Painting existingPainting = pr.getPaintingByTitle(title);
        if(existingPainting == null) {
            Painting newPainting = new Painting(title, id);
            pr.addPainting(newPainting);
        }else{
//            do nothing
        }
    }
    public List<Painting> getAllPaintingsByArtistName(String name){
        int id = as.getArtistIDFromName(name);
        return pr.getAllPaintingsByArtistID(id);
    }
}
