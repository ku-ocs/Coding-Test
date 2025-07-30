import java.util.*;
import java.io.*;

public class Main {
	static int N, M, MAX = 10000001;
	static int[][] graph, nxt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new int[N+1][N+1];
		nxt = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) graph[i][j] = 0;
				else graph[i][j] = MAX;
			}
		}

		StringTokenizer stz;
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			if (graph[from][to] > cost) {
				graph[from][to] = cost;
				nxt[from][to] = to;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (graph[i][k] < MAX && graph[k][j] < MAX) {
						if (graph[i][j] > graph[i][k] + graph[k][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
							nxt[i][j] = nxt[i][k];
						}
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == MAX) bw.write("0 ");
				else bw.write(graph[i][j] + " ");
			}
			bw.write("\n");
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == MAX || i == j) bw.write("0\n");
				else {
					StringBuilder sb = new StringBuilder();
					int cnt = 2;
					sb.append(i + " ");
					int from = i;
					while(nxt[from][j] != j) {
						sb.append(nxt[from][j] + " ");
						from = nxt[from][j];
						cnt++;
					}
					sb.append(j);
					bw.write(cnt + " " + sb.toString() + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}