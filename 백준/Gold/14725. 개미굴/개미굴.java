import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static String[] sArr, sa1 = new String[0], sa2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		sArr = new String[N];

		StringTokenizer stz;
		for(int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(stz.nextToken());
			String s = stz.nextToken();
			while (t-- > 1) {
				s += " " + stz.nextToken();
			}
			sArr[i] = s;
		}

		Arrays.sort(sArr);

		for (int i = 0; i < N; i++) {
			sa2 = sArr[i].split(" ");
			int limit = Math.min(sa1.length, sa2.length);
			boolean isEquals = true;
			for (int j = 0; j < sa2.length; j++) {
				if (isEquals && j < limit) {
					isEquals = sa1[j].equals(sa2[j]);
					if (!isEquals) {
						String s = "";
						for (int k = 0; k < j; k++) {
							s += "--";
						}
						s += sa2[j];
						bw.write(s + "\n");
					}
				} else {
					String s = "";
					for (int k = 0; k < j; k++) {
						s += "--";
					}
					s += sa2[j];
					bw.write(s + "\n");
				}
			}
			

			sa1 = new String[sa2.length];
			for (int j = 0; j < sa2.length; j++) {
				sa1[j] = sa2[j];
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}