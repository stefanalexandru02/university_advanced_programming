package compulsory;

/**
 * @author Virna Stefan Alexandru
 */
public class Project implements Comparable<Project>{
    private String Name;

    /**
     * Returns a new instance of Project class
     * @param name
     */
    public Project(String name)
    {
        Name = name;
    }

    /**
     * @return Name of the project
     */
    public String getName() {
        return Name;
    }

    /**
     * Update name on Project
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Project o) {
        return getName().compareTo(o.getName());
    }
}
