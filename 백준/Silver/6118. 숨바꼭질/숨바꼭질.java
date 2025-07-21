import java.util.*;
import java.io.*;

public class Main {
	static int N, M, minNum, maxLength, cnt;
	static int[] dp;
	static boolean[] vis;
	static ArrayList<Integer>[] lineList;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());

		lineList = new ArrayList[N+1];
		vis = new boolean[N+1];
		dp = new int[N+1];

		for (int i = 0; i <= N; i++) {
			lineList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stz.nextToken());
			int e = Integer.parseInt(stz.nextToken());

			lineList[s].add(e);
			lineList[e].add(s);
		}

		bfs();

		for (int i = 1; i <= N; i++) {
			if (dp[i] > maxLength) {
				maxLength = dp[i];
		                minNum = i;
				cnt = 1;
			} else if (dp[i] == maxLength) cnt++;
		}

		bw.write(minNum + " " + maxLength + " " + cnt);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs() {
		vis[1] = true;
		queue.offer(1);
		while (!queue.isEmpty()) {
			int i = queue.poll();
			for (int n : lineList[i]) {
				if (vis[n]) continue;
				vis[n] = true;
				dp[n] = dp[i] + 1;
				queue.offer(n);
			}
		}
	}
}

