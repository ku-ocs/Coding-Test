import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        room = new int[N][M];

        stz = new StringTokenizer(br.readLine(), " ");
        int sr = Integer.parseInt(stz.nextToken());
        int sc = Integer.parseInt(stz.nextToken());
        int sd = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        clean(sr, sc, sd);

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void clean(int r, int c, int d) {
        if (room[r][c] == 0) {
            room[r][c] = 2; // 기둥이 1로 있으므로 청소한 칸은 2로 표시.
            answer++;
        }

        if(checkAround(r, c)) {
            d = (d+3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (room[nr][nc] == 0) {
                clean(nr, nc, d);
            } else {
                clean(r, c, d);
            }
        } else {
            int bd = (d+2) % 4;
            int nr = r + dr[bd];
            int nc = c + dc[bd];
            if (room[nr][nc] == 1) {
                return;
            } else {
                clean(nr, nc, d);
            }
        }
    }

    public static boolean checkAround(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (room[nr][nc] == 0) {
                return true;
            }
        }
        return false;
    }
}