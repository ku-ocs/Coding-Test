import java.util.*;
import java.io.*;

public class Main {	
	static int N, M, INF = 1_000_000_000;
	static int[][] graph, nxt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		graph = new int[N+1][N+1];
		nxt = new int[N+1][N+1];
		
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
			graph[n1][n2] = v;
			graph[n2][n1] = v;
			nxt[n1][n2] = n2;
			nxt[n2][n1] = n1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
						nxt[i][j] = nxt[i][k];
					}
				}
			}
		}

		for (int i = 1;  i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (nxt[i][j] == 0) bw.write("- ");
				else bw.write(nxt[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}