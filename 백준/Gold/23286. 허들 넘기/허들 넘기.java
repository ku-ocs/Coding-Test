import java.util.*;
import java.io.*;

public class Main {
	static int N, M, T, INF = 1_000_000_000;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		T = Integer.parseInt(stz.nextToken());

		graph = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stz.nextToken());
			int e = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			graph[s][e] = v;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (graph[i][k] < INF && graph[k][j] < INF ) {
						int value = Math.max(graph[i][k], graph[k][j]);
						graph[i][j] = Math.min(graph[i][j], value);
					}
				}
			}
		}

		while(T-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stz.nextToken());
			int e = Integer.parseInt(stz.nextToken());
			if (graph[s][e] == INF) bw.write(-1 + "\n");
			else bw.write(graph[s][e] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}