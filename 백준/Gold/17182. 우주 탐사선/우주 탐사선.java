import java.util.*;
import java.io.*;

public class Main {
	static int N, K, answer = 100000000;
	static int[][] graph;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());

		graph = new int[N][N];
		vis = new boolean[N];

		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if( i==j) continue;
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		vis[K] = true;
		dfs(K, 1, 0);

		System.out.println(answer);
	}

	public static void dfs(int n, int depth, int cost) {
		if(depth == N) {
			answer = Math.min(answer, cost);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (vis[i]) continue;
			vis[i] = true;
			dfs(i, depth+1, cost + graph[n][i]);
			vis[i] = false;
		}
	}
}