import java.util.*;
import java.io.*;

public class Main {
		static int K, V, E;
		static int[] colors;
		static ArrayList<Integer>[] lineList;
		static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;

		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			queue.clear();
			stz = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(stz.nextToken());
			E = Integer.parseInt(stz.nextToken());

			colors = new int[V+1];
			lineList = new ArrayList[V+1];
			for (int j = 0; j <= V; j++) {
				lineList[j] = new ArrayList<>();
			}

			for (int j = 0; j < E; j++) {
				stz = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(stz.nextToken());
				int e = Integer.parseInt(stz.nextToken());
				lineList[s].add(e);
				lineList[e].add(s);
			}

			if (bfs()) {
				bw.write("YES\n");				
			} else {
				bw.write("NO\n");
			}
		}

        bw.flush();
        bw.close();
        br.close();
	}

	public static boolean bfs() {
		for (int i = 1; i <= V; i++) {
			if (colors[i] != 0) continue;
			queue.offer(i);
			colors[i] = 1;
			while(!queue.isEmpty()) {
  				int n = queue.poll();
				int c = colors[n];
				int nxtC;
				if (c == 1) {
					nxtC = 2;
				} else {
					nxtC = 1;
				}
				for (int e : lineList[n]) {
					if (colors[e] != 0 ) {
						if (colors[e] == nxtC) {
							continue;
						} else {
							return false;
						}
					}
					colors[e] = nxtC;
					queue.offer(e);
				}
			}
		}
		return true;
	}
}