import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		// 원하는 완성 문장
		StringBuilder sb = new StringBuilder();
		while (stz.hasMoreTokens()) {
			sb.append(stz.nextToken());
		}
		String s = sb.toString();

		// s 에 대한 pi
		int[] pi = getPi(s);

		// 현재 문장
		sb = new StringBuilder();
		stz = new StringTokenizer(br.readLine(), " ");
		while (stz.hasMoreTokens()) {
			sb.append(stz.nextToken());
		}
		String s1 = sb.toString();

		// s1 의 길이 2배로 늘리기
		s1 += s1;

		int j = 0;
		for(int i = 0; i < s1.length(); i++) {
			while (j > 0 && s1.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}

			if (s1.charAt(i) == s.charAt(j)) {
				if (j == s.length() - 1) {
					// 문자열이 일치했을 때 시작점이 기존 문자열을 넘어서면 break
					if (i - j >= N) {
						break;
					}
					j = pi[j];
					cnt++;
				} else {
					j++;
				}
			}
		}

		int gcd = gcd(N, cnt);
		System.out.println((cnt/gcd) + "/" + (N/gcd));
	}

	public static int[] getPi(String s) {
		int[] pi = new int[s.length()];
		int j = 0;

		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}

			if (s.charAt(i) == s.charAt(j)) {
				pi[i] = ++j;
			}
		}

		return pi;
	}

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}
}