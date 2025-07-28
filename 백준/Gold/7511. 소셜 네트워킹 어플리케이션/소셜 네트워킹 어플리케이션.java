import java.util.*;
import java.io.*;

public class Main { 
	static int T, N, M, K;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			p = new int[N];
			Arrays.fill(p, -1);
			for (int j = 0 ; j < M; j++) {
				stz = new StringTokenizer(br.readLine(), " ");
				int n1 = Integer.parseInt(stz.nextToken());
				int n2 = Integer.parseInt(stz.nextToken());
				union(n1, n2);
			}
			
			K = Integer.parseInt(br.readLine());
			bw.write("Scenario " + i + ":\n");
			for (int j = 0; j < K; j++) {
				stz = new StringTokenizer(br.readLine(), " ");
				int n1 = Integer.parseInt(stz.nextToken());
				int n2 = Integer.parseInt(stz.nextToken());
				if (find(n1) == find(n2)) bw.write(1 + "\n");
				else bw.write(0 + "\n");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
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
		if (p[n1] == p[n2]) p[n1]--;
		p[n2] = n1;
		return true;
	}
}