import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N+1];
		Arrays.fill(p, -1);

		StringTokenizer stz;
		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int connect = Integer.parseInt(stz.nextToken());
				if (connect != 1) continue;
				union(i,j);
			}
		}

		stz = new StringTokenizer(br.readLine(), " ");
		int cur = Integer.parseInt(stz.nextToken());
		boolean connect = true;
		for (int i = 1; i < M; i++) {
			int nxt = Integer.parseInt(stz.nextToken());
			if (find(cur) != find(nxt)) {
				connect = false;
				break;
			}
			cur = nxt;
		}
		
		if (connect) {
			System.out.println("YES");
		} else {
			System.out.println("NO");			
		}
	}

	public static int find(int n) {
		if (p[n] < 0) return n;
		else return p[n] = find(p[n]);
	}

	public static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 == n2) return;
		if (p[n2] < p[n1]) {
			int temp = n2;
			n2 = n1;
			n1 = temp;
		}
		if (p[n1] == p[n2]) p[n1]--;
		p[n2] = n1;
	}
}