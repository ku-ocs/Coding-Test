import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long answer;
	static int[] p;
	static List<int[]>[] list = new ArrayList[3];
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		p = new int[N];
		Arrays.fill(p, -1);
		for (int i = 0; i < 3; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer stz;
		for (int i = 0 ; i < N; i ++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stz.nextToken());
			int y = Integer.parseInt(stz.nextToken());
			int z = Integer.parseInt(stz.nextToken());
			list[0].add(new int[] {x, i});
			list[1].add(new int[] {y, i});
			list[2].add(new int[] {z, i});
		}

		Collections.sort(list[0], (a, b) -> a[0] - b[0]);
		Collections.sort(list[1], (a, b) -> a[0] - b[0]);
		Collections.sort(list[2], (a, b) -> a[0] - b[0]);

		
		for (List<int[]> l : list) {
			int[] prev = l.get(0);
			int prevValue = prev[0];
			int prevIdx = prev[1];
			for (int i = 1; i < N; i++) {
				int[] cur = l.get(i);
				int curValue = cur[0];
				int curIdx = cur[1];
				pq.offer(new int[] {Math.abs(prevValue - curValue), prevIdx, curIdx});
				prevValue = curValue;
				prevIdx = curIdx;
			}
		}

		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			int cost = arr[0];
			int n1 = arr[1];
			int n2 = arr[2];
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
		if (p[n2] < p[n1]) {
			int temp = n2;
			n2 = n1;
			n1 = temp;
		}
		if( p[n1] == p[n2]) p[n1]--;
		p[n2] = n1;
		return true;
	}
}