import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, answer;
    static List[][] board;
    static List<int[]> list = new ArrayList<>();
    static int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        board = new List[N][N];

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(stz.nextToken()) - 1;
            int c = Integer.parseInt(stz.nextToken()) - 1;
            int m = Integer.parseInt(stz.nextToken());
            int s = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());

            list.add(new int[]{r, c, m, s, d});
        }

        for (int i = 0; i < K; i++) {
            resetBoard();
            move();
        }

        for(int[] arr : list) {
            answer += arr[2];
        }

        System.out.println(answer);
    }

    public static void move() {
        for (int i = 0; i < list.size(); i++) {
            int[] fireBall = list.get(i);

            int r = fireBall[0];
            int c = fireBall[1];
            int m = fireBall[2];
            int s = fireBall[3];
            int d = fireBall[4];

            int nr = r + dx[d] * s;
            int nc = c + dy[d] * s;

            while(nr < 0 || nr >= N) {
                nr = (nr + N) % N;
            }
            while (nc < 0 || nc >= N) {
                nc = (nc + N) % N;
            }

            board[nr][nc].add(new int[] {m, s, d});
        }

        list.clear();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].size() >= 2) {
                    merge(i, j, board);
                } else {
                    addFireBall(i, j, board);
                }
            }
        }
    }

    public static void addFireBall(int r, int c, List[][] board) {
        List<int[]> fireBalls = board[r][c];
        for (int[] fireBall : fireBalls) {
            int fm = fireBall[0];
            int fs = fireBall[1];
            int fd = fireBall[2];

            list.add(new int[]{r, c, fm, fs, fd});
        }
    }

    public static void merge(int r, int c, List[][] board) {
        List<int[]> fireBalls = board[r][c];
        int mTotal = 0;
        int sTotal = 0;
        int cnt = 0;
        boolean even = true;
        boolean odd = true;

        for (int[] fireBall : fireBalls) {
            int fm = fireBall[0];
            int fs = fireBall[1];
            int fd = fireBall[2];

            cnt++;
            mTotal += fm;
            sTotal += fs;
            if (fd % 2 == 0) {
                odd = false;
            } else {
                even = false;
            }
        }

        if (mTotal < 5) {
            return;
        }

        int dM = mTotal / 5;
        int dS = sTotal / cnt;

        if (even || odd) {
            list.add(new int[] {r, c, dM, dS, 0});
            list.add(new int[] {r, c, dM, dS, 2});
            list.add(new int[] {r, c, dM, dS, 4});
            list.add(new int[] {r, c, dM, dS, 6});
        } else {
            list.add(new int[] {r, c, dM, dS, 1});
            list.add(new int[] {r, c, dM, dS, 3});
            list.add(new int[] {r, c, dM, dS, 5});
            list.add(new int[] {r, c, dM, dS, 7});
        }
    }

    public static void resetBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }
    }
}