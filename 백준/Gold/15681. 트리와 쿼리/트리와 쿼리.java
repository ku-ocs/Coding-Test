import java.util.*;
import java.io.*;

public class Main {
    static int N, R, Q;
    static int[] dp;
    static boolean[] vis;
    static ArrayList<Integer>[] lineList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        R = Integer.parseInt(stz.nextToken());
        Q = Integer.parseInt(stz.nextToken());

        dp = new int[N+1];
        vis = new boolean[N+1];
        lineList = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            lineList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());

            lineList[u].add(v);
            lineList[v].add(u);
        }

        Arrays.fill(dp, 1);
        cntNode(R);
        dp[R] = N;

        for (int i = 0; i < Q; i++) {
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void cntNode(int n) {
        ArrayList<Integer> list = lineList[n];
        vis[n] = true;

        if (n != R && list.size() == 1) {
            dp[n] = 1;
            return;
        }

        for (int l : list) {
            if (vis[l]) continue;
            cntNode(l);
            dp[n] += dp[l];
        }
    }
}