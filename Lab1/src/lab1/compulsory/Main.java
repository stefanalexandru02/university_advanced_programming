package lab1.compulsory;

/**
 * @author Virna Stefan Alexandru
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n = n*3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;

        int result = 0;
        while(true)
        {
            result = getDigitsSum(n);
            if(result / 10 > 1)
            {
                n = result;
            }
            else
            {
                break;
            }
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    private static int getDigitsSum(int number)
    {
        int sum = 0;
        while(number != 0)
        {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

}
