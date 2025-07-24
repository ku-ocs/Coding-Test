import java.util.*;
import java.io.*;

public class Main {
	static int N, lCnt = 1, num, width, root;
	static boolean[] vis, isChild;
	static int[][] tree;
	static ArrayDeque<Integer>[] deques;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stz;

		vis = new boolean[N+1];
		isChild = new boolean[N+1];
		tree = new int[N+1][2];
		deques = new ArrayDeque[N+1];

		for (int i = 0; i <= N; i++) {
			deques[i] = new ArrayDeque<>();
		}

		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(stz.nextToken());
			int l = Integer.parseInt(stz.nextToken());
			int r = Integer.parseInt(stz.nextToken());
			tree[p] = new int[] {l, r};
			if (l != -1) isChild[l] = true;
			if (r != -1) isChild[r] = true;
		}

		for (int i = 1; i <= N; i++) {
			if (!isChild[i]) {
				root = i;
				break;
			}
		}

		searchNode(root, 1);

		for (int i = 1; i < deques.length; i++) {
			if (!deques[i].isEmpty()) {
				int s = deques[i].getFirst();
				int e = deques[i].getLast();
				if (e - s + 1 > width) {
					width = e-s+1;
					num = i;
				}
			}
		}

		System.out.printf("%d %d", num, width);
	}

	public static void searchNode(int i, int depth) {
		int l = tree[i][0];
		int r = tree[i][1];
		if (l != -1) searchNode(l, depth+1);
		if (!vis[i]) {
			vis[i] = true;
			deques[depth].offer(lCnt++);
		}
		if (r != -1) searchNode(r, depth+1);
	}
}