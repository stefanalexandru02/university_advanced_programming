package lab8.compulsory.Models;

/**
 * @author Virna Stefan Alexandru
 */
public class Genre {
    public Genre(Integer id, String name) {
        Id = id;
        Name = name;
    }
    public Integer Id;
    public String Name;

    @Override
    public String toString() {
        return "Genre{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
