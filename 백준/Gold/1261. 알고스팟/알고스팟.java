import java.util.*;
import java.io.*;

public class Main {
	static int N, M, INF = 1_000_000_000;
	static int[][] map;
	static int[][] dist;
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	static Deque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");

		N = Integer.parseInt(sArr[1]);
		M = Integer.parseInt(sArr[0]);

		map = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			sArr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sArr[j]);
				dist[i][j] = INF;
			}
		}

		dq.offer(new int[] {0, 0});
		dist[0][0] = 0;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int curX = cur[0];
			int curY = cur[1];
			for (int i = 0; i < 4; i++) {
				int nxtX = curX + dx[i];
				int nxtY = curY + dy[i];
				if (nxtX >= N || nxtX < 0 || nxtY >= M || nxtY < 0) continue;
				int cnt = map[nxtX][nxtY];
				if (dist[nxtX][nxtY] <= dist[curX][curY] + cnt) continue;
				dist[nxtX][nxtY] = dist[curX][curY] + cnt;
				if (cnt == 0) dq.addFirst(new int[] {nxtX, nxtY});
				else dq.addLast(new int[] {nxtX, nxtY});
			}
		}

		System.out.println(dist[N-1][M-1]);
	}
}