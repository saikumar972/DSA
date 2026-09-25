package ArrayAndHashing;

import java.util.HashSet;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = sudoku(board);
        System.out.println(result);
    }

    private static boolean sudoku(char[][] board) {
        boolean result = true;
        for(int i=0;i< board.length;i++){
            HashSet<Character> rowHashSet = new HashSet<>();
            HashSet<Character> columnHashSet = new HashSet<>();
            HashSet<Character> subGridSet = new HashSet<>();
            for(int j=0;j< board.length;j++){
                int m = j/3+(i/3)*3;
                int n = j%3+(i%3)*3;
                if (board[i][j] != '.') {
                    if (rowHashSet.contains(board[i][j])) {
                        return false;
                    }
                    rowHashSet.add(board[i][j]);
                }

                if (board[j][i] != '.') {
                    if (columnHashSet.contains(board[j][i])) {
                        return false;
                    }
                    columnHashSet.add(board[j][i]);
                }

                if (board[m][n] != '.') {
                    if (subGridSet.contains(board[m][n])) {
                        return false;
                    }
                    subGridSet.add(board[m][n]);
                }

            }
        }
        return result;
    }
}
