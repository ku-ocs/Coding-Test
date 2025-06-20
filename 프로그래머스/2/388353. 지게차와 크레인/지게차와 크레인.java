import java.util.*;

class Solution {

    static int n, m;
    static String[][] map;
    static boolean[][] vis;
    static Stack<int[]> stack = new Stack<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();

        map = new String[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = storage[i];
            String[] sa = s.split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = sa[j];
            }
        }

        for (String s : requests) {
            String item = s.substring(0,1);
            if (s.length() > 1) {
                clearItem(item);
                continue;
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j].equals(item)) {
                        stack.push(new int[] {i, j});
                        dfs();
                        stack.clear();
                        clearVis();
                    }
                }
            }
            
            pickItem();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j].isBlank()) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void dfs() {
        int[] itemLoc = stack.peek();
        boolean isPick = false;
        
        dfs:
        while(!stack.isEmpty()) {
            int[] xy = stack.pop();
            int x = xy[0];
            int y = xy[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    isPick = true;
                    break dfs;
                }
                
                if (!map[nx][ny].isBlank() || vis[nx][ny]) continue;
                vis[nx][ny] = true;
                stack.push(new int[] {nx, ny});
            }
        }
        
        if (isPick) {
            queue.offer(itemLoc);
        }
    }
    
    public static void pickItem() {
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            map[xy[0]][xy[1]] = "";
        }
    }
    
    public static void clearItem(String item) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals(item)) {
                    map[i][j] = "";
                }
            }
        }
    }
    
    public static void clearVis() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = false;
            }
        }
    }
}