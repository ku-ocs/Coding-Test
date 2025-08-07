import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, INF = 1_000_000_000;
	static int[][] road;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] sArr = br.readLine().split(" ");

		N = Integer.parseInt(sArr[0]);
		M = Integer.parseInt(sArr[1]);

		road = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1 ; j <= N; j++) {
				if (i == j) road[i][j] = 0;
				else road[i][j] = INF;
			}
		}

		while(M-- > 0) {
			sArr = br.readLine().split(" ");
			int n1 = Integer.parseInt(sArr[0]);
			int n2 = Integer.parseInt(sArr[1]);
			int v = Integer.parseInt(sArr[2]);
			road[n1][n2] = 0;
			if (v == 0) {
				road[n2][n1] = 1;
			} else {
				road[n2][n1] = 0;			
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (road[i][k] < INF && road[k][j] < INF) {
						road[i][j] = Math.min(road[i][k] + road[k][j], road[i][j]);
					}
				}
			}
		}

		K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			sArr = br.readLine().split(" ");
			int n1 = Integer.parseInt(sArr[0]);
			int n2 = Integer.parseInt(sArr[1]);
			bw.write(road[n1][n2] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}