import java.util.*;
import java.io.*;

public class Main{
	static int N, K, M;
	static boolean[] visStation, visTube;
	static ArrayList<Integer>[] station;
	static ArrayList<Integer>[] tube;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());

		if (N == 1) {
			System.out.println(1);
			return;
		}
		
		visStation = new boolean[N+1];
		visTube = new boolean[M];
		station = new ArrayList[N+1];
		tube = new ArrayList[M];
		for (int i = 0; i <= N; i++) {
			station[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			tube[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++) {
				int s = Integer.parseInt(stz.nextToken());
				station[s].add(i);
				tube[i].add(s);
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 1, 0));
		visStation[1] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int cur = node.n;
			int cnt = node.cnt;
			int type = node.type;
			if (type == 1) {
				for (int nxt : tube[cur]) {
					if (visStation[nxt]) continue;
					if (nxt == N) return cnt+1;
					queue.offer(new Node(nxt, cnt+1, 0));
					visStation[nxt] = true;
				}
			} else {
				for (int nxt : station[cur]) {
					if (visTube[nxt]) continue;
					queue.offer(new Node(nxt, cnt, 1));
					visTube[nxt] = true;
				}
			}
		}

		return -1;
	}

	static class Node {
		int n;
		int cnt;
		int type; // 0 이면 station. 1이면 tube

		Node(int n, int cnt, int type) {
			this.n = n;
			this.cnt = cnt;
			this.type = type;
		}
	}
}