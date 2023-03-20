package homework;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        ProjectAssignmentController assignmentController = new ProjectAssignmentController();

        // Create students using streams
        IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student()) //  * new Random().nextInt(0, 1000)
                .forEach(student -> {
                    assignmentController.addStudent(student);
                });

        // Create projects using streams
        IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project() )
                .forEach(project -> {
                    Faker faker = new Faker();
                    assignmentController.addProject(project);
                });

        assignmentController.getStudent(0).addProject(assignmentController.getProject(0));
        assignmentController.getStudent(0).addProject(assignmentController.getProject(1));
        assignmentController.getStudent(0).addProject(assignmentController.getProject(2));

        assignmentController.getStudent(1).addProject(assignmentController.getProject(0));
        assignmentController.getStudent(1).addProject(assignmentController.getProject(1));

        assignmentController.getStudent(2).addProject(assignmentController.getProject(0));

        assignmentController.displayStudentsWithLowerThanAveragePreferencesCount();
        assignmentController.assignProjectsToStudents();
    }
}
