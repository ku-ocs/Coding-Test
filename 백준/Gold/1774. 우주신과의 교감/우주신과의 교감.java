import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static double answer;
	static int[] p;
	static long[][] loc;
	static PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]> () {
		@Override
		public int compare(long[] o1, long[] o2) {
			return Long.compare(o1[0], o2[0]);
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		
		p = new int[N+1];
		Arrays.fill(p, -1);
		loc = new long[N+1][2];
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			long x = Long.parseLong(stz.nextToken());
			long y = Long.parseLong(stz.nextToken());
			loc[i][0] = x;
			loc[i][1] = y;
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			union(n1, n2);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				if (find(i) == find(j)) continue;
				long[] n1 = loc[i];
				long[] n2 = loc[j];
				long dx = n1[0] - n2[0];
				long dy = n1[1] - n2[1];
				long v = dx * dx + dy * dy;
				pq.offer(new long[] {v, i, j});
			}
		}

		while(!pq.isEmpty()) {
			long[] arr = pq.poll();
			long v = arr[0];
			int n1 = (int) arr[1];
			int n2 = (int) arr[2];
			if (!union(n1, n2)) continue;
			answer += Math.sqrt(v);
		}

		answer = Math.round(answer * 100.0) / 100.0;

		System.out.printf("%.2f", answer);
	}

	public static int find(int n) {
		if (p[n] < 0) return n;
		else return p[n] = find(p[n]);
	}

	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 == n2) return false;
		if (p[n2] < p[n1]) {
			int temp = n2;
			n2 = n1;
			n1 = temp;
		}
		if (p[n1] == p[n2]) p[n1]--;
		p[n2] = n1;
		return true;
	}
}