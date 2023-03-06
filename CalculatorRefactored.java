package ro.ase.cts.s02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class CalculatorRefactored {

    public double calculatePowXPlusPowY() throws IOException {
        double x = readDoubleValueFromConsole("Tastati valoare pentru X:");
        double y = readDoubleValueFromConsole("Tastati valoare pentru Y:");
        double xToThePowerOfFive = calculatePower(x, 5);
        double yToThePowerOfSeven = calculatePower(y, 7);
        double result = xToThePowerOfFive + yToThePowerOfSeven;
        return result;
    }

    private double calculatePower(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    private double readDoubleValueFromConsole(String messageToShow)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(messageToShow);
            return Double.parseDouble(reader.readLine());
        }
        catch (NumberFormatException | IOException exception)
        {
            System.out.println(exception.getMessage());
            if(exception.getMessage().contains("#STOP"))
                System.exit(-1);
            return readDoubleValueFromConsole(messageToShow);
        }
    }
}