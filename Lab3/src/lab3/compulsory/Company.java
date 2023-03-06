package lab3.compulsory;

import java.util.Comparator;

/**
 * @author Virna Stefan Alexandru
 */
public class Company implements Comparator, Node {
    private String Name;

    public Company(String companyName)
    {
        this.Name = companyName;
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
