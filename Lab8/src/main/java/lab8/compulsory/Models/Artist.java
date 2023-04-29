package lab8.compulsory.Models;

/**
 * @author Virna Stefan Alexandru
 */
public class Artist {
    public Artist(Integer id, String name) {
        Id = id;
        Name = name;
    }

    public Integer Id;
    public String Name;

    @Override
    public String toString() {
        return "Artist{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
