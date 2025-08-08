import java.util.*;
import java.io.*;

public class Main {
	static int N, answer;
	static int[][] dist;
	static int[][] origin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		origin = new int[N][N];

		StringTokenizer stz;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(stz.nextToken());
				dist[i][j] = value;
				origin[i][j] = value;
			}
		}

		

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (i == k || j == k) continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						System.out.println(-1);
						return;
					}
					if (dist[i][j] == dist[i][k] + dist[k][j]) origin[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				answer += origin[i][j];
			}
		}

		System.out.println(answer);
	}
    
    // 역 플로이드-워셜
}