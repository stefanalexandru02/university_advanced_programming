package lab8.compulsory;

import lab8.compulsory.DAO.AlbumDAO;
import lab8.compulsory.DAO.ArtistDAO;
import lab8.compulsory.DAO.GenreDAO;
import lab8.compulsory.Models.Album;
import lab8.compulsory.Models.Artist;
import lab8.compulsory.Models.Genre;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 * docker run -p 5455:5432 --name some-postgres -e POSTGRES_PASSWORD=password -d postgres
 */
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ArtistDAO artistDAO = new ArtistDAO();
        GenreDAO genreDAO = new GenreDAO();
        AlbumDAO albumDAO = new AlbumDAO();

        File file = new File("/Users/stefanalexandru/Desktop/university_advanced_programming/Lab8/src/main/java/lab8/compulsory/albumlist.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] tempArr;
        br.readLine();
        while((line = br.readLine()) != null) {
            tempArr = line.split(",");

            int year = Integer.parseInt(tempArr[1]);
            String albumName = tempArr[2];
            String artistName = tempArr[3];
            String genreName = tempArr[4];

            Artist artist = artistDAO.findByName(artistName);
            if(artist == null)
                artist = artistDAO.create(artistName);

            Genre genre = genreDAO.findByName(genreName);
            if(genre == null)
                genre = genreDAO.create(genreName);

            Album album = albumDAO.findByName(albumName);
            if(album == null)
                album = albumDAO.create(albumName, year, artist, Arrays.asList(genre));
        }
        br.close();

        System.out.println("Data up to date.");

        List<Integer> albumsIds = albumDAO.getAllIds();
        albumsIds.forEach(id -> {
            try {
                Album album = albumDAO.findById(id);
                System.out.println(album);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}