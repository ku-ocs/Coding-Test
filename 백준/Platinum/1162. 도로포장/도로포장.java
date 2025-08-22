import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static long answer = Long.MAX_VALUE;
	static long[][] D;
	static ArrayList<int[]>[] list;
	static PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]> () {
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
		K = Integer.parseInt(stz.nextToken());

		D = new long[N+1][K+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				D[i][j] = Long.MAX_VALUE;
			}
		}

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			int t = Integer.parseInt(stz.nextToken());
			list[u].add(new int[] {t, v});
			list[v].add(new int[] {t, u});
		}

		D[1][0] = 0;
		D[1][1] = 0;
		pq.offer(new long[] {0, 1, 0});

		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curD = cur[0];
			int curN = (int) cur[1];
			int curCnt = (int) cur[2];
			if (curD > D[curN][curCnt]) continue;
			for (int[] nxt : list[curN]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (curCnt < nxtN && curCnt < K && D[nxtN][curCnt+1] > curD) {
					D[nxtN][curCnt+1] = curD;
					pq.offer(new long[] {D[nxtN][curCnt+1], nxtN, curCnt+1});
				}

				if (curD + nxtD >= D[nxtN][curCnt]) continue;
				D[nxtN][curCnt] = curD + nxtD;
				pq.offer(new long[] {D[nxtN][curCnt], nxtN, curCnt});
			}
		}

		for (int i = 0; i <= K; i++) {
			answer = Math.min(answer, D[N][i]);
		}

		System.out.println(answer);
	}
}