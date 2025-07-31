import java.util.*;
import java.io.*;

public class Main {
	static int T, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stz.nextToken());
			M = Integer.parseInt(stz.nextToken());
			for (int j = 0; j < M; j++) {
				stz = new StringTokenizer(br.readLine(), " ");
			}
            sb.append(N-1).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}