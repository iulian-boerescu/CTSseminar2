package ro.ase.cts.s02;

import java.io.*;

public class MatrixDataHandler {
    private int[][] matrix;
    private int height;
    private int width;
    private String filename;

    /**
     * Const5ucorul care initializeaza matricea pe baza valorilor primite pentru dimensiuni.Apoi,
     * matricea initializata este scrisa in fisierul filename.
     * @param height
     * @param width
     * @param filename
     */

    public MatrixDataHandler(int height, int width, String filename) {
        this.height = height;
        this.width = width;
        this.filename = filename;
        matrix = new int[height][];
        for (int i = 0; i < height; i++) {
            matrix[i] = new int[width];
        }
        if(!this.writeMatrixFromFile())
        {
            System.out.println("Ceva nu a fost ok la scrierea in fisier");
        }
        /**
         * Metoda scriie matricea in fisierul denumit<this.filename>
         * @return Sereturneaza true daca scrierea s a facut cu succes si false in caz contrar
         * </this.filename>
         */

    }

    public boolean writeMatrixFromFile() {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(height + " " + width + "\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
            return true;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            System.exit(-1);
            return false;
        }
    }

    /**
     * Returneaza valoarea de pe o anumita matrice. Inainte de a returna se va actualiza matricea cu datele din fis
     * @param posHeight Linia
     * @param posWidth Coloana
     * @return Val transmisa
     */

    public int getValueFromPosition(int posHeight, int posWidth) {
        if(!this.readMatrixFromFile())
            System.out.println("Citirea din fisier a esuat! Datele returnate sunt cele existente in <matrix> local");
        return this.matrix[posHeight][posWidth];
    }

    /**
     * Citeste din fisier datele pentru o matrice, conform clasei curente.
     * @return true daca s a citit cu succes si false in caz contrar
     */

    public boolean readMatrixFromFile()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            for (int i = 0; i < height; i++) {
                line = br.readLine();
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
                }
            }
            br.close();
            return true;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    /**
     * Se citestsc val din fisier, se mod val dorita si apoi se rescriu in fisier
     * @param posHeight Linia
     * @param posWidth Coloana
     * @param val Noua Valoare
     */
    public void modifyValueAndUpdateFile(int posHeight, int posWidth, int val) {
        this.readMatrixFromFile();
        this.matrix[posWidth][posWidth] = val;
        this.writeMatrixFromFile();
    }
}
