package DAO;

import Model.Painting;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaintingRepository {
    Connection conn;
    public PaintingRepository() throws SQLException {
        conn = ConnectionUtil.getConnection();
    }
    public List<Painting> getAllPaintings(){
        List<Painting> allPaintings = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From Painting");
            while(rs.next()){
                Painting loadedPainting = new Painting(rs.getString("title"), rs.getInt("artistID"));
                allPaintings.add(loadedPainting);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allPaintings;
    }
    public List<Painting> getAllPaintingsByArtistID(int id){
        List<Painting> paintings = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("Select * from Painting where artistID = ?");
//            parameterindexes start from 1 and go in order of the '?' in the sql string
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Painting loadedPainting = new Painting(rs.getString("title"), rs.getInt("artistID"));
                paintings.add(loadedPainting);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(paintings.size() == 0){
            return paintings;
        }else{
            return paintings;
        }

    }
    public void addPainting(Painting p){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into Painting(title, artistID) " +
                    "values (?, ?)");
            statement.setString(1, p.getTitle());
            statement.setInt(2, p.getArtistID());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Painting getPaintingByTitle(String title){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from Painting where title = ?");
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Painting p = new Painting(rs.getString("title"), rs.getInt("artistID"));
                return p;
            }
        }catch(SQLException e){

        }
        return null;
    }
}
