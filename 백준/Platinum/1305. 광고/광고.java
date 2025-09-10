import java.io.*;

public class Main {
	static int N;
	static String S;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = br.readLine();

		int[] pi = getPi(S);

		System.out.println(N - pi[N-1]);
		br.close();
	}

	public static int[] getPi(String s) {
		int[] pi = new int[s.length()];
		int j = 0;

		for (int i = 1; i < s.length(); i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}

			if (s.charAt(i) == s.charAt(j)) {
				pi[i] = ++j;
			}
		}

		return pi;
	}
}