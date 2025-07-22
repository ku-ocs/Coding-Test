import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt, cutCnt;
	static boolean[] vis;
	static ArrayList<Integer>[] lineList;
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		
		lineList = new ArrayList[N+1];
		vis = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			lineList[i] = new ArrayList<>();
		}

		for (int i = 0; i< M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stz.nextToken());
			int e = Integer.parseInt(stz.nextToken());
			lineList[s].add(e);
			lineList[e].add(s);
		}

		for (int i = 1; i<= N; i++) {
			if (vis[i]) continue;
			cnt++;
			bfs(i);
		}
		
		System.out.println((cutCnt/2) + cnt - 1);
	}

	public static void bfs(int s) {
		queue.clear();
		queue.offer(new int[] {s, -1});
		vis[s] = true;
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int n = arr[0];
			int p = arr[1];
			for (int i : lineList[n]) {
				if (i == p) continue;
				if (vis[i]) {
					cutCnt++;
					continue;
				}
				vis[i] = true;
				queue.offer(new int[] {i, n});
			}
		}
	}
}