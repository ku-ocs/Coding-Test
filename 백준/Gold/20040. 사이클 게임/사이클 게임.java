import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		p = new int[N+1];
		Arrays.fill(p, -1);
		
		for (int i = 1; i <= M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			if (!union(n1, n2)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
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
		return true;
	}
}