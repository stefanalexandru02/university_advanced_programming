package lab8.compulsory.DAO;

import lab8.compulsory.Database;
import lab8.compulsory.Models.Album;
import lab8.compulsory.Models.Artist;
import lab8.compulsory.Models.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class AlbumDAO {
    /**
     * Creates a new instance
     * @param name
     * @throws SQLException
     */
    public Album create(String name, int releaseYear, Artist artist, List<Genre> genres) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(
                "insert into albums (title, release_year, artist_id) values (?, ?, ?)"
        )) {
            pstmt.setString(1, name);
            pstmt.setInt(2, releaseYear);
            pstmt.setInt(3, artist.Id);
            pstmt.executeUpdate();
        }
        conn.commit();

        int albumId = -1;
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select max(id) as id from albums");
            rs.next();
            albumId = rs.getInt("id");
        }

        for(int i = 0; i < genres.size(); i++)
        {
            Genre genre = genres.get(i);
            try (PreparedStatement pstmt = conn.prepareStatement(
                    "insert into albums_genre_assoc (album_id, genre_id) values (?, ?)"
            )) {
                pstmt.setInt(1, albumId);
                pstmt.setInt(2, genre.Id);
                pstmt.executeUpdate();
            }
            conn.commit();
        }
        System.out.println("Create album " + name);
        return findByNameAndArtist(name, artist);
    }

    /**
     * Find object by Id
     * @param id
     * @return
     * @throws SQLException
     */
    public Album findById(Integer id) throws SQLException {
        Connection conn = Database.getConnection();
        try (Statement stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id, artist_id, release_year, title from albums where id = '"+id+"'");
            rs.next();
            Album album = new Album();
            album.setId(rs.getInt("id"));
            album.setReleaseYear(rs.getInt("release_year"));
            album.setTitle(rs.getString("title"));
            album.setArtist(new ArtistDAO().findById(rs.getInt("artist_id")));
            List<Genre> genreList = new ArrayList<>();
            ResultSet rsGenre = stmt.executeQuery("select genre_id from albums_genre_assoc where album_id = '"+album.getId()+"'");
            while(rsGenre.next())
            {
                genreList.add(new GenreDAO().findById(rsGenre.getInt("genre_id")));
            }
            album.setGenres(genreList);
            return album;
        }
    }

    /**
     * Find object by name
     * @param name
     * @return
     * @throws SQLException
     */
    public Album findByNameAndArtist(String name, Artist artist) throws SQLException {
        Connection conn = Database.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("select id from albums where title = ? and artist_id = ?"))
        {
            stmt.setString(1, name);
            stmt.setInt(2, artist.Id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return findById(rs.getInt("id"));
        } catch (SQLException ex) { return null; }
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
            stmt.executeUpdate("delete from albums where id = '"+id+"'");
        }
    }

    public List<Integer> getAllIds() throws SQLException {
        List<Integer> integerList = new ArrayList<>();
        Connection conn = Database.getConnection();
        try (var stmt = conn.createStatement())
        {
            ResultSet rs = stmt.executeQuery("select id from albums");
            while(rs.next())
            {
                integerList.add(rs.getInt("id"));
            }
        } catch (SQLException ex) { return null; }
        return integerList;
    }
}
