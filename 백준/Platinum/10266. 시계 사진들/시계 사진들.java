import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr = new int[360000];
	static int[] arr2 = new int[360000];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(stz.nextToken());
			arr[n] = 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			if(i == 1) sb.append(1);
			else sb.append(0);
		}

		String s = sb.toString();

		sb = new StringBuilder();
		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(stz.nextToken());
			arr2[n] = 1;
		}

		for (int i : arr2) {
			if(i == 1) sb.append(1);
			else sb.append(0);
		}
		
		String s2 = sb.toString();
		s2 += s2;

		int[] pi = getPi(s);
		int j = 0;
		
		for (int i = 0; i < s2.length(); i++) {
			while(j > 0 && s2.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}

			if (s2.charAt(i) == s.charAt(j)) {
				j++;
			}

			if (j == s.length()) {
				System.out.println("possible");
				return;
			}
		}

		System.out.println("impossible");
	}

	public static int[] getPi(String s) {
		int[] pi = new int[s.length()];
		int j = 0;

		for (int i = 1; i < s.length(); i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j-1];
			if (s.charAt(i) == s.charAt(j)) pi[i] = ++j;
		}

		return pi;
	}
}