package lab3.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Network {
    /**
     * List of nodes that are part of the Network
     */
    private List<Node> NodesList;

    /**
     * Create a new instance of Network
     */
    public Network()
    {
        NodesList = new ArrayList<>();
    }

    /**
     * Adds a new node to the network
     * @param node
     */
    public void addNode(Node node)
    {
        NodesList.add(node);
    }

    /**
     * Removes a node from the network
     * @param node
     */
    public void removeNode(Node node)
    {
        NodesList.remove(node);
    }

    @Override
    public String toString() {
        Collections.sort(NodesList);

        StringBuilder networkStringBuilder = new StringBuilder();
        networkStringBuilder.append("Network={\n");
        NodesList.forEach((node) -> {
            networkStringBuilder.append("\tNode={\n");
            networkStringBuilder.append("\t\tType='");
            networkStringBuilder.append(node.GetType());
            networkStringBuilder.append("'\n\t\tName='");
            networkStringBuilder.append(node.GetName());
            networkStringBuilder.append("'\n\t\tConnectedNodes='");
            networkStringBuilder.append(node.GetNumberOfConnectedNodes());
            networkStringBuilder.append("'\n\t}\n");
        });
        networkStringBuilder.append("}");
        return networkStringBuilder.toString();
    }

    /**
     * @param node
     * Returns the importance of a node, based on the number of connected nodes
     */
    public int getNodeImportance(Node node)
    {
        return node.GetNumberOfConnectedNodes();
    }
}
