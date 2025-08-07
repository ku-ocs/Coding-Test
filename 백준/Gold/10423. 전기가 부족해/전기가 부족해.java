import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, answer;
	static int[] p;
	static boolean[] power;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());

		p = new int[N+1];
		Arrays.fill(p, -1);
		power = new boolean[N+1];

		stz = new StringTokenizer(br.readLine(), " ");
		while(K-- > 0) {
			power[Integer.parseInt(stz.nextToken())] = true;
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			pq.offer(new int[] {cost, n1, n2});
		}

		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			int n1 = arr[1];
			int n2 = arr[2];
			int cost = arr[0];

			int root1 = find(n1);
			int root2 = find(n2);
			
			if (power[root1] && power[root2]) continue;
			if (power[root2]) {
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}
			if (!union(n1, n2)) continue;
			answer += cost;
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
		if (n1 == n2) return false;
		p[n2] = n1;
		return true;
	}
}