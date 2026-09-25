package ArrayAndHashing;

import java.util.HashSet;

public class ZeroStripping {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3, 4,  5,  6},
                {7,  8,  9, 10, 11, 12},
                {13, 14, 0, 16, 17, 18}
        };
        int[][] matrix2 = {
                {1,  2,  3, 4,  5,  6},
                {7,  8,  9, 10, 11, 12},
                {13, 14, 0, 16, 17, 18}
        };
        hashSetZeroTracking(matrix);
        System.out.println();
        zeroTracking(matrix2);
        int[][] matrix3 = {{0,1,2,0},
                            {3,4,5,2},
                            {1,3,1,5}};
        setZeroes(matrix3);
    }

    public static void setZeroes(int[][] matrix) {
        boolean hasRowZero = false;
        boolean hasColumnZero = false;
        for(int i = 0; i< matrix.length; i++){
            if(matrix[i][0]==0){
                hasColumnZero = true;
                break;
            }
        }
        for(int j = 0; j< matrix[0].length; j++){
            if(matrix[0][j]==0){
                hasRowZero = true;
                break;
            }
        }

        for(int i = 1; i< matrix.length; i++){
            for(int j = 1; j< matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }

            }
        }

        if(hasColumnZero){
            for(int i = 0; i< matrix.length; i++){
                matrix[i][0]=0;
            }
        }

        if(hasRowZero){
            for(int j = 0; j< matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }

        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void zeroTracking(int[][] matrix) {
        boolean hasRowZero = false;
        boolean hasColumnZero = false;
        for(int i = 0; i< matrix.length; i++){
            if(matrix[i][0]==0){
                hasColumnZero = true;
                break;
            }
        }
        for(int j = 0; j< matrix[0].length; j++){
            if(matrix[0][j]==0){
                hasRowZero = true;
                break;
            }
        }

        for(int i = 1; i< matrix.length; i++){
            for(int j = 1; j< matrix[i].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][0] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(hasColumnZero){
            for(int i = 0; i< matrix.length; i++){
                matrix[i][0]=0;
            }
        }

        if(hasRowZero){
            for(int j = 0; j< matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }

    private static void hashSetZeroTracking(int[][] matrix) {
        HashSet<Integer> rowHashSet = new HashSet<>();
        HashSet<Integer> columnHashSet = new HashSet<>();
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j]==0){
                    rowHashSet.add(i);
                    columnHashSet.add(j);
                }
            }
        }
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(rowHashSet.contains(i) || columnHashSet.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
