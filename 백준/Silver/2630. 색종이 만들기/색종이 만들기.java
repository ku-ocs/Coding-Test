import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    static int white = 0; // 0
    static int blue = 0; // 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        StringTokenizer stz;

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        cut(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void cut(int row, int col, int size) {
        if (chk(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            int newSize = size / 2;
            for (int i = row; i < row + size; i += newSize) {
                for (int j = col; j < col + size; j += newSize) {
                    cut(i, j, newSize);
                }
            }
        }
    }

    public static boolean chk(int row, int col, int size) {
        int dat = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != dat) {
                    return false;
                }
            }
        }

        return true;
    }
}
