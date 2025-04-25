import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X, Y, K;
    static int[] dx = new int[] {0, 0, 0, -1, 1};
    static int[] dy = new int[] {0, 1, -1, 0, 0};
    static int[][] board;
    static Dice dice = new Dice();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        X = Integer.parseInt(stz.nextToken());
        Y = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(stz.nextToken());
                board[i][j] = num;
            }
        }

        stz = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(stz.nextToken());
            if (isRoll(dir)) {
                dice.roll(dir);
                bw.write(dice.num1 + "\n");
                if (board[X][Y] == 0) {
                    dice.setValue();
                } else {
                    dice.getValue();
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isRoll(int dir) {
        int nx = X + dx[dir];
        int ny = Y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) return false;
        X = nx;
        Y = ny;
        return true;
    }

    public static class Dice{
        private int num1;
        private int num2;
        private int num3;
        private int num4;
        private int num5;
        private int num6;

        public void roll(int dir) {
            if (dir == 1) {
                int temp = this.num4;
                this.num4 = this.num6;
                this.num6 = this.num3;
                this.num3 = this.num1;
                this.num1 = temp;
            } else if (dir == 2) {
                int temp = this.num4;
                this.num4 = this.num1;
                this.num1 = this.num3;
                this.num3 = this.num6;
                this.num6 = temp;
            } else if (dir == 3) {
                int temp = this.num2;
                this.num2 = this.num1;
                this.num1 = this.num5;
                this.num5 = this.num6;
                this.num6 = temp;
            } else {
                int temp = this.num5;
                this.num5 = this.num1;
                this.num1 = this.num2;
                this.num2 = this.num6;
                this.num6 = temp;
            }
        }

        public void getValue() {
            this.num6 = board[X][Y];
            board[X][Y] = 0;
        }

        public void setValue() {
            board[X][Y] = this.num6;
        }
    }
}