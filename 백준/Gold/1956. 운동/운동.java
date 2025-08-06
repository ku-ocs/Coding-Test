import java.io.*;
import java.util.*;

public class Main {
	static int V, E, INF = 1_000_000_000, answer = INF;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(stz.nextToken());
		E = Integer.parseInt(stz.nextToken());

		dist = new int[V+1][V+1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				dist[i][j] = INF;
			}
		}
		
		while(E-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			dist[n1][n2] = v;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (dist[i][k] < INF && dist[k][j] < INF) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			answer = Math.min(answer, dist[i][i]);
		}

		if (answer == INF) System.out.println(-1);
		else System.out.println(answer);
	}
}