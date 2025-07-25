import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] dp;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		dp = new int[N+1][2];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
      
        StringTokenizer stz;
		for (int i = 1; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}

		dfs(1, 0);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	public static void dfs(int i, int p) {
		dp[i][1] = 1;
		for (int n : list[i]) {
			if (n == p) continue;
			dfs(n, i);
			dp[i][0] += dp[n][1];
			dp[i][1] += Math.min(dp[n][0], dp[n][1]);
		}
	}

    // 트리의 DP 다시 공부하기
}
