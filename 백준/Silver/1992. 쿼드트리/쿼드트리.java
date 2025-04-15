import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] sArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
               board[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        cut(0, 0, n);

        bw.flush();

        br.close();
        bw.close();
    }


    public static void cut(int row, int col, int size) throws IOException {
        if (chk(row, col, size)) {
            if (board[row][col] == 1) {
                bw.write(1 + "");
            } else {
                bw.write(0 + "");
            }
        } else {
            bw.write("(");
            int newSize = size / 2;
            for (int i = row; i < row + size; i += newSize) {
                for (int j = col; j < col + size; j += newSize) {
                    cut(i, j, newSize);
                }
            }
            bw.write(")");
        }
    }


    public static boolean chk(int row, int col, int size) {
        int dat = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (dat != board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
