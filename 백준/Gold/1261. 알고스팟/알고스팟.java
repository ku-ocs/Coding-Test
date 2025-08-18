import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static boolean[][] vis;
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");

		N = Integer.parseInt(sArr[1]);
		M = Integer.parseInt(sArr[0]);

		map = new int[N][M];
		dist = new int[N][M];
		vis = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			sArr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		queue.offer(new int[] {0, 0, 0});
		vis[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curCnt = cur[2];
			for (int i = 0; i < 4; i++) {
				int nxtX = curX + dx[i];
				int nxtY = curY + dy[i];
				if (nxtX >= N || nxtX < 0 || nxtY >= M || nxtY < 0) continue;
				int nxtCnt = map[nxtX][nxtY] == 1 ? curCnt+1 : curCnt;
				if (nxtCnt >= dist[nxtX][nxtY] && vis[nxtX][nxtY]) continue;
				vis[nxtX][nxtY] = true;
				dist[nxtX][nxtY] = nxtCnt;
				queue.offer(new int[] {nxtX, nxtY, nxtCnt});
			}
		}

		System.out.println(dist[N-1][M-1]);
	}
}