import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R, answer, INF = 1000001;;
	static int[] item;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		R = Integer.parseInt(stz.nextToken());

		item = new int[N+1];
		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(stz.nextToken());
		}

		dist = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}

		for (int i = 0; i < R; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int l = Integer.parseInt(stz.nextToken());
			dist[from][to] = Math.min(dist[from][to], l);
			dist[to][from] = Math.min(dist[to][from], l);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][k] < INF && dist[k][j] < INF) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1;  j <= N; j++) {
				if (dist[i][j] <= M) {
					cnt += item[j];
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}