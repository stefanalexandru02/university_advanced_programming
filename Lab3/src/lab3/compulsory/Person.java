package lab3.compulsory;

import java.util.Comparator;

/**
 * @author Virna Stefan Alexandru
 */
public class Person implements Node, Comparable<Person> {
    private String Name;

    public Person(String name)
    {
        this.Name = name;
    }

    @Override
    public String GetName() {
        return Name;
    }

    @Override
    public int compareTo(Person o) {
        return this.Name.compareTo(o.Name);
    }
}
