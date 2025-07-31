import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] p, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		p = new int[1000001];
		Arrays.fill(p, -1);

		cnt = new int[1000001];
		Arrays.fill(cnt, 1);
		
		StringTokenizer stz;
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			String order = stz.nextToken();
			if (order.equals("I")) {
				int n1 = Integer.parseInt(stz.nextToken());
				int n2 = Integer.parseInt(stz.nextToken());
				union(n1, n2);
			} else {
				int n = Integer.parseInt(stz.nextToken());
				bw.write(cnt[find(n)] + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int n) {
		if (p[n] < 0) return n;
		else return p[n] = find(p[n]);
	}

	public static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if(n1 == n2) return;
		if (p[n2] < p[n1]) {
			int temp = n2;
			n2 = n1;
			n1 = temp;
		}
		cnt[n1] += cnt[n2];
		cnt[n2] = 0;
		if (p[n1] == p[n2]) p[n1]--;
		p[n2] = n1;
	}
}