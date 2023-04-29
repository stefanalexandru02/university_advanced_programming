package lab9.compulsory.models;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * @author Virna Stefan Alexandru
 */
@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name="Genres.findAll", query = "select e from Genres e order by e.name"),
        @NamedQuery(name="Genres.findById", query = "select e from Genres e where e.id = ?1"),
        @NamedQuery(name="Genres.findByName", query = "select e from Genres e where e.name = ?1"),
})
public class Genres {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genres genres = (Genres) o;

        if (id != genres.id) return false;
        if (name != null ? !name.equals(genres.name) : genres.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
