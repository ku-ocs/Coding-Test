import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] degree;
	static ArrayList<Integer>[] list;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		
		degree = new int[N+1];
		list = new ArrayList[N+1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(stz.nextToken());
			int cur = 0;
			for (int j = 0; j < num; j++) {
				int nxt = Integer.parseInt(stz.nextToken());
				if (cur == 0) cur = nxt;
				else {
					list[cur].add(nxt);
					degree[nxt]++;
					cur = nxt;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) queue.offer(i);
		}

		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			bw.write(cur + "\n");
			cnt++;
			for (int nxt : list[cur]) {
				degree[nxt]--;
				if (degree[nxt] == 0) queue.offer(nxt);
			}
		}

		if (cnt != N) {
			System.out.println(0);
			return;
		}

		bw.flush();
		bw.close();
		br.close();
	}
}