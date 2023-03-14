package lab3.homework;

/**
 * @author Virna Stefan Alexandru
 * Defines the Node interface
 */
public interface Node extends Comparable<Node> {
    /**
     * @return The name of the Node
     */
    public String GetName();

    /**
     * @return Type of the Node
     */
    public String GetType();

    /**
     * @param secondNode
     * @return Whether or not the node is connected with the current one
     */
    public Boolean CheckIfNodesAreConnected(Node secondNode);

    /**
     * @return Number of connected nodes
     */
    public int GetNumberOfConnectedNodes();
}
