import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, answer = Integer.MAX_VALUE;
    static int[][] map, lp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        H = Integer.parseInt(stz.nextToken());

        map = new int[H][N];
        lp = new int[H*(N-1)][2];

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            map[r-1][c-1] = 1;
        }

        int pIdx = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N-1; j++) {
                lp[pIdx++] = new int[] {i, j};
            }
        }

        int max = 0;
        while (true) {
            bt(0, 0, max);
            if (answer == max || answer == -1) {
                break;
            }
            max++;
        }

        System.out.println(answer);
    }


    public static boolean check() {
        int temp;
        for (int i = 0; i < N; i++) {
            temp = i;

            for (int j = 0; j < H; j++) {
                if (map[j][temp] == 1) {
                    temp += 1;
                    continue;
                }

                if (temp > 0 && map[j][temp-1] == 1) {
                    temp -= 1;
                }
            }

            if (temp != i) {
                return false;
            }
        }
        return true;
    }

    public static void bt(int p, int cnt, int max) {
        if (max > 3) {
            answer = -1;
            return;
        }

        if (max == cnt) {
            if (check()) {
                answer = max;
            }
            return;
        }

        for (int i = p; i < (N-1)*H; i++) {
            int r = lp[i][0];
            int c = lp[i][1];

            if (map[r][c] == 1) {
                continue;
            }

            map[r][c] = 1;
            bt(i+1, cnt+1, max);
            if (answer == max) {
                return;
            }
            map[r][c] = 0;
        }
    }
}
