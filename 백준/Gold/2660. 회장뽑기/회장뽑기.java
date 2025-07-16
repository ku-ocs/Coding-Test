import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[] vis;
    static TreeMap<Integer, List<Integer>> scoreMap = new TreeMap<>();
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;

        N = Integer.parseInt(br.readLine());
        vis = new boolean[N+1];
        graph= new int[N+1][N+1];
        while (true) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());
            if (s == -1 && e == -1) break;
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int minScore = scoreMap.firstKey();
        List<Integer> list = scoreMap.get(minScore);
        bw.write(minScore + " " + list.size() + "\n");
        for (int i : list) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int n) {
        init();
        int maxScore = 0;
        vis[n] = true;
        queue.offer(new int[] {n, 0});
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int node = arr[0];
            int score = arr[1];
            maxScore = Math.max(maxScore, score);
            for (int i = 1; i <= N; i++) {
                if (i == n || vis[i] || graph[node][i] != 1) continue;
                vis[i] = true;
                queue.offer(new int[] {i, score+1});
            }
        }

        List<Integer> list = scoreMap.getOrDefault(maxScore, new LinkedList<>());
        list.add(n);
        scoreMap.put(maxScore, list);
    }

    public static void init() {
        Arrays.fill(vis, false);
        queue.clear();
    }
}
