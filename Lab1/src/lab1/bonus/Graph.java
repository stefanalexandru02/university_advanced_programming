package lab1.bonus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Graph {
    List<Edge> edgesList;
    HashSet<Integer> nodes;
    public Graph()
    {
        edgesList = new ArrayList<Edge>();
    }

    public Graph(String fileName)
    {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            var resource = classloader.getResource(fileName);
            List<String> lines = Files.readAllLines(Paths.get(resource.getPath()));

            for(int i = 0; i < lines.size(); i++)
            {
                String line = lines.get(i);
                var parts = line.split(",");
                AddNode(new Edge(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddNode(Edge edge)
    {
        nodes.add(edge.FirstNode);
        nodes.add(edge.SecondNode);
        edgesList.add(edge);
    }

    public int GraphSize()
    {
        return nodes.size();
    }
}
