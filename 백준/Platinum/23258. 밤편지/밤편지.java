import java.util.*;
import java.io.*;

public class Main {
	static int N, Q, INF = 1_000_000_000;
	// dp 배열로 생각
	// [i][j][k] 는 k 보다 작거나 같은 정점을 지나는 i 에서 j 까지의 최소시간
	static int[][][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		Q = Integer.parseInt(stz.nextToken());
		dist = new int[N+1][N+1][N+1];

		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(stz.nextToken());
				if (i == j) value = 0;
				else if (value == 0) value = INF;
				dist[i][j][0] = value;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j][k] = Math.min(dist[i][j][k-1], dist[i][k][k-1] + dist[k][j][k-1]);
				}
			}
		}

		while(Q-- > 0) {
			stz = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stz.nextToken());
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			// 값은 [n1][n2][c-1] 로 찾을 것 - c 보다 작은 정점만 지나야함.
			int v = dist[n1][n2][c-1];
			if (v >= INF) dist[n1][n2][c-1] = -1;
			bw.write(dist[n1][n2][c-1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}