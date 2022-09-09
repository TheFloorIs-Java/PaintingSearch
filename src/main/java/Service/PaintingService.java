package Service;

import DAO.PaintingRepository;
import Model.Painting;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PaintingService {
    PaintingRepository pr;
    ArtistService as;
    Connection conn = ConnectionUtil.getConnection();
    public PaintingService() throws SQLException {
        as = new ArtistService();
        pr = new PaintingRepository();
    }
    public PaintingService(ArtistService as, PaintingRepository pr) throws SQLException {
        this.as = as;
        this.pr = pr;
    }
    public List<Painting> getAllPaintings(){
        return pr.getAllPaintings();
    }
    public List<Painting> getAllPaintingsByArtistID(int id){
        return pr.getAllPaintingsByArtistID(id);
    }
    public void addPainting(String title, int id, String url) throws SQLException {
        Painting existingPainting = pr.getPaintingByTitle(title);
        System.out.println(url);
        if(existingPainting == null) {
            Painting newPainting = new Painting(title, id, url);
            pr.addPainting(newPainting);
        }else{
//            do nothing
        }
        conn.commit();
    }
    public List<Painting> getAllPaintingsByArtistName(String name) throws Exception {
//        throw new Exception();

        int id = as.getArtistIDFromName(name);
        return pr.getAllPaintingsByArtistID(id);


    }
    public Painting getPaintingByTitle(String title){
        return pr.getPaintingByTitle(title);
    }
}
