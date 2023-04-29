package lab9.compulsory.models;

import jakarta.persistence.*;

/**
 * @author Virna Stefan Alexandru
 */
@Entity
@Table(name = "albums")
public class Albums {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "artist_id")
    private Integer artistId;
    @Basic
    @Column(name = "release_year")
    private Integer releaseYear;
    @Basic
    @Column(name = "title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Albums albums = (Albums) o;

        if (id != albums.id) return false;
        if (artistId != null ? !artistId.equals(albums.artistId) : albums.artistId != null) return false;
        if (releaseYear != null ? !releaseYear.equals(albums.releaseYear) : albums.releaseYear != null) return false;
        if (title != null ? !title.equals(albums.title) : albums.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
