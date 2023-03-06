package lab3.compulsory;

import java.util.Comparator;

/**
 * @author Virna Stefan Alexandru
 */
public class Person implements Comparator, Node {
    private String Name;

    public Person(String name)
    {
        this.Name = name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String GetName() {
        return Name;
    }
}
