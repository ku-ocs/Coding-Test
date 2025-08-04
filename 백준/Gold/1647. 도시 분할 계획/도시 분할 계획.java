import java.util.*;
import java.io.*;

public class Main {
	static int N, M, answer, cnt;
	static int[] p;
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] - o2[0];
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		
		p = new int[N+1];
		Arrays.fill(p, -1);
		
		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			pq.offer(new int[] {v, n1, n2});
		}

		while(!pq.isEmpty()) {
			if (cnt == N-2) {
				break;
			}
			int[] arr = pq.poll();
			int v = arr[0];
			int n1 = arr[1];
			int n2 = arr[2];
			if (union(n1, n2)) {
				answer += v;
				cnt++;
			}
		}

		System.out.println(answer);

		br.close();
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
		if (p[n2] == p[n1]) p[n1]--;
		p[n2] = n1;
		return true;
	}
}