import java.util.*;
import java.io.*;

public class Main {
	static int N, M, S, INF = 1_000_000_001;
	static int[] dist;
	static int[][] graph;
	static ArrayList<int[]>[] list;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N+1];
		Arrays.fill(dist, INF);

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer stz;
		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			list[n1].add(new int[] {v, n2});
		}

		stz = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(stz.nextToken());

		pq.offer(new int[] {0, S});
		dist[S] = 0;

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curD = cur[0];
			int curN = cur[1];
			if (curD > dist[curN]) continue;
			for (int[] nxt : list[curN]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (curD + nxtD >= dist[nxtN]) continue;
				dist[nxtN] = curD + nxtD;
				pq.offer(new int[] {dist[nxtN], nxtN});
			}
		}

		System.out.println(dist[Integer.parseInt(stz.nextToken())]);
	}
}