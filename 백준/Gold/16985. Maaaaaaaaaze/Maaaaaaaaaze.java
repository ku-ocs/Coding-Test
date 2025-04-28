import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int[] selected = new int[5];
    static int[] dx = new int[] {1, -1, 0, 0, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1, 0, 0};
    static int[] dz = new int[] {0, 0, 0, 0, 1, -1};
    static int[][][] mainMaze = new int[5][5][5];
    static int[][][] mazeRoute = new int[5][5][5];
    static int[][][] vis = new int[5][5][5];
    static int[][][][] mazePart = new int[5][4][5][5];
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                stz = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    mazePart[i][0][j][k] = Integer.parseInt(stz.nextToken());
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            mazePart[i][1] = rotate(mazePart[i][0]);
            mazePart[i][2] = rotate(mazePart[i][1]);
            mazePart[i][3] = rotate(mazePart[i][2]);
        }

        bt(0);

        if (answer == 0) {
            answer = -1;
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }


    public static int[][] rotate(int[][] maze) {
        int[][] tempMaze = new int[5][5];
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                tempMaze[y][5-x-1] = maze[x][y];
            }
        }
        return tempMaze;
    }

    public static void bt(int selectTime) {
        if (selectTime == 5) {
            if(mainMaze[0][0][0] == 0) {
                return;
            }
            reset();
            bfs();
            getRoute();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if(selected[i] == 1) {
                continue;
            }
            for (int j = 0; j < 4; j++) {
                selected[i] = 1;
                mainMaze[selectTime] = mazePart[i][j];
                bt(selectTime+1);
                selected[i] = 0;
            }
        }
    }


    public static void bfs() {
        queue.add(new int[] {0, 0, 0});
        vis[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[]xyz = queue.poll();
            int x = xyz[0];
            int y = xyz[1];
            int z = xyz[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5) continue;
                if (vis[nx][ny][nz] == 1 || mainMaze[nx][ny][nz] == 0) continue;
                vis[nx][ny][nz] = 1;
                mazeRoute[nx][ny][nz] = mazeRoute[x][y][z] + 1;
                queue.offer(new int[] {nx, ny, nz});
            }
        }
    }

    public static void getRoute() {
        int route = mazeRoute[4][4][4];
        if(route > 0) {
            if(answer == 0) {
                answer = route;
            } else {
                answer = Math.min(answer, route);
            }
        }
    }

    public static void reset() {
        vis = new int[5][5][5];
        mazeRoute = new int[5][5][5];
        queue.clear();
    }
}