import java.util.*;
import java.io.*;

public class Main {
	static int N, root, answer;
	static boolean[] vis;
	static ArrayList<int[]>[] tree;
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer stz;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(stz.nextToken());
			while(stz.hasMoreTokens()) {
				int c = Integer.parseInt(stz.nextToken());
				if (c == -1) break;
				int v = Integer.parseInt(stz.nextToken());
				tree[p].add(new int[] {c, v});
				tree[c].add(new int[] {p, v});
			}
		}

		bfs(1);
		bfs(root);

		System.out.println(answer);
	}

	public static void init() {
		vis = new boolean[N+1];
		queue.clear();
	}

	public static void bfs(int i) {
		init();
		queue.offer(new int[] {i, 0});
		vis[i] = true;
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int n = arr[0];
			int v = arr[1];
			for (int[] arr2 : tree[n]) {
				int n2 = arr2[0];
				int v2 = arr2[1];
				if (vis[n2]) continue;
				vis[n2] = true;
				queue.offer(new int[] {n2, v+v2});
				if (answer < v+v2) {
					root = n2;
					answer = v + v2;
				}
			}
		}
	}
}