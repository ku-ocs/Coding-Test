import java.util.*;
import java.io.*;

public class Main {
    static int N, M, minCnt = Integer.MAX_VALUE, answer;
    static boolean[] vis;
    static ArrayList<Integer>[] lineList;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        lineList = new ArrayList[N+1];
        vis = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            lineList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());

            lineList[s].add(e);
            lineList[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            cntCB(i);
        }

        System.out.println(answer);
    }

    public static void cntCB(int i) {
        int cb = 0;
        init();
        queue.offer(new int[] {i, 0});
        vis[i] = true;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int n = arr[0];
            int cnt = arr[1];
            cb += cnt;
            for (int an : lineList[n]) {
                if (an == i || vis[an]) continue;
                vis[an] = true;
                queue.offer(new int[] {an, cnt+1});
            }
        }

        if (minCnt > cb) {
            minCnt = cb;
            answer = i;
        }
    }

    public static void init() {
        Arrays.fill(vis, false);
        queue.clear();
    }
}