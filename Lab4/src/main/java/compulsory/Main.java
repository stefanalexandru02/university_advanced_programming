package compulsory;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {
        // Create students using streams
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i)) //  * new Random().nextInt(0, 1000)
                .toArray(Student[]::new);
        System.out.println("Added " + students.length + " students");

        // Create projects using streams
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);
        System.out.println("Added " + projects.length + " students");

        // Put all students into a linked list
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.addAll(Arrays.stream(students).toList());
        Collections.sort(studentLinkedList,
                ((u, v) -> u.getName().compareTo(v.getName())));
        studentLinkedList.forEach((student) -> {
            System.out.println(student.getName());
        });

        System.out.println("-------------------------------------------");

        // Put all projects into a tree set
        TreeSet<Project> projectTreeSet = new TreeSet<>();
        projectTreeSet.addAll(Arrays.stream(projects).toList());
        // TreeSet collections keep their elements already sorted!
        projectTreeSet.forEach((project -> {
            System.out.println(project.getName());
        }));
    }
}
