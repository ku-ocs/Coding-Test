import java.util.*;
import java.io.*;

public class Main {
	static int N, M, INF = 1_000_000_000;
	static int[] dist;
	static int[] prev;
	static ArrayList<int[]>[] list;
	static List<Integer> cityList = new ArrayList<>();
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N+1];
		prev = new int[N+1];
		Arrays.fill(dist, INF);
		Arrays.fill(prev, -1);

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while(M-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			list[n1].add(new int[] {cost, n2});
		}

		stz = new StringTokenizer(br.readLine(), " ");
		int sNode = Integer.parseInt(stz.nextToken());
		int eNode = Integer.parseInt(stz.nextToken());

		dist[sNode] = 0;
		pq.offer(new int[] {0, sNode});

		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int cost = now[0];
			int cur = now[1];
			if(cost > dist[cur]) continue;
			for (int[] nxt : list[cur]) {
				int nxtCost = nxt[0];
				int nxtN = nxt[1];
				if (nxtCost + dist[cur] >= dist[nxtN]) continue;
				dist[nxtN] = nxtCost + dist[cur];
				prev[nxtN] = cur;
				pq.offer(new int[] {dist[nxtN], nxtN});
			}
		}

		int node = eNode;
		cityList.add(node);
		while(prev[node] != sNode) {
			cityList.add(prev[node]);
			node = prev[node];
		}
		cityList.add(sNode);
		
		bw.write(dist[eNode] + "\n");
		bw.write(cityList.size() + "\n");

		Collections.reverse(cityList);
		for (int i : cityList) {
			bw.write(i + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}