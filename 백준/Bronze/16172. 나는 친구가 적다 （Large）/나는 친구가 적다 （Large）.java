import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		int[] piP = getPi(P);

		int j = 0;
		for (int i = 0; i < S.length(); i++) {
			if ((byte) S.charAt(i) >= 48 && (byte) S.charAt(i) <= 57) continue;

			while (j > 0 && S.charAt(i) != P.charAt(j)) {
				j = piP[j-1];
			}

			if (S.charAt(i) == P.charAt(j)) {
				j++;
			}

			if (j == piP.length) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);
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
}