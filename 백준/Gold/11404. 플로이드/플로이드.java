import java.io.*;
import java.util.*;

public class Main {
	static int N, M, MAX = 10000001; // 100 * 100000 + 1
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];

		StringTokenizer stz;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) graph[i][j] = 0;
				else graph[i][j] = MAX;
			}
		}

		for (int i = 0; i <M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int val = Integer.parseInt(stz.nextToken());
			graph[from][to] = Math.min(graph[from][to], val);
		}

		for (int mid = 1; mid <= N; mid++) {
			for (int from = 1; from <= N; from++) {
				for (int to = 1; to <= N; to++) {
					if (graph[from][mid] < MAX && graph[mid][to] < MAX) graph[from][to] = Math.min(graph[from][to], graph[from][mid] + graph[mid][to]);
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

		bw.flush();
		bw.close();
		br.close();
	}
}