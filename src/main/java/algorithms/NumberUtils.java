package algorithms;

public class NumberUtils {


    /**
     * Rounds a floating point number to a fixed decimal
     * @param x Number to be rounded
     * @param decimals Amount of decimals wanted
     * @return rounded number
     */
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


    /**
     * Gives the largest integer less than or equal to the given double
     * @param x the double that is to be floored
     * @return Largest integer less than or equal to the given double
     */
    public static int floor (double x)
    {
        int intx = (int) x;
        return x < intx ? intx - 1 : intx;
    }

    /**
     * Counts the difference between two doubles
     * @param a First double
     * @param b Second double
     * @return difference between a and b
     */
    public static double countDifference(double a, double b)
    {
        if (a > b) return a-b;
        else return b-a;
    }



}
