import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, INF = 200001, time = INF;
	static int[] live;
	static int[][] cities;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		
		cities = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i==j) cities[i][j] = 0;
				else cities[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			cities[n1][n2] = cost;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (cities[i][k] < INF && cities[k][j] < INF) {
						cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
					}
				}
			}
		}

		K = Integer.parseInt(br.readLine());
		live = new int[K];
		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			live[i] = Integer.parseInt(stz.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int cost = 0;
			for (int j : live) {
				int trip = cities[i][j] + cities[j][i];
				cost = Math.max(cost, trip);
			}
			if (cost < time) {
				time = cost;
				sb = new StringBuilder();
				sb.append(i).append(" ");
			} else if (cost == time) {
				sb.append(i).append(" ");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}