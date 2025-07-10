import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, answer;
    static int[][] graph;
    static boolean[] vis;
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        S = Integer.parseInt(stz.nextToken());

        graph = new int[N+1][N+1];
        vis = new boolean[N+1];

        for (int i = 1; i <= M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(S);
        bw.write("\n");
        Arrays.fill(vis, false);
        bfs();

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() throws IOException{
        queue.offer(S);
        vis[S] = true;
        while(!queue.isEmpty()) {
            int s = queue.poll();
            bw.write(s + " ");
            for (int i = 1; i <= N; i++) {
                if (!vis[i] && graph[s][i] == 1) {
                    queue.offer(i);
                    vis[i] = true;
                }
            }
        }
    }

    public static void dfs(int s) throws IOException{
        bw.write(s + " ");
        vis[s] = true;
        for (int i = 1; i <= N; i++) {
            if (!vis[i] && graph[s][i] == 1) {
                dfs(i);
            }
        }
    }
}