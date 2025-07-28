import java.util.*;
import java.io.*;

public class Main { 
	static int N, M, answer;
	static int[] p;
	static boolean[] know;
	static ArrayList<Integer>[] partyList;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		p = new int[N+1];
		Arrays.fill(p, -1);
		know = new boolean[N+1];
		partyList = new ArrayList[M];

		stz = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(stz.nextToken());
		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(stz.nextToken());
			know[n] = true;
		}

		for (int i = 0; i < M; i++) {
			partyList[i] = new ArrayList<>();
			stz = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(stz.nextToken());
			int n1 = 0;
			for (int j = 0; j < n; j++) {
				int node = Integer.parseInt(stz.nextToken());
				partyList[i].add(node);
				if (n1 == 0) n1 = node;
				else union(n1, node);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (know[i]) queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (node == i || find(i) != find(node)) continue;
				know[i] = true;
			}
		}

		next:
		for (ArrayList<Integer> memList : partyList) {
			for (int i : memList) {
				if (know[i]) continue next;
			}
			answer++;
		}

		System.out.println(answer);

		br.close();
	}

	// 경로 탐색 적용
	public static int find(int n) {
		if (p[n] < 0) return n;
		else return p[n] = find(p[n]);
	}

	// union by rank
	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 == n2) return false;
		if (p[n2] < p[n1]) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		if (p[n2] == p[n1]) p[n1]--;
		p[n2] = n1;
		return true;
	}
}