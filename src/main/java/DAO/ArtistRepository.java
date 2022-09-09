package DAO;

import Model.Artist;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistRepository {
    Connection conn;
    public ArtistRepository() throws SQLException {
        conn = ConnectionUtil.getConnection();
    }
    public ArtistRepository(Connection conn){
//        why do we need 2?
//        Mockito allows us to make 'dummy' mock objects that do exactly
//        what we tell them for specific scenarios
//        eg, we can say 'this mock resultset ALWAYS returns this mock data'
        this.conn = conn;
    }


    public int getArtistIdFromName(String name){
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from Artist where name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                return id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
    public Artist getArtistFromId(int id){
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from Artist where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                return new Artist(rs.getInt("id"), rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
