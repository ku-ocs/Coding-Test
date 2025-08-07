import java.util.*;
import java.io.*;

public class Main {
	static int V, E, INF = 1_000_000_000;
	static int[] dist;
	static ArrayList<int[]>[] list;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(stz.nextToken());
		E = Integer.parseInt(stz.nextToken());
		dist = new int[V+1];
		Arrays.fill(dist, INF);

		list = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		int sNode = Integer.parseInt(br.readLine());
		dist[sNode] = 0;
		
		while(E-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			int cost = Integer.parseInt(stz.nextToken());
			list[n1].add(new int[] {cost, n2});
		}
		
		pq.offer(new int[] {0, sNode});

		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int cost = now[0];
			int curN = now[1];
			if (cost > dist[curN]) continue;
			for (int[] nxt : list[curN]) {
				int nxtCost = nxt[0];
				int nxtN = nxt[1];
				if (dist[curN] + nxtCost >= dist[nxtN]) continue;
				dist[nxtN] = dist[curN] + nxtCost;
				pq.offer(new int[] {dist[nxtN], nxtN});
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) bw.write("INF\n");
			else bw.write(dist[i] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}