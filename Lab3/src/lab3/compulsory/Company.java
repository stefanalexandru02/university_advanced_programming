package lab3.compulsory;

import java.util.Comparator;

/**
 * @author Virna Stefan Alexandru
 * Class that defines a Company. Implements Node and Comparable
 */
public class Company implements Node, Comparable<Company> {
    private String Name;

    public Company(String companyName)
    {
        this.Name = companyName;
    }

    @Override
    public String GetName() {
        return Name;
    }

    @Override
    public int compareTo(Company o) {
        return this.Name.compareTo(o.Name);
    }
}
