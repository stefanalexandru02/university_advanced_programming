package lab9.compulsory.models;

import jakarta.persistence.*;

/**
 * @author Virna Stefan Alexandru
 */
@Entity
@Table(name = "albums_genre_assoc", schema = "public", catalog = "Albums")
@IdClass(AlbumsGenreAssoc.class)
public class AlbumsGenreAssoc {
    @Id
    @Basic
    @Column(name = "album_id", nullable = true, insertable = false, updatable = false)
    private Integer albumId;
    @Id
    @Basic
    @Column(name = "genre_id", nullable = true, insertable = false, updatable = false)
    private Integer genreId;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        if(albumId == 0)
            albumId = bkp_id++;
        this.albumId = albumId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumsGenreAssoc that = (AlbumsGenreAssoc) o;

        if (albumId != null ? !albumId.equals(that.albumId) : that.albumId != null) return false;
        if (genreId != null ? !genreId.equals(that.genreId) : that.genreId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = albumId != null ? albumId.hashCode() : 0;
        result = 31 * result + (genreId != null ? genreId.hashCode() : 0);
        return result;
    }

    static int bkp_id = 1001;
}