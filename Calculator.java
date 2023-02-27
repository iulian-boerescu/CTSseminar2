package ro.ase.cts.s02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    /**
     * Aceasta metoda calculeaza suma dintre x ridicat la puterea a-5a si y ridicat la putearea a-7a.
     * @return Returneaza rezultatul calculat.
     * @throws IOException Arunca exceptie daca datele introduse nu au formatul corect.
     */
    public double calculate() throws IOException {

        double result = 0.0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Tastati valoarea pentru X:");
        double x = Double.parseDouble(reader.readLine());
        try {
            if (x<=0){
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e){
            throw new IOException("X invalid");
        }


        System.out.println("Tastati valoarea pentru Y:");
        double y = Double.parseDouble(reader.readLine());

        try {

            if (y<=0){
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e){
            throw new IOException("Y invalid");
        }

            result = raiseToPower(x, y);

            return result;
        }
        public double raiseToPower(double x, double y){
            double x5 = x;
            for (int i = 1; i < 5; i++) {
                x5 *= x;
            }

            double y7 = y;
            for (int i = 1; i < 7; i++) {
                y7 *= y;
            }

            return x5 + y7;
        }
    }

