import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static List<int[]>[] list;
	static List<PriorityQueue<Integer>> D = new ArrayList<>();
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			D.add(new PriorityQueue<>((a, b) -> b - a));
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			int c = Integer.parseInt(stz.nextToken());

			list[u].add(new int[] {c, v});
		}

		pq.offer(new int[] {0, 1});
		D.get(1).offer(0);

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curD = cur[0];
			int curN = cur[1];
			if (D.get(curN).size() == K && D.get(curN).peek() < curD) continue;
			for (int[] nxt : list[curN]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (D.get(nxtN).size() == K && D.get(nxtN).peek() < curD + nxtD) continue;
				if (D.get(nxtN).size() == K) D.get(nxtN).poll();
				D.get(nxtN).offer(curD + nxtD);
				pq.offer(new int[] {curD + nxtD, nxtN});
			}
		}

		for (int i = 1; i <= N; i++) {
			if (D.get(i).size() == K) {
				bw.write(D.get(i).peek() + "\n");
			} else {
				bw.write(-1 + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}