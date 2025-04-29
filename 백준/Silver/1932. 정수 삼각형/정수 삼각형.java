import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] board, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        board = new int[N][N];
        sum = new int[N][N];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                if (stz.hasMoreTokens()) {
                    board[i][j] = Integer.parseInt(stz.nextToken());
                }
            }
        }

        sum[0][0] = board[0][0];
        answer = sum[0][0];


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    sum[i][j] = board[i][j] + sum[i-1][j];
                } else {
                    sum[i][j] = Math.max(sum[i][j], board[i][j] + Math.max(sum[i-1][j], sum[i-1][j-1]));
                }

                answer = Math.max(answer, sum[i][j]);
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }
}