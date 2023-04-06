package lab7.compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Cell {
    private boolean Visited = false;
    private List<Token> tokens = new ArrayList<>();

    public boolean isVisited() { return Visited; }
    public void visit() { Visited = true; }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
