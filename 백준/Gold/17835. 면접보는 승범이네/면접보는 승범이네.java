import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, num, S;
	static long length, INF = Long.MAX_VALUE;
	static long[] D;
	static ArrayList<long[]>[] list;
	static PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
		@Override
		public int compare(long[] o1, long[] o2) {
			return Long.compare(o1[0], o2[0]);
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());

		D = new long[N+1];
		Arrays.fill(D, INF);

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken()); // 출발 도시
			int v = Integer.parseInt(stz.nextToken()); // 도착 도시
			int c = Integer.parseInt(stz.nextToken()); // 거리

			// 면접장에서 역으로 탐색할 예정이므로 역으로 집어넣기
			list[v].add(new long[] {c, u});
		}

		stz = new StringTokenizer(br.readLine(), " ");
		while(K-- > 0) {
			int num = Integer.parseInt(stz.nextToken());
			D[num] = 0;
			pq.offer(new long[] {0, num});
		}

		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curD = cur[0];
			int curN = (int) cur[1];
			if (curD > D[curN]) continue;
			for (long[] nxt : list[curN]) {
				long cost = nxt[0];
				int nxtN = (int) nxt[1];
				if (D[nxtN] <= cost + curD) continue;
				D[nxtN] = cost + curD;
				pq.offer(new long[] {D[nxtN], nxtN});
			}
		}

		for (int i = 1; i <= N; i++) {
			if (D[i] > length) {
				length = D[i];
				num = i;
			}
		}

		bw.write(num + "\n");
		bw.write(length + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}