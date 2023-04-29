package lab8.compulsory.DAO;

import lab8.compulsory.Database;
import lab8.compulsory.Models.Artist;
import lab8.compulsory.Models.Genre;

import java.sql.*;

/**
 * @author Virna Stefan Alexandru
 */
public class GenreDAO {
    /**
     * Creates a new instance
     * @param name
     * @throws SQLException
     */
    public Genre create(String name) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "insert into genres (name) values (?)"
        )) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        conn.commit();
        System.out.println("Created genre " + name);
        return findByName(name);
    }

    /**
     * Find object by Id
     * @param id
     * @return
     * @throws SQLException
     */
    public Genre findById(Integer id) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id, name from genres where id = '"+id+"'");
            rs.next();
            return new Genre(rs.getInt("id"), rs.getString("name"));
        }
    }

    /**
     * Find object by name
     * @param name
     * @return
     * @throws SQLException
     */
    public Genre findByName(String name) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("select id, name from genres where name = ?"))
        {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new Genre(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException ex) { return null; }
    }

    /**
     * Updates an object instance
     * @param genre
     * @throws SQLException
     */
    public void updateInstance(Genre genre) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "update genres set name = '"+genre.Name+"' where id = '"+genre.Id+"'"
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
            stmt.executeUpdate("delete from genres where id = '"+id+"'");
        }
    }
}
