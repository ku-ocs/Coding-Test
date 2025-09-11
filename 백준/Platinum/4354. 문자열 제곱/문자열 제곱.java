import java.io.*;

public class Main {
	static String S;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String line = br.readLine();
			if(line.equals(".")) break;

			int last = getPi(line);
			
			int val;
			if (last == 0 || line.length() % (line.length() - last) != 0) val = 1;
			else val = line.length() / (line.length() - last);

			bw.write(val + "\n");
		}
		

		bw.flush();
		bw.close();
		br.close();
	}

	public static int getPi(String s) {
		int[] pi = new int[s.length()];
		int j = 0;

		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}

			if (s.charAt(i) == s.charAt(j)) pi[i] = ++j;
			
		}

		return pi[s.length()-1];
	}
}
