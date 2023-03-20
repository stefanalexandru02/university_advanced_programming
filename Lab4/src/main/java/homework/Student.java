package homework;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Student implements Comparable<Student>{
    private String Name;
    private HashSet<Project> AdmissibleProjects = new HashSet<>();

    /**
     * Returns new instance of Student class
     * @param name
     */
    public Student(String name)
    {
        Name = name;
    }

    /**
     * Returns new instance of Student class
     */
    public Student()
    {
        Faker faker = new Faker();
        Name = faker.name().fullName();
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
    public HashSet<Project> getAdmissibleProjects() {
        return AdmissibleProjects;
    }

    /**
     * Add project to prefered projects list for Student
     * @param project
     */
    public void addProject(Project project) {AdmissibleProjects.add(project);}

    /**
     * @param project
     * @return True if project is prefered by the user
     */
    public boolean hasProject(Project project) { return AdmissibleProjects.contains(project); }

    /**
     * Removes project from prefered list. Should be called when a project is taken
     * @param project
     */
    public void removeProject(Project project) { AdmissibleProjects.remove(project); }

    /**
     * @return The number of projects that the student prefers
     */
    public int getNumberOfPreferences()
    {
        return AdmissibleProjects.size();
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        return Integer.compare(getNumberOfPreferences(), o.getNumberOfPreferences());
    }

    @Override
    public String toString() {
        return "Name: " + Name + " Number of preferences: " + getNumberOfPreferences();
    }
}
