package algorithms;

public class NumberUtils {


    public static double round(double x, int decimals)
    {

        int decimalsToTen = 10;


        for (int i = 1; i < decimals; i++)
        {
            decimalsToTen *= 10;
        }

        x = x * decimalsToTen;
        x = floor(x + 0.5);
        x = x / decimalsToTen;

        return x;
    }


    public static int floor (double x)
    {
        int intx = (int) x;
        return x < intx ? intx - 1 : intx;
    }

    public static double countDifference(double a, double b)
    {
        if (a > b) return a-b;
        else return b-a;
    }



}
