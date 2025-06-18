import java.util.*;

class Solution {
    static Queue<int[]> bfsQueue = new LinkedList<>();
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] answer = new int[2];
    static boolean[][] vis;
    static int numberOfArea, maxSizeOfOneArea;

    public int[] solution(int m, int n, int[][] picture) {
        vis = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        bfsQueue.clear();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !vis[i][j]) {
                    bfsQueue.offer(new int[] {i, j});
                    vis[i][j] = true;
                    bfs(m, n, picture);
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public static void bfs(int m, int n, int[][] picture) {
        numberOfArea++;
        int area = 1;

        while(!bfsQueue.isEmpty()) {
            int[] xy = bfsQueue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (picture[nx][ny] != picture[x][y] || vis[nx][ny]) continue;
                bfsQueue.offer(new int[] {nx, ny});
                vis[nx][ny] = true;
                area++;
            }
        }
        
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
    }
}