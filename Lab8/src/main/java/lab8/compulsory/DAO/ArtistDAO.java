package lab8.compulsory.DAO;

import lab8.compulsory.Database;
import lab8.compulsory.Models.Artist;
import java.sql.*;

/**
 * @author Virna Stefan Alexandru
 */
public class ArtistDAO {
    public void create(String name) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "insert into artists (name) values (?)"
        )) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        conn.commit();
    }

    public Artist findById(Integer id) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id, name from artists where id = '"+id+"'");
            rs.next();
            return new Artist(rs.getInt("id"), rs.getString("name"));
        }
    }

    public Artist findByName(String name) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id, name from artists where name = '"+name+"'");
            rs.next();
            return new Artist(rs.getInt("id"), rs.getString("name"));
        }
    }

    public void updateInstance(Artist artist) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "update artists set name = '"+artist.Name+"' where id = '"+artist.Id+"'"
        )) {
            pstmt.executeUpdate();
        }
        conn.commit();
    }

    public void deleteById(Integer id) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            stmt.executeUpdate("delete from artists where id = '"+id+"'");
        }
    }
}
