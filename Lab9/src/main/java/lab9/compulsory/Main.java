package lab9.compulsory;

import lab9.compulsory.models.Albums;
import lab9.compulsory.models.AlbumsGenreAssoc;
import lab9.compulsory.models.Artists;
import lab9.compulsory.models.Genres;

import java.util.ArrayList;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args){
        EntityRepository<Genres> genresEntityRepository = new EntityRepository<>();
        Genres g = genresEntityRepository.findByName("RANDOM STRANGE");

        EntityRepository<Artists> artistsEntityRepository = new EntityRepository<>();
        Artists artist = null;
        long startTimeInsertArtists = System.nanoTime();
        for(int i = 0; i < 1000; i++)
        {
            Artists a = new Artists();
            a.setName("Artist_"+i);
            artistsEntityRepository.create(a);

            artist = a;
        }
        long elapsedTimeInsertArtists = System.nanoTime() - startTimeInsertArtists;
        System.out.println("Total execution time to create 1000 Artists in millis: "
                + elapsedTimeInsertArtists/1000000);

        EntityRepository<Albums> albumsEntityRepository = new EntityRepository<>();
        long startTimeInsertAlbums = System.nanoTime();
        for(int i = 0; i < 1000; i++)
        {
            Albums a = new Albums();
            a.setArtistId(artist.getId());
            a.setTitle("Album_" + i);
            a.setReleaseYear(2022);
            AlbumsGenreAssoc assoc = new AlbumsGenreAssoc();
            assoc.setAlbumId(a.getId());
            assoc.setGenreId(g.getId());
            a.getAlbumsGenreAssocsById().add(assoc);
            albumsEntityRepository.create(a);
        }
        long elapsedTimeInsertAlbums = System.nanoTime() - startTimeInsertAlbums;
        System.out.println("Total execution time to create 1000 Albums in millis: "
                + elapsedTimeInsertAlbums/1000000);
    }
}
