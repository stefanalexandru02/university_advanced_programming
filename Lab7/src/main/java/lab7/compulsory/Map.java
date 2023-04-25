package lab7.compulsory;

import lab7.homework.Direction;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Virna Stefan Alexandru
 */
public class Map {
    private static Cell[][] matrix;

    public static void setupMap(int n) {
        matrix = new Cell[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new Cell[n];
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = new Cell();
            }
        }
    }

    public static boolean exploreRandom(Robot robot) {
        for(var pair : getAvailablePositions(robot.getxPos(), robot.getyPos()))
        {
            synchronized (matrix[pair.getValue0()][pair.getValue1()]) {
                int row = pair.getValue0();
                int col = pair.getValue1();
                if(!matrix[row][col].isVisited())
                {
                    if(robot.getPrintLogs())
                    {
                        System.out.println(robot.getName() + " visited {" + pair.getValue0() + ", "+pair.getValue1()+" }");
                    }
                    matrix[row][col].visit();
                    matrix[row][col].getTokens().addAll(SharedMemPool.extractTokens(matrix.length));
                    robot.getTokens().addAll(matrix[row][col].getTokens());
                    return true;
                }
            }
        }
        //System.out.println("NOWHERE TO GO :(");
        return false;
    }

    private static List<Pair<Integer, Integer>> getAvailablePositions(int row, int col)
    {
        List<Pair<Integer, Integer>> options = new ArrayList<>();
        for(int i = 0; i < 8; i++)
        {
            try{
                Pair<Integer, Integer> newLocation = generatePosition(i, row, col);
                if(newLocation.getValue0() < 0) continue;
                if(newLocation.getValue0() >= matrix.length) continue;

                if(newLocation.getValue1() < 0) continue;
                if(newLocation.getValue1() >= matrix.length) continue;

                options.add(newLocation);
            }
            catch (Exception e){}
        }
        Collections.shuffle(options);
        return options;
    }

    private static Pair<Integer, Integer> generatePosition(int i, int row, int col)
    {
        switch (i)
        {
            case 0:
                return new Pair<>(row + 1, col);
            case 1:
                return new Pair<>(row - 1, col);
            case 2:
                return new Pair<>(row, col + 1);
            case 3:
                return new Pair<>(row, col - 1);
            case 4:
                return new Pair<>(row + 1, col + 1);
            case 5:
                return new Pair<>(row - 1, col - 1);
            case 6:
                return new Pair<>(row + 1, col - 1);
            case 7:
                return new Pair<>(row - 1, col + 1);
        }
        return null;
    }

    public static boolean exploreLogic(Robot robot) {
        if(robot.getRobotDirection() == Direction.None) {
            if(robot.getxPos() > matrix.length / 2)
            {
                robot.setRobotDirection(Direction.Left);
            }
            else
            {
                robot.setRobotDirection(Direction.Right);
            }
        }
        else {
            Pair<Integer, Integer> nextPosition = new Pair<>(robot.getxPos(), robot.getyPos());
            int row = robot.getxPos();
            int col = robot.getyPos();
            switch (robot.getRobotDirection())
            {
                case Top:
                    nextPosition = new Pair<>(row, col - 1);
                    break;
                case Down:
                    nextPosition = new Pair<>(row, col + 1);
                    break;
                case Left:
                    nextPosition = new Pair<>(row - 1, col);
                    break;
                case Right:
                    nextPosition = new Pair<>(row + 1, col);
                    break;
            }
            row = nextPosition.getValue0();
            col = nextPosition.getValue1();
            if(!matrix[row][col].isVisited())
            {
                matrix[row][col].visit();
                matrix[row][col].getTokens().addAll(SharedMemPool.extractTokens(matrix.length));
                robot.getTokens().addAll(matrix[row][col].getTokens());
                return true;
            }
            else {
                if(robot.getyPos() > matrix.length / 2)
                {
                    robot.setRobotDirection(Direction.Top);
                }
                else
                {
                    robot.setRobotDirection(Direction.Down);
                }
                switch (robot.getRobotDirection())
                {
                    case Top:
                        nextPosition = new Pair<>(row, col - 1);
                        break;
                    case Down:
                        nextPosition = new Pair<>(row, col + 1);
                        break;
                    case Left:
                        nextPosition = new Pair<>(row - 1, col);
                        break;
                    case Right:
                        nextPosition = new Pair<>(row + 1, col);
                        break;
                }
                row = nextPosition.getValue0();
                col = nextPosition.getValue1();
                if(!matrix[row][col].isVisited())
                {
                    matrix[row][col].visit();
                    matrix[row][col].getTokens().addAll(SharedMemPool.extractTokens(matrix.length));
                    robot.getTokens().addAll(matrix[row][col].getTokens());
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
}
