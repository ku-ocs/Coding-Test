import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board1, board2;
    static int l, answer = 0;
    static String s;
    static Queue<String> dirQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());

        board1 = new int[l][l];
        board2 = new int[l][l];
        StringTokenizer stz;

        for (int i = 0; i < l; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < l; j++) {
                int num = Integer.parseInt(stz.nextToken());
                board1[i][j] = num;
                board2[i][j] = num;
            }
        }

        int max = (int) Math.pow(4, 5);

        for(int i = 0; i < max; i++) {
            int num = i;
            int q = 0;
            q += num / 256 * 10000;
            num %= 256;
            q += num / 64 * 1000;
            num %= 64;
            q += num / 16 * 100;
            num %= 16;
            q += num / 4 * 10;
            num %= 4;
            q += num;
            s = q + "";
            while (s.length() < 5) {
                s = "0" + s;
            }
            dirQueue.offer(s);
        }

        for(String s : dirQueue) {
            String[] dArr = s.split("");
            for (String d : dArr) {
                move(Integer.parseInt(d));
            }
            getAnswer();
            reset();
        }

        System.out.println(answer);
    }

    public static void move(int d) {
        while (d != 0) {
            rotate();
            d--;
        }


        for (int i = 0; i < l; i++) {
            int[] moveArr = new int[l];
            int idx = 0;

            for(int j = 0; j < l; j++) {
                int num = board2[i][j];

                if (num == 0) continue;
                if (moveArr[idx] == 0) {
                    moveArr[idx] = num;
                } else if (num == moveArr[idx]) {
                    moveArr[idx++] *= 2;
                } else {
                    moveArr[++idx] = num;
                }
            }

            for (int j = 0; j < l; j++) {
                board2[i][j] = moveArr[j];
            }
        }
    }

    public static void rotate() {
        int[][] rotateBoard = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                rotateBoard[i][j] = board2[j][l - 1 - i];
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                board2[i][j] = rotateBoard[i][j];
            }
        }
    }

    public static void reset() {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                board2[i][j] = board1[i][j];
            }
        }
    }

    public static void getAnswer() {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                answer = Math.max(answer, board2[i][j]);
            }
        }
    }
}

