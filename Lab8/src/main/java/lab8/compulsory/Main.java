package lab8.compulsory;

import lab8.compulsory.DAO.ArtistDAO;
import lab8.compulsory.Models.Artist;

import java.sql.SQLException;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Database.initializeDb();

        new ArtistDAO().create("Michael Jackson");
        Artist a = new ArtistDAO().findById(2);
        a.Name = "Alt artist ceva";
        new ArtistDAO().updateInstance(a);
        //new ArtistDAO().deleteById(2);
    }
}