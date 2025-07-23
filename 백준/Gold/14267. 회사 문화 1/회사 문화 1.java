import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dp;
	static ArrayList<Integer>[] list;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		list = new ArrayList[N+1];
		dp = new int[N+1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(stz.nextToken());	// n 이 i 의 직속상사.
			if (n == -1) continue;
			list[n].add(i);
		}

		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(stz.nextToken());
			int count = Integer.parseInt(stz.nextToken());
			dp[num] += count;
		}
		
		chkCnt();

		for (int i = 1; i <= N; i++) {
			bw.write(dp[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void chkCnt() {
		queue.offer(1);
		while(!queue.isEmpty()) {
			int n = queue.poll();
			int cnt = dp[n];
			for (int i : list[n]) {
				queue.offer(i);
				dp[i] += cnt;
			}
		}
	}
}