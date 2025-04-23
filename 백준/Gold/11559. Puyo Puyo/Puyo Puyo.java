import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] board = new int[12][6];
    static int[][] vis = new int[12][6];
    static int cnt, area;
    static boolean bang = false;
    static Queue<int[]> dQ = new LinkedList<>(); // 지우는 뿌요들의 좌표값
    static Queue<int[]> queue = new LinkedList<>(); // BFS 큐
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String[] puyos = br.readLine().split("");

            for (int j = 0; j < 6; j++) {
                int val;
                if (puyos[j].equals("R")) {
                    val = 1;
                } else if (puyos[j].equals("G")) {
                    val = 2;
                } else if (puyos[j].equals("B")) {
                    val = 3;
                } else if (puyos[j].equals("P")) {
                    val = 4;
                } else if (puyos[j].equals("Y")) {
                    val = 5;
                } else {
                    val = 0;
                }
                board[i][j] = val;
            }
        }

        bfs();
    }

    public static void bfs() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if(board[i][j] != 0 && vis[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    dQ.offer(new int[] {i, j});
                    vis[i][j] = 1;
                    area = 1;
                }

                while(!queue.isEmpty()) {
                    int[] xy = queue.poll();
                    int x = xy[0];
                    int y = xy[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                        if (vis[nx][ny] == 1 || board[nx][ny] != board[x][y]) continue;
                        vis[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                        dQ.offer(new int[] {nx, ny});
                        area++;
                    }
                }

                if (area >= 4) {
                    bang();
                    bang = true;
                    area = 0;
                } else {
                    dQ.clear();
                }
            }
        }



        if (bang) {
            cnt++;
            bang = false;
            down();
            visReset();
            bfs();
        } else {
            System.out.println(cnt);
        }
    }

    public static void visReset() {
        vis = new int[12][6];
    }


    public static void bang() {
        while(!dQ.isEmpty()) {
            int[] xy = dQ.poll();
            board[xy[0]][xy[1]] = 0;
        }
    }

    public static void down() {
        for (int j = 0; j < 6; j++) {
            int idx = 11;
            for (int i = 11; i >= 0; i--) {
                if (board[i][j] == 0) continue;
                board[idx--][j] = board[i][j];
                if (i == idx+1) continue;
                board[i][j] = 0;
            }
        }
    }
}