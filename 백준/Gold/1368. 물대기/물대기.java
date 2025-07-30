import java.util.*;
import java.io.*;

public class Main {
	static int N, answer, cnt = 0;
	static int[] p;
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		Arrays.fill(p, -1);
		
		for (int i = 1; i <= N; i++) {
			int v = Integer.parseInt(br.readLine());
			pq.offer(new int[] {v, 0, i});
		}

		StringTokenizer stz;
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= N; j++) {
				int val = Integer.parseInt(stz.nextToken());
				if (i == j) continue;
				pq.offer(new int[] {val, i, j});
			}
		}

		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			int val = arr[0];
			int s = arr[1];
			int e = arr[2];
			if (find(s) == find(e)) continue;
			union(s, e);
			answer += val;
			if (cnt == N) break;
		}

		System.out.println(answer);
	}

	public static int find(int n) {
		if (p[n] < 0) return n;
		else return p[n] = find(p[n]);
	}

	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if(n1 == n2) return false;
		if(p[n2] < p[n1]) {
			int temp = n2;
			n2 = n1;
			n1 = temp;
		}
		if(p[n1] == p[n2]) p[n1]--;
		p[n2] = n1;
		cnt++;
		return true;
	}
}