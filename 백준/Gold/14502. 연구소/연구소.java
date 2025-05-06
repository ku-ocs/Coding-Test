import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt, answer, lCnt, area;
    static int[][] L;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0 ,1};
    static int[][] room, tempRoom, virus;
    static Queue<int[]> virusQueue = new LinkedList<>();
    static Queue<int[]> tempQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        room = new int[N][M];
        tempRoom = new int[N][M];
        virus = new int[N][M];
        area = M*N;
        L = new int[area][2];
        int lIdx = 0;

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(stz.nextToken());
                room[i][j] = num;
                tempRoom[i][j] = num;
                L[lIdx++] = new int[] {i, j};

                if ( num == 1) {
                    lCnt++;
                }

                if ( num == 2) {
                    virusQueue.offer(new int[] {i, j});
                    tempQueue.offer(new int[] {i, j});
                    virus[i][j] = 1;
                }
            }
        }

        bt(0, 0);

        System.out.println(answer);
    }

    public static void bt(int recursionTime, int l) {
        if(recursionTime == 3) {
            bfs();
            checkAnswer();
            reset();
            return;
        }

        for (int i = l; i < L.length; i++) {
            int[] rc = L[i];
            int x = rc[0];
            int y = rc[1];

            if (room[x][y] != 0) {
                continue;
            }

            room[x][y] = 1;
            lCnt++;
            bt(recursionTime+1, i);
            room[x][y] = 0;
            lCnt--;
        }
    }

    public static void bfs() {
        while (!virusQueue.isEmpty()) {
            int[] xy = virusQueue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (room[nx][ny] != 0 || virus[nx][ny] == 1) continue;
                virus[nx][ny] = 1;
                virusQueue.offer(new int[] {nx, ny});
            }
        }
    }


    public static void reset() {
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus[i][j] = 0;
            }
        }

        virusQueue.clear();

        for (int[] virus : tempQueue) {
            virusQueue.offer(virus);
            Main.virus[virus[0]][virus[1]] = 1;
        }
    }

    public static void checkAnswer() {
        for (int[] arr : virus) {
            for (int i : arr) {
                if (i == 1) {
                    cnt++;
                }
            }
        }

        answer = Math.max(answer, area - lCnt - cnt);
    }
}
