package lab3.homework;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Virna Stefan Alexandru
 */
public class Person implements Node {
    /**
     * Map to implement relationships
     * If the relationship is Person-to-Person, the String value explains how the know each other
     * If the relationship is Person-to-Company, the String value tells the position in the company
     */
    private Map<Node, String> Relationships;
    private String Name;
    private Date Birthdate;

    /**
     * @param name Return an instance of a new Person
     */
    public Person(String name, Date birthdate) {
        Name = name;
        Relationships = new HashMap<>();
        Birthdate = birthdate;
    }

    // Add a relationship
    public void AddRelationship(Node connectedNode, String connectionDetails)
    {
        AddRelationship(connectedNode, connectionDetails, false);
    }
    // Add a relation ship, recursive
    public void AddRelationship(Node connectedNode, String connectionDetails, boolean nonRecursive)
    {
        if(!Relationships.containsKey(connectedNode))
        {
            if(connectedNode.GetType() == "Company")
            {
                ((Company)connectedNode).IncrementEmployees();
            }
        }
        Relationships.put(connectedNode, connectionDetails);
        if(connectedNode.GetType() != "Company" && nonRecursive == false)
            ((Person)connectedNode).AddRelationship(this, connectionDetails, true);
    }

    /**
     * @return Person name
     */
    @Override
    public String GetName() {
        return Name;
    }

    @Override
    public String GetType()
    {
        return "Person";
    }

    @Override
    public Boolean CheckIfNodesAreConnected(Node secondNode) {
        return Relationships.containsKey(secondNode);
    }

    @Override
    public int GetNumberOfConnectedNodes() {
        return Relationships.size();
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.GetNumberOfConnectedNodes(), GetNumberOfConnectedNodes());
    }
}
