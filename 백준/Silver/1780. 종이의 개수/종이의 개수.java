import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int black = 0; // -1
    static int gray = 0;  // 0
    static int white = 0; // 1

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        cut(0, 0, n);

        System.out.println(black);
        System.out.println(gray);
        System.out.println(white);
    }

    public static void cut(int row, int col, int size) {
        if (chkColor(row, col, size)) {
            if (board[row][col] == -1) {
                black++;
                return;
            } else if (board[row][col] == 0) {
                gray++;
                return;
            } else {
                white++;
                return;
            }
        } else {
            int newSize = size / 3;
            for (int i = row; i < row + size; i += newSize ) {
                for (int j = col; j < col + size; j += newSize) {
                    cut(i, j, newSize);
                }
            }
        }
    }

    public static boolean chkColor(int row, int col, int size) {
        int color = board[row][col];

        for(int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
