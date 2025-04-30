import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] board;
    static int[][] dir;
    // 첫 시작은 오른쪽 방향 (->) 이므로 오른쪽방향을 0 으로 지정
    static int[] dr = new int[] {0, 1, 0, -1};
    static int[] dc = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        // 보드의 크기
        N = Integer.parseInt(stz.nextToken());
        board = new int[N][N];

        // 사과 개수 및 저장
        stz = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());

            // 사과의 정보 - board 에 2로 저장
            board[r-1][c-1] = 2;
        }

        // 방향 변환 수 및 저장
        stz = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(stz.nextToken());
        dir = new int[K][2];
        for (int i = 0; i < K; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int d;
            if (stz.nextToken().equals("L")) {
                d = -1; // 왼쪽이면 -1 로 저장
            } else {
                d = 1;  // 오른쪽이면 1 로 저장
            }
            dir[i] = new int[] {s, d};
        }

        Snake snake = new Snake();
        int idx = 0;
        int dirT = dir[idx][0];
        int dirD = dir[idx][1];
        int i = 1;

        while (true) {
            if(!snake.move()) {
                break;
            }
            if (dirT == snake.t) {
                snake.rotate(dirD);
                idx++;
                if (idx < dir.length) {
                    dirT = dir[idx][0];
                    dirD = dir[idx][1];
                }
            }
        }

        System.out.println(snake.t);

        br.close();
    }

    public static class Snake {
        int r = 0;
        int c = 0;
        int t = 0;
        int dir = 0;
        Queue<int[]> body = new LinkedList<>();

        Snake() {
            body.offer(new int[] {0,0});
            board[0][0] = 1;
        }

        public void rotate(int i) {
            this.dir = (this.dir + i + 4) % 4;
        }

        public boolean move() {
            int r = this.r + dr[this.dir];
            int c = this.c + dc[this.dir];
            this.t++;
            if (isOver(r, c)) {
                return false;
            }
            this.r = r;
            this.c = c;
            body.offer(new int[] {this.r, this.c});
            if (!eatApple(this.r, this.c)){
                int[] rc = body.poll();
                int br = rc[0];
                int bc = rc[1];
                board[br][bc] = 0;
            }
            board[this.r][this.c] = 1;
            return true;
        }

        public boolean eatApple(int r, int c) {
            if (board[r][c] == 2) {
                return true;
            }
            return false;
        }

        public boolean isOver(int r, int c) {
            if (r < 0 || c < 0 || r >= N || c >= N || board[r][c] == 1) {
                return true;
            }
            return false;
        }
    }
}