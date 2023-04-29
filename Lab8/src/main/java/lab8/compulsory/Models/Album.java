package lab8.compulsory.Models;

import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Album {
    private int Id;
    private String Title;
    private int ReleaseYear;
    private Artist Artist;
    private List<Genre> Genres;

    @Override
    public String toString() {
        return "Album{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", ReleaseYear=" + ReleaseYear +
                ", Artist=" + Artist +
                ", Genres=" + Genres +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public lab8.compulsory.Models.Artist getArtist() {
        return Artist;
    }

    public void setArtist(lab8.compulsory.Models.Artist artist) {
        Artist = artist;
    }

    public List<Genre> getGenres() {
        return Genres;
    }

    public void setGenres(List<Genre> genres) {
        Genres = genres;
    }
}
