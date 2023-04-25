package lab8.compulsory.DAO;

import lab8.compulsory.Database;
import lab8.compulsory.Models.Artist;
import java.sql.*;

/**
 * @author Virna Stefan Alexandru
 */
public class ArtistDAO {
    /**
     * Creates a new Artist
     * @param name
     * @throws SQLException
     */
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

    /**
     * Find object by Id
     * @param id
     * @return
     * @throws SQLException
     */
    public Artist findById(Integer id) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id, name from artists where id = '"+id+"'");
            rs.next();
            return new Artist(rs.getInt("id"), rs.getString("name"));
        }
    }

    /**
     * Find object by name
     * @param name
     * @return
     * @throws SQLException
     */
    public Artist findByName(String name) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id, name from artists where name = '"+name+"'");
            rs.next();
            return new Artist(rs.getInt("id"), rs.getString("name"));
        }
    }

    /**
     * Updates an object instance
     * @param artist
     * @throws SQLException
     */
    public void updateInstance(Artist artist) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "update artists set name = '"+artist.Name+"' where id = '"+artist.Id+"'"
        )) {
            pstmt.executeUpdate();
        }
        conn.commit();
    }

    /**
     * Deletes an object instance
     * @param id
     * @throws SQLException
     */
    public void deleteById(Integer id) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            stmt.executeUpdate("delete from artists where id = '"+id+"'");
        }
    }
}
