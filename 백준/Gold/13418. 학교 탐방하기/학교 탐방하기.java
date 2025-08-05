import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static long answer, r1, r2;
	static int[] p;
	// 최적을 찾기위한 pq
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[0] - o1[0];
		}
	});
	// 최악을 찾기위한 pq
	static PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken()) + 1;
		p = new int[N+1];

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int road = Integer.parseInt(stz.nextToken());
			pq.offer(new int[] {road, n1, n2});
			pq.offer(new int[] {road, n2, n1});
			pq2.offer(new int[] {road, n1, n2});
			pq2.offer(new int[] {road, n2, n1});
		}

		Arrays.fill(p, -1);
		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			int road = arr[0];
			int n1 = arr[1];
			int n2 = arr[2];
			if (union(n1, n2) && road == 0) r1++;
		}

		Arrays.fill(p, -1);
		while(!pq2.isEmpty()) {
			int[] arr = pq2.poll();
			int road = arr[0];
			int n1 = arr[1];
			int n2 = arr[2];
			if (union(n1, n2) && road == 0) r2++;
		}

		answer = (r2 * r2) - (r1 * r1);

		System.out.println(answer);
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