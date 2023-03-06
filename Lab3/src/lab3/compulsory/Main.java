package lab3.compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {

        List<Node> nodesList = new ArrayList<>();
        nodesList.add(new Person("Stefan"));
        nodesList.add(new Company("Microsoft"));
        nodesList.add(new Person("Denisa"));

        nodesList.forEach((node -> {
            System.out.println(node.GetName());
        }));
    }
}