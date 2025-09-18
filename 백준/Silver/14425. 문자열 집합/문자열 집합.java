import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());

		while(N-- > 0) {
			insert(br.readLine());
		}

		while (M-- > 0) {
			if (find(br.readLine())) answer++;
		}

		System.out.println(answer);
	}

	public static void insert(String s) {
		set.add(s);
	}

	public static boolean find(String s) {
		return set.contains(s);
	}
}