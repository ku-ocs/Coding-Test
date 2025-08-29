import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, S, D, tax;
	static long INF = 1_000_000_000_000_000L;
	static long answer;
	static long[][] p;
	static ArrayList<int[]>[] oriList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		K = Integer.parseInt(stz.nextToken());

		oriList = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			oriList[i] = new ArrayList<>();
		}

		stz = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(stz.nextToken());
		D = Integer.parseInt(stz.nextToken());

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stz.nextToken());
			int v = Integer.parseInt(stz.nextToken());
			int w = Integer.parseInt(stz.nextToken());
			oriList[u].add(new int[] {w, v});
			oriList[v].add(new int[] {w, u});
		}

		algorithm();

		for (int i = 0; i <= K; i++) {
			answer = Long.MAX_VALUE;

			if (i != 0) {
				tax += Integer.parseInt(br.readLine());
			}

			for (int j = 1; j <= N; j++) {
				answer = Math.min(answer, p[D][j] + tax * j);
			}

			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void algorithm() {
		p = new long[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				p[i][j] = INF;
			}
		}
		p[S][0] = 0;

		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
		pq.offer(new long[] {0, S, 0});

		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curD = cur[0];
			int curN = (int) cur[1];
			int lineCnt = (int) cur[2];
			if (lineCnt >= N) continue;
			if (curD > p[curN][lineCnt]) continue;
			for(int[] nxt : oriList[curN]) {
				int nxtD = nxt[0];
				int nxtN = nxt[1];
				if (curD + nxtD >= p[nxtN][lineCnt+1]) continue;
				p[nxtN][lineCnt+1] = curD + nxtD;
				pq.offer(new long[] {curD + nxtD, nxtN, lineCnt+1 });
			}
		}
	}
}