import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static long[] D;
	static ArrayList<int[]>[] list;
	static PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<>() {
		@Override
		public int compare(long[] l1, long[] l2) {
			return Long.compare(l1[0], l2[0]);
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		D = new long[N+1];
		Arrays.fill(D, Long.MAX_VALUE);

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken());
			int v=  Integer.parseInt(stz.nextToken());
			list[u].add(new int[] {i, v});
			list[v].add(new int[] {i, u});
		}

		pq.offer(new long[] {0, 1});
		D[1] = 0;

		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curD = cur[0];
			int curN = (int) cur[1];
			if (curD > D[curN]) continue;
			for(int[] nxt : list[curN]) {
				int nxtN = nxt[1];
				long cost;
				if (D[curN] % M <= nxt[0]) {
					cost = (D[curN] / M) * M + nxt[0];
				} else {
					cost = (D[curN] / M + 1) * M + nxt[0];
				}
				if (cost >= D[nxtN]) continue;
				D[nxtN] = cost;
				pq.offer(new long[] {D[nxtN], nxtN});
			}
		}

		System.out.println(D[N]);
	}
}
