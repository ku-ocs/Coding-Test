import java.util.*;
import java.io.*;

public class Main {
    static int N, R, Q;
    static int[] dp;
    static List<Integer>[] lineList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        R = Integer.parseInt(stz.nextToken());
        Q = Integer.parseInt(stz.nextToken());

        dp = new int[N+1];
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

        cntNode(R, 0);

        for (int i = 0; i < Q; i++) {
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void cntNode(int n, int p) {
        dp[n] = 1;

        for (int l : lineList[n]) {
            if (l == p) continue;
            cntNode(l, n);
            dp[n] += dp[l];
        }
    }
}