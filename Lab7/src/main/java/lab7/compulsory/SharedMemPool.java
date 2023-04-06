package lab7.compulsory;

import java.util.*;

/**
 * @author Virna Stefan Alexandru
 */
public class SharedMemPool {
    private static List<Token> tokens;

    public static void setupMemPool(int n) {
        tokens = new ArrayList<>();
        for(int i = 0; i < n * n * n; i++)
        {
            tokens.add(new Token(i));
        }
    }

    public static synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty())
            {
                break;
            }
            Random rand = new Random();
            var token = tokens.get(rand.nextInt(tokens.size()));
            extracted.add(token);
            tokens.remove(token);
        }
        return extracted;
    }

}
