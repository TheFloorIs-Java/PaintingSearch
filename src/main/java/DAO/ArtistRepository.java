package DAO;

import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistRepository {
    Connection conn = ConnectionUtil.getConnection();
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
}
