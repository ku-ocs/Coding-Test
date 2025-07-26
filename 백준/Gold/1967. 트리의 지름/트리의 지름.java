import java.util.*;
import java.io.*;

public class Main {
	static int N, root, answer;
	static ArrayList<int[]>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer stz;
		for (int i = 1; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(stz.nextToken());
			int l = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			tree[p].add(new int[] {l, v});
			tree[l].add(new int[] {p, v});
		}

		dfs(1, 0, 0);
		if (root != 1) {
			dfs(root, 0, 0);
		}

		System.out.println(answer);
	}

	public static void dfs(int i, int p, int value) {
		for (int[] arr : tree[i]) {
			int n = arr[0];
			int v = arr[1];
			if (n == p) continue;
			dfs(n, i, value+v);
		}
		if (answer < value) {
			root = i;
			answer = value;
		}
	}
}