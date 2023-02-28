package lab1.homework;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    static int noDisplayThreshold = 30_000;

    public static void main(String[] args) {
        if(args.length < 1)
        {
            System.out.println("n is required as a command line argument.");
            return;
        }
        int n = -1;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The argument was not a valid integer");
            return;
        }

        if(n < 0)
        {
            System.out.println("The argument can not be negative");
            return;
        }

        int[][] latinSquare = BuildSquare(n);

        long startTime = System.currentTimeMillis();

        DisplayLinesAndColumns(latinSquare);

        long endTime = System.currentTimeMillis();

        if(n >= noDisplayThreshold)
        {
            System.out.println("That took " + (endTime - startTime) + " milliseconds");
        }
    }

    // Builds basic latin square with the provided dimension
    private static int[][] BuildSquare(int n)
    {
        int[][] latinSquare = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                latinSquare[i][j] = (j + i + 1) <= n ? (j + i + 1) : (j + i + 1 - n);
            }
        }

        return latinSquare;
    }

    // Displays lines and columns of the square
    private static void DisplayLinesAndColumns(int[][] square)
    {
        /// Build lines
        for(int i = 0; i < square.length; i++)
        {
            StringBuilder lineStr = new StringBuilder();
            for(int j = 0; j < square[i].length; j++)
            {
                lineStr.append(square[i][j]);
            }
            if(square.length < noDisplayThreshold)
            {
                System.out.println("LN: " + (i+1) + ": " + lineStr.toString());
            }
        }

        /// Build columns
        for(int i = 0; i < square.length; i++)
        {
            StringBuilder lineStr = new StringBuilder();
            for(int j = 0; j < square[i].length; j++)
            {
                lineStr.append(square[j][i]);
            }
            if(square.length < noDisplayThreshold)
            {
                System.out.println("COL: " + (i+1) + ": " + lineStr.toString());
            }
        }
    }
}
