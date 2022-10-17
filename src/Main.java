/*
C5 = 503 % 5 = 3 | C=A⊕B
C7 = 503 % 7 = 6 | float
C11 = 503 % 11 = 8 | Знайти середнє значення елементів кожного рядка матриці
 */
public class Main {
    public static void main(String[] args) {
        final float[][] A = {{5, -3, 8, 2},
                             {2, 7, 1,  9},
                             {6, 4, -2, 4}};
        final float[][] B = {{6, -2, 7},
                             {3, 0,  4},
                             {2, 1,  8}};

        MatrixCheck(A);
        MatrixCheck(B);

        final int n = A.length + B.length;
        final int m = A[0].length + B[0].length;

        float[][] C = new float[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i][j] = 0;

        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                C[i][j] = A[i][j];

        for (int i = 0; i < B.length; i++)
            for (int j = 0; j < B.length; j++)
                C[i + A.length][j + A[0].length] = B[i][j];

        System.out.print("Матриця C має вигляд: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.printf("%5.1f ", C[i][j]);
            System.out.println("\n");
        }

        System.out.print("Середнє значення елементів кожного рядка: \n");
        for (int i = 0; i < n;i++) {
            float avg = 0;
            for (int j = 0; j < m; j++) {
                avg += C[i][j];
            }
            avg /= m;
            System.out.printf("%d Рядок: %.2f\n",(i + 1), avg);
        }
    }
    public static void MatrixCheck(float[][] Matrix){
        int row_length = Matrix[0].length;

        for (int i = 0; i < Matrix.length; i++){
            if (Matrix[i].length != row_length){
                System.out.println("Некоректно введена матриця");
                System.exit(0);
            }
        }
    }
}
