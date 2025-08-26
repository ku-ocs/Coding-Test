import java.util.*;
import java.io.*;

public class Main {
	static int N, M, S, D, val, INF = 1_000_000_000;
	static int[] d;
	static int[][] road;
	// 해당 노드의 부모 노드들을 저장하는 list 배열
	static ArrayList<Integer>[] prev;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;

		while(true) {
			stz = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stz.nextToken());
			M = Integer.parseInt(stz.nextToken());
			if (N == 0 && M == 0) break;
			
			d = new int[N+1];
			road = new int[N+1][N+1];
			for (int i = 0; i <= N; i++) {
				Arrays.fill(road[i], -1);
			}

			prev = new ArrayList[N+1];
			for (int i = 0; i <= N; i++) {
				prev[i] = new ArrayList<>();
			}

			stz = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(stz.nextToken());
			D = Integer.parseInt(stz.nextToken());

			while(M-- > 0) {
				stz = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(stz.nextToken());
				int v = Integer.parseInt(stz.nextToken());
				int c = Integer.parseInt(stz.nextToken());
				road[u][v] = c;
			}

			dijkstra();
			removeVertex();
			dijkstra();
			bw.write((d[D] != INF ? d[D] : -1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void dijkstra() {
		Arrays.fill(d, INF);
		d[S] = 0;
		pq.offer(new int[] {0, S});

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curD = cur[0];
			int curN = cur[1];
			if (d[curN] < curD) continue;
			for (int i = 0; i <= N; i++) {
				int nxtD = road[curN][i];
				if(nxtD == -1) continue;
				if (d[i] > curD + nxtD) {
					d[i] = curD + nxtD;
					pq.offer(new int[] {d[i], i});
					// 최단경로인 노드가 선택되었다면 초기화 및 새로 노드입력
					prev[i].clear();
					prev[i].add(curN);
				} else if (d[i] == curD + nxtD) {
					// 값이 같다면 기존 리스트에 노드입력
					prev[i].add(curN);
				}
			}
		}
	}

	// 최단 경로에 해당하는 간선 지우기
	public static void removeVertex() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(D);

		while(!queue.isEmpty()) {
			int node = queue.poll();
			for (int pre : prev[node]) {
				// 간선이 이미 지워졌거나 간선이 최단경로에 해당하는 간선이 맞는지 확인 후 지우기
				if (road[pre][node] != -1 && d[node] == d[pre] + road[pre][node]) {
					road[pre][node] = -1;
					queue.offer(pre);
				}
			}
		}
	}
}