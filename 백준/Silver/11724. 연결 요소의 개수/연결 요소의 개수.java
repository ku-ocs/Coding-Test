import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[][] graph;
    static boolean[] vis;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        vis = new boolean[N+1];
        graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (vis[i]) continue;
            else {
                queue.offer(i);
                vis[i] = true;
                answer++;
            }
            while (!queue.isEmpty()) {
                int s = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (graph[s][j] == 1 && !vis[j]) {
                        queue.offer(j);
                        vis[j] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

