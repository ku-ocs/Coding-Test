import java.util.*;
import java.io.*;

public class Main {
	static int N, M, INF = 1_000_000_000;
	static double answer = Double.MAX_VALUE;
	static int[][] graph;
	static int[][] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());

		edges = new int[N+1][N+1];
		graph = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			graph[n1][n2] = Math.min(graph[n1][n2], v);
			graph[n2][n1] = graph[n1][n2];
			edges[n1][n2] = Math.max(edges[n1][n2], v);
			edges[n2][n1] = edges[n1][n2];
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (graph[i][k] < INF && graph[k][j] < INF) {
						graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
					}
				}
			}
		}

		for (int s = 1; s <= N; s++) {
			double maxTime = 0.0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					double time = 0;
					double d1 = graph[s][i];
					double d2 = graph[s][j];
					double w = edges[i][j];
					if (w > 0) {
						time = Math.min(d1, d2) + (w + Math.abs(d1 - d2)) / 2.0;
					} else {
						time = Math.max(d1, d2);
					}
					maxTime = Math.max(maxTime, time);
				}
			}
			answer = Math.min(answer, maxTime);
		}

		System.out.printf("%.1f\n", answer);
	}
}