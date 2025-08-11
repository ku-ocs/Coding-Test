import java.util.*;
import java.io.*;

public class Main {
	static int N, M, X, INF = 1_000_000_000, answer;
	static int[] dist, reDist;
	static ArrayList<int[]>[] list, reList; // list 정방향 그래프, reList 역방향 그래프
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		X = Integer.parseInt(stz.nextToken());

		dist = new int[N+1];
		reDist = new int[N+1];
		Arrays.fill(dist, INF);
		Arrays.fill(reDist, INF);

		list = new ArrayList[N+1];
		reList = new ArrayList[N+1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			reList[i] = new ArrayList<>();
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			list[n1].add(new int[] {v, n2});
			reList[n2].add(new int[] {v, n1});
		}

		algorithm(dist, list);			// 정방향 그래프를 통해 하나의 정점에서 모든 정점까지 거리 구하기 - dist 배열
		algorithm(reDist, reList);		// 역방향 그래프를 통해 모든 정점에서 특정 정점까지 거리 구하기 - reDist 배열

		for (int i = 1; i <= N; i++) {
			answer = Math.max(dist[i] + reDist[i], answer);
		}

		System.out.println(answer);
	}

	public static void algorithm(int[] arr, ArrayList<int[]>[] list) {
		pq.offer(new int[] {0, X});
		arr[X] = 0;

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curN = cur[1];
			for (int[] nxt : list[curN]) {
				int nxtC = nxt[0];
				int nxtN = nxt[1];
				if (arr[curN] + nxtC >= arr[nxtN]) continue;
				arr[nxtN] = arr[curN] + nxtC;
				pq.offer(new int[] {arr[nxtN], nxtN});
			}
		}
	}
}