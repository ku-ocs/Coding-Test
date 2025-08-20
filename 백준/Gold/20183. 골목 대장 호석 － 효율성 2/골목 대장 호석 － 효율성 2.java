import java.util.*;
import java.io.*;

public class Main {
	static int N, M, A, B, cost;
	static long C;
	static ArrayList<int[]>[] list;

	// 이분 탐색과 다익스트라 알고리즘을 통해 풀이하는 문제
	// 다익스트라 알고리즘은 합계 최소비용만 구할 수 있음.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		A = Integer.parseInt(stz.nextToken());
		B = Integer.parseInt(stz.nextToken());
		C = Long.parseLong(stz.nextToken());

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			int c = Integer.parseInt(stz.nextToken());
			list[u].add(new int[] {c, v});
			list[v].add(new int[] {c, u});
			cost = Math.max(c, cost);
		}

		int left = 1;
		int right = cost;
		int answer = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (algorithm(mid)) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}

	// 최대간선의 길이를 제한해가면서 다익스트라를 진행 - 최대간선의 길이는 이분탐색으로 진행
	public static boolean algorithm(int l) {
		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});
		long[] D = new long[N+1];
		Arrays.fill(D, Long.MAX_VALUE);

		pq.offer(new long[] {0, A});
		D[A] = 0;

		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curD = cur[0];
			int curN = (int) cur[1];
			if (D[curN] < curD) continue;
			for (int[] nxt : list[curN]) {
				int c = nxt[0];
				int nxtN = nxt[1];
				if (c > l) continue;
				if (D[nxtN] <= curD + c) continue;
				D[nxtN] = curD + c;
				pq.offer(new long[] {D[nxtN], nxtN});
			}
		}

		return D[B] <= C;
	}
}