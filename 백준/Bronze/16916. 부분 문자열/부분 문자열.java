import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		int[] fp = new int[P.length()];
		failure(P, fp);

		int j = 0;
		for (int i = 0; i < S.length(); i++) {
			while(j > 0 && S.charAt(i) != P.charAt(j)) j = fp[j-1];
			if (S.charAt(i) == P.charAt(j))j++;
			if (j == P.length()) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
	}

	// KMP - 실패함수 구하기
	public static void failure(String s, int[] f) {
		int j = 0;

		for (int i = 1; i < s.length(); i++) {
			// 접두사의 마지막 != 접미사의 처음일 경우
			// j 값을 줄여나가면서 다시 비교
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = f[j-1];	
			}

			// 접두사의 마지막 == 접미사의 처음일 경우
			// 이 전 실패함수의 값에서 +1
			if (s.charAt(i) == s.charAt(j)) {
				j++;
				f[i] = j;
			}
		}
	}
}