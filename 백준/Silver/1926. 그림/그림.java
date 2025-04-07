import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int row = Integer.parseInt(stz.nextToken());
        int col = Integer.parseInt(stz.nextToken());

        // 도화지, 방문, 그림의 숫자, 최대 넓이
        int[][] board = new int[row][col];
        int[][] vis = new int[row][col];
        int cnt = 0;
        int max = 0;

        // 도화지 생성
        for (int i = 0; i < row; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();

        // 방향 배열
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // 시작점 위치 확인
                // 색칠되어 있지만 방문하지 않은 위치
                if(board[r][c] == 1 && vis[r][c] == 0) {
                    queue.add(new int[] {r, c});
                    vis[r][c] = 1;
                    cnt++;
                }

                // 그림의 넓이
                int area = 0;

                while (!queue.isEmpty()) {
                    int[] p = queue.poll();
                    int x = p[0];
                    int y = p[1];
                    area++;

                    // 상하좌우 확인
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                        if (vis[nx][ny] == 1 || board[nx][ny] == 0) continue;
                        vis[nx][ny] = 1;
                        queue.add(new int[] {nx, ny});
                    }
                }

                // 현재값과 그림의 넓이 값 비교
                max = Math.max(max, area);
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}
