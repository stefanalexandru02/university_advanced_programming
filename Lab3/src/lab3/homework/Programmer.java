package lab3.homework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Programmer extends Person {
    /**
     * List of technologies that the programmer prefers
     */
    private List<String> PreferredTechnologies;

    public Programmer(String name, Date date) {
        super(name, date);
        PreferredTechnologies = new ArrayList<>();
    }

    public void addTechnology(String technology)
    {
        PreferredTechnologies.add(technology);
    }

    public void removeTechnology(String technology)
    {
        PreferredTechnologies.remove(technology);
    }

    public List<String> getTechnologies()
    {
        return PreferredTechnologies;
    }

    @Override
    public String GetType() {
        return "Programmer";
    }
}
