import java.util.*;
import java.io.*;

public class Main {
	static int N, root, d, cnt;
	static ArrayList<Integer>[] lists;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		
		N = Integer.parseInt(br.readLine());
		lists = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			lists[i] = new ArrayList<>();
		}

		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(stz.nextToken());
			if (p == -1) {
				root = i;
				continue;
			}
			lists[p].add(i);
		}
		d = Integer.parseInt(br.readLine());

		if (d != root) {
			cntNode(root, -1, d);
		}
		
		System.out.println(cnt);
	}

	public static void cntNode(int i, int p, int d) {
		boolean hasChild = false;
		for (int n : lists[i]) {
			if (n == p || n == d) continue;
			hasChild = true;
			cntNode(n, i, d);
		}
		if (!hasChild) {
			cnt++;
		}
	}
}