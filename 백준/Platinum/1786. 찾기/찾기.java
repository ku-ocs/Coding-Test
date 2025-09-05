import java.io.*;

public class Main {
	static int cnt;
	static String T, P;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = br.readLine();
		P = br.readLine();
		StringBuilder s = new StringBuilder();

		int[] piP = failure(P);
		int j = 0;

		for (int i = 0; i < T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = piP[j-1];
			}

			if (T.charAt(i) == P.charAt(j)) {
				if (j == piP.length-1) {
					cnt++;
					// i 의 idx 는 0부터 시작, 문제는 1부터 시작 -- +1
					s.append(i-j+1).append("\n");
					j = piP[j];
				} else {
					j++;
				}
			}
		}

		bw.write(cnt + "\n");
		bw.write(s.toString());
		bw.flush();
		br.close();
	}

	public static int[] failure(String s) {
		int[] p = new int[s.length()];
		int j = 0;

		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = p[j-1];
			}

			if (s.charAt(i) == s.charAt(j)) {
				p[i] = ++j;
			}
		}

		return p;
	}
}

/*
ABC ABCDAB ABCDABCDABDE
ABCDABD
*/