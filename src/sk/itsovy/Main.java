package sk.itsovy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("zadaj sudoku: ");
        String cislaNaSudok = scanner.next();
        if (cislaNaSudok.length() != 81) {
            System.out.println("nespravny format!");
            return;
        }

        int[][] sudoku = new int[9][9];

        int poradie = 0;
        for (char c : cislaNaSudok.toCharArray()) {
            int riadok = poradie % 9;
            int stlpec = poradie / 9;
            sudoku[stlpec][riadok] = Character.getNumericValue(c);

            System.out.println("cislo: " + c + ", r: " + riadok + ", s: " + stlpec);
            poradie++;
        }

        Sudoku sudokuClass = new Sudoku();
        sudokuClass.writeSudoku(sudoku);
        sudokuClass.writeSudoku(sudokuClass.solve(sudoku));

    }

}