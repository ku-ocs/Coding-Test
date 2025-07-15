import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] vis;
    static int[][] graph, answer;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        vis = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        answer = new int[N + 1][N + 1];

        StringTokenizer stz;
        for (int i = 1; i <= N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bfs(i, j);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void init() {
        queue.clear();
        Arrays.fill(vis, false);
    }

    public static void bfs(int s, int e) {
        init();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(!vis[i] && graph[n][i] == 1) {
                    if (i == e) {
                        answer[s][e] = 1;
                        return;
                    }
                    queue.offer(i);
                    vis[i] = true;
                }
            }
        }
    }
}