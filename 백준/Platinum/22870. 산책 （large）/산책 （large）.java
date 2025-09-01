import java.util.*;
import java.io.*;

public class Main {
	static int N, M, S, E;
	static boolean[] vis;
	static long INF, answer;
	static long[] pS, pE;
	static ArrayList<int[]>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());

		pS = new long[N+1];
		pE = new long[N+1];
		vis = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		INF = 1000 * N + 1;

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			int w = Integer.parseInt(stz.nextToken());
			list[u].add(new int[] {w, v});
			list[v].add(new int[] {w, u});
		}

		stz = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(stz.nextToken());
		E = Integer.parseInt(stz.nextToken());

		answer += dijkstra(S, E, pS);
		dijkstra(E, S, pE);
		removeNode(S, E);
		
		answer += dijkstra(E, S, pE);
		
		System.out.println(answer);
	}

	public static long dijkstra(int s, int e, long[] p) {
		Arrays.fill(p, INF);
		p[s] = 0;
		
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
		pq.offer(new long[] {0, s});

		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curD = cur[0];
			int curN = (int) cur[1];
			if (curD > p[curN]) continue;
			for (int[] nxt : list[curN]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (vis[nxtN]) continue;
				if (curD + nxtD >= p[nxtN]) continue;
				p[nxtN] = curD + nxtD;
				pq.offer(new long[] {p[nxtN], nxtN});
			}
		}

		return p[e];
	}

	public static void removeNode(int s, int e) {
		int start = S;
		int pre = S;
		while (start != E) {
			int min = N+1;
			for (int[] nxt : list[start]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (pre == nxtN) continue;
				if (pS[start] + nxtD + pE[nxtN] == pS[E]) {
					min = Math.min(min, nxtN);
				}
			}

			pre = start;
			start = min;
			if (start != E) vis[start] = true;
		}
	}
}