package homework;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class ProjectAssignmentController {
    private List<Project> Projects = new ArrayList<>();
    private List<Student> Students = new ArrayList<>();

    public void addProject(Project project)
    {
        Projects.add(project);
    }

    public void addStudent(Student student)
    {
        Students.add(student);
    }

    public Student getStudent(int index) { return Students.get(index); }

    public Project getProject(int index) { return Projects.get(index); }

    /**
     * Display students with filter
     */
    public void displayStudentsWithLowerThanAveragePreferencesCount()
    {
        Integer averageNumberOfPreferences = Students.stream()
                .mapToInt(student -> student.getNumberOfPreferences()).reduce(0, (a, b) -> a+ b) /
                Students.size();
        System.out.println("\nDisplay students with lower than average preferences count " + averageNumberOfPreferences);
        Students.stream()
                .filter(student -> student.getNumberOfPreferences() < averageNumberOfPreferences)
                .forEach(student -> {
                    System.out.println(student);
                });
        System.out.println();
    }

    /**
     * Assigns projects to students in a greddy manner
     */
    public void assignProjectsToStudents()
    {
        Collections.sort(Students);

        Students.forEach(student -> {
            if(student.getAdmissibleProjects().size() > 0)
            {
                var _project = student.getAdmissibleProjects().stream().findFirst().get();
                System.out.println(student.getName() + " -> " + _project.getName());
                Students.forEach(_student -> {
                    _student.removeProject(_project);
                });
            }
            else {
                System.out.println(student.getName() + " -> {}");
            }
        });
    }
}
