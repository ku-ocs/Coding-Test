import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, rX, rY, bX, bY, holeX, holeY, answer = Integer.MIN_VALUE;
    static String[][] board;
    static int[][][][] vis;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static Queue<Beads> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        board = new String[N][M];
        vis = new int[N][M][N][M];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            String[] sArr = stz.nextToken().split("");
            for (int j = 0; j < M; j++) {
                String s = sArr[j];
                if (s.equals("O")) {
                    holeX = i;
                    holeY = j;
                } else if (s.equals("R")) {
                    rX = i;
                    rY = j;
                } else if (s.equals("B")) {
                    bX = i;
                    bY = j;
                }
                board[i][j] = s;
            }
        }

        Beads beads = new Beads(rX, rY, bX, bY, 0);
        vis[rX][rY][bX][bY] = 1;
        queue.offer(beads);

        bfs();

        if (answer < 0) {
            answer = -1;
        }

        bw.write(answer + "");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Beads beads = queue.poll();
            if (beads.cnt >= 10) {
                continue;
            }

            boolean isBlueFirst;

            int rx = beads.redX;
            int ry = beads.redY;
            int bx = beads.blueX;
            int by = beads.blueY;
            int cnt = beads.cnt + 1;

            for (int i = 0; i < 4; i++) {
                isBlueFirst = beads.isBlueFirst(i);

                int newRX = rx;
                int newRY = ry;
                int newBX = bx;
                int newBY = by;
                boolean redDrop = false;
                boolean blueDrop = false;

                while (!board[newRX][newRY].equals("#")) {
                    if (board[newRX][newRY].equals("O")) {
                        redDrop = true;
                        break;
                    }
                    newRX += dx[i];
                    newRY += dy[i];
                }

                while (!board[newBX][newBY].equals("#")) {
                    if (board[newBX][newBY].equals("O")) {
                        blueDrop = true;
                        break;
                    }
                    newBX += dx[i];
                    newBY += dy[i];
                }

                if (blueDrop) {
                    continue;
                }

                if (redDrop) {
                    answer = cnt;
                    return;
                }

                newBX -= dx[i];
                newBY -= dy[i];
                newRX -= dx[i];
                newRY -= dy[i];

                if (newRX == newBX && newRY == newBY) {
                    if (i == 0 || i == 2) {
                        if (isBlueFirst) {
                            newRX -= dx[i];
                        } else {
                            newBX -= dx[i];
                        }
                    } else {
                        if (isBlueFirst) {
                            newRY -= dy[i];
                        } else {
                            newBY -= dy[i];
                        }
                    }
                }

                if (vis[newRX][newRY][newBX][newBY] == 0) {
                    vis[newRX][newRY][newBX][newBY] = 1;
                    queue.offer(new Beads(newRX, newRY, newBX, newBY, cnt));
                }
            }
        }
    }

    public static class Beads {
        private int redX;
        private int redY;
        private int blueX;
        private int blueY;
        private int cnt;

        Beads(int rx, int ry, int bx, int by, int cnt) {
            this.redX = rx;
            this.redY = ry;
            this.blueX = bx;
            this.blueY = by;
            this.cnt = cnt;
        }

        public boolean isBlueFirst(int dir) {
            if (dir == 0) {
                return this.redX > this.blueX;
            } else if (dir == 1) {
                return this.blueY > this.redY;
            } else if (dir == 2) {
                return this.blueX > this.redX;
            } else {
                return this.redY > this.blueY;
            }
        }
    }
}
