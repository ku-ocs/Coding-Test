import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(stz.nextToken());

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < num; i++) {
            stz = new StringTokenizer(br.readLine(), " ");

            int col = Integer.parseInt(stz.nextToken());
            int row = Integer.parseInt(stz.nextToken());
            int cnt = Integer.parseInt(stz.nextToken());

            int[][] board = new int[row][col];
            int[][] vis = new int[row][col];
            int bug = 0;
            queue.clear();

            for (int j = 0; j < cnt; j++) {
                stz = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(stz.nextToken());
                int x = Integer.parseInt(stz.nextToken());

                board[x][y] = 1;
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (board[j][k] == 1 && vis[j][k] == 0) {
                        queue.add(new int[] {j, k});
                        vis[j][k] = 1;
                        bug++;
                    }

                    while(!queue.isEmpty()) {
                        int[] xy = queue.poll();
                        int x = xy[0];
                        int y = xy[1];

                        for (int l = 0; l < 4; l++) {
                            int nx = x + dx[l];
                            int ny = y + dy[l];

                            if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                            if (board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
                            vis[nx][ny] = 1;
                            queue.add(new int[] {nx, ny});
                        }
                    }
                }
            }

            System.out.println(bug);
        }
    }
}
