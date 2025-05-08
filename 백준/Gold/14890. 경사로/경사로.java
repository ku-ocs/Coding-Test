import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, L, answer;
    static int[][] map;
    static int[][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        L = Integer.parseInt(stz.nextToken());

        map = new int[N][N];
        vis = new int[N][N];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            checkRows(i);
        }
        resetVis();
        for (int i = 0; i < N; i++) {
            checkCols(i);
        }

        System.out.println(answer);
    }

    public static void checkRows(int r) {
        int temp = map[r][0];
        for(int i = 1; i < N; i++) {
            if (temp == map[r][i]) {
                continue;
            }

            if (Math.abs(temp - map[r][i]) > 1) {
                return;
            }

            int temp2 = map[r][i];

            if (temp > temp2) {
                for (int j = 0; j < L; j++) {
                    if (i+j >= N || temp2 != map[r][i+j]) return;
                    if(vis[r][i+j] == 1)return;
                    vis[r][i+j] = 1;
                }
            } else {
                for (int j = 0; j < L; j++) {
                    if (i-1-j < 0 || temp != map[r][i-1-j]) return;
                    if (vis[r][i-1-j] == 1) return;
                    vis[r][i-1-j] = 1;
                }
            }

            temp = temp2;
        }
        answer++;
    }

    public static void checkCols(int c) {
        int temp = map[0][c];
        for(int i = 1; i < N; i++) {
            if (temp == map[i][c]) {
                continue;
            }

            if (Math.abs(temp - map[i][c]) > 1) {
                return;
            }

            int temp2 = map[i][c];

            if (temp > temp2) {
                for (int j = 0; j < L; j++) {
                    if (i+j >= N || temp2 != map[i+j][c] )return;
                    if(vis[i+j][c] == 1)return;

                    vis[i+j][c] = 1;
                }
            } else {
                for (int j = 0; j < L; j++) {
                    if (i-1-j < 0 || temp != map[i-1-j][c]) return;
                    if (vis[i-1-j][c] == 1) return;
                    vis[i-1-j][c] = 1;
                }
            }

            temp = temp2;
        }
        answer++;
    }

    public static void resetVis() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                vis[i][j] = 0;
            }
        }
    }
}
