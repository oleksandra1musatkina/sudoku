package sk.itsovy;

public class Sudoku {

    public void writeSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println("+------+------+------+");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("|");
                System.out.print(sudoku[i][j] == 0 ? " " : sudoku[i][j]);

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println("+------+------+------+");

    }


    private boolean cisloVRiadku(int riadok, int number, int[][] sudoku) {
        for (int i = 0; i < 9; i++)
            if (sudoku[riadok][i] == number)
                return true;

        return false;
    }

    private boolean cisloVStlpci(int stlpec, int number, int[][] sudoku) {
        for (int i = 0; i < 9; i++)
            if (sudoku[i][stlpec] == number)
                return true;

        return false;
    }

    private boolean cisloVStvorci(int riadok, int stlpec, int number, int[][] sudoku) {
        int r = riadok - riadok % 3;
        int c = stlpec - stlpec % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (sudoku[i][j] == number)
                    return true;

        return false;
    }

    private boolean platiaVsetkyPravidla(int riadok, int stlpec, int number, int[][] sudoku) {
        return !cisloVRiadku(riadok, number, sudoku) && !cisloVStlpci(stlpec, number, sudoku) && !cisloVStvorci(riadok, stlpec, number, sudoku);
    }

    public int[][] solve(int[][] sudoku) {
        for (int riadok = 0; riadok < 9; riadok++) {
            for (int stlpec = 0; stlpec < 9; stlpec++) {
                if (sudoku[riadok][stlpec] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (platiaVsetkyPravidla(riadok, stlpec, number, sudoku)) {
                            sudoku[riadok][stlpec] = number;
                            if (solve(sudoku) != null) {
                                return sudoku;
                            } else {
                                sudoku[riadok][stlpec] = 0;
                            }
                        }
                    }

                    return null;
                }
            }
        }

        return sudoku;
    }


}
