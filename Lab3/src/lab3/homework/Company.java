package lab3.homework;

/**
 * @author Virna Stefan Alexandru
 */
public class Company implements Node {
    private String CompanyName;
    private int Employees;

    public Company(String companyName) {
        CompanyName = companyName;
    }

    @Override
    public String GetName() {
        return CompanyName;
    }

    @Override
    public String GetType() {
        return "Company";
    }

    @Override
    public Boolean CheckIfNodesAreConnected(Node secondNode) {
        if(secondNode.GetType() != "Company")
        {
            return secondNode.CheckIfNodesAreConnected(this);
        }
        else {
            // Two companies can not be connected directly - with the information provided in the problem description.
            return false;
        }
    }

    @Override
    public int GetNumberOfConnectedNodes() {
        return Employees;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.GetNumberOfConnectedNodes(), GetNumberOfConnectedNodes());
    }

    public void IncrementEmployees() {
        Employees++;
    }

    public void DecrementEmployees() {
        Employees--;
    }
}
