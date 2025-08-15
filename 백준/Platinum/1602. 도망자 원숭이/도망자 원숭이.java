import java.util.*;
import java.io.*;

public class Main {
	static int N, M, Q, INF = 1_000_000_000;
	static int[] T;
	static int[][] cost, dist;
	// 오름차순 정렬 + max() -- 경유지 중 가장 큰 값을 선택하는 것  --- 현 문제에서는 이것
	// 내림차순 정렬 + min() -- 경유지 중 가장 작은 값을 선택하는 것
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		Q = Integer.parseInt(stz.nextToken());

		T = new int[N+1];
		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int val = Integer.parseInt(stz.nextToken());
			T[i] = val;
			pq.offer(new int[] {val, i});
		}

		cost = new int[N+1][N+1];
		dist = new int[N+1][N+1];
		for (int i = 1;  i <= N; i++) {
			for (int j = 1 ; j <= N; j++) {
				if (i == j) {
					dist[i][j] = 0;
					cost[i][j] = T[i];
				}
				else {
					dist[i][j] = INF;
					cost[i][j] = INF;
				}
			}
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			dist[n1][n2] = v;
			dist[n2][n1] = v;
			cost[n1][n2] = v + Math.max(T[n1], T[n2]);
			cost[n2][n1] = v + Math.max(T[n1], T[n2]);
		}

		for (int k = 1; k <= N; k++) {
			int[] arr = pq.poll();
			// 가장 작은 비용을 가진 경유지부터 높은 비용을 가진 경유지까지 플로이드-와샬
			int idx = arr[1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					if (dist[i][idx] < INF && dist[idx][j] < INF) {
						dist[i][j] = Math.min(dist[i][j], dist[i][idx] + dist[idx][j]);
						cost[i][j] = Math.min(cost[i][j], dist[i][j] + Math.max(T[i], Math.max(T[j], T[idx])));
					}
				}
			}
		}

		while(Q-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			if (cost[n1][n2] >= INF) bw.write(-1 + "\n");
			else bw.write(cost[n1][n2] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}