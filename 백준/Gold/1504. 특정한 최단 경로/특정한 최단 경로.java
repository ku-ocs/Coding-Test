import java.util.*;
import java.io.*;

public class Main {
	static int N, E, INF = 1_000_000_000;
	static int[] dist1; // 1 에서 각 정점
	static int[] dist2; // n1 에서 각 정점
	static int[] dist3; // n2 에서 각 정점
	static ArrayList<int[]>[] list;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		E = Integer.parseInt(stz.nextToken());

		dist1 = new int[N+1];
		dist2 = new int[N+1];
		dist3 = new int[N+1];
		Arrays.fill(dist1, INF);
		Arrays.fill(dist2, INF);
		Arrays.fill(dist3, INF);

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while(E-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int d = Integer.parseInt(stz.nextToken());
			list[n1].add(new int[] {d, n2});
			list[n2].add(new int[] {d, n1});
		}

		stz = new StringTokenizer(br.readLine(), " ");
		int n1 = Integer.parseInt(stz.nextToken());
		int n2 = Integer.parseInt(stz.nextToken());
		
		searchDist(1, dist1);
		searchDist(n1, dist2);
		searchDist(n2, dist3);

		// 1 -> n1 -> n2 -> N : dist1[n1] + dist2[n2] + dist3[N] --- 셋 중 하나가 INF 일 경우 값 인정 x
		// 1 -> n2 -> n1 -> N : dist1[n2] + dist3[n1] + dist3[N] --- 셋 중 하나가 INF 일 경우 값 인정 x
		if ((dist1[n1] == INF || dist2[n2] == INF || dist3[N] == INF) &&
			dist1[n2] == INF || dist3[n1] == INF || dist2[N] == INF) {
				System.out.println(-1);
				return;
		}
		
		int route1 = dist1[n1] + dist2[n2] + dist3[N];
		int route2 = dist1[n2] + dist3[n1] + dist2[N];
		int answer = Math.min(route1, route2);

		System.out.println(answer);
	}

	public static void searchDist(int n, int[] dist) {
		pq.offer(new int[] {0, n});
		dist[n] = 0;

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curD = cur[0];
			int curN = cur[1];
			for (int[] nxt : list[curN]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (curD + nxtD >= dist[nxtN]) continue;
				dist[nxtN] = curD + nxtD;
				pq.offer(new int[] {dist[nxtN], nxtN});
			}
		}
	}
}