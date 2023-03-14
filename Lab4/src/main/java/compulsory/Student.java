package compulsory;

import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Student implements Comparable<Project>{
    private String Name;
    private List<Project> AdmissibleProjects;

    /**
     * Returns new instance of Student class
     * @param name
     */
    public Student(String name)
    {
        Name = name;
    }

    /**
     * @return Name of the student
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the student
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return The list of admissible projects for a student
     */
    public List<Project> getAdmissibleProjects() {
        return AdmissibleProjects;
    }

    /**
     * Sets the list of admissible projects for the student
     * @param admissibleProjects
     */
    public void setAdmissibleProjects(List<Project> admissibleProjects) {
        AdmissibleProjects = admissibleProjects;
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
