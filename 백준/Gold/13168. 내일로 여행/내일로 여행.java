import java.util.*;
import java.io.*;

public class Main {
	static int N, R, M, K, INF = 1000000000;
	static long cnt1, cnt2;
	static int[][] cost; // 내일로 o
	static int[][] cost2; // 내일로 x
	static HashMap<String, Integer> locMap = new HashMap<>();
	static List<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stz.nextToken());
		R = Integer.parseInt(stz.nextToken()) * 2;
		cost = new int[N][N];
		cost2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					cost[i][j] = 0;
					cost2[i][j] = 0;
				} else {
					cost[i][j] = INF;
					cost2[i][j] = INF;					
				}
			}
		}

		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			locMap.put(stz.nextToken(), i);
		}

		M = Integer.parseInt(br.readLine());
		stz = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			list.add(locMap.get(stz.nextToken()));
		}

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			String type = stz.nextToken();
			int n1 = locMap.get(stz.nextToken());
			int n2 = locMap.get(stz.nextToken());
			int c = Integer.parseInt(stz.nextToken()) * 2;
			cost2[n1][n2] = Math.min(cost2[n1][n2], c);
			cost2[n2][n1] = Math.min(cost2[n2][n1], c);
			if (type.equals("S-Train") || type.equals("V-Train")) {
				cost[n1][n2] = Math.min(cost[n1][n2], c / 2);
				cost[n2][n1] = Math.min(cost[n2][n1], c / 2);
			} else if (type.equals("ITX-Saemaeul") || type.equals("ITX-Cheongchun") || type.equals("Mugunghwa")) {
				cost[n1][n2] = 0;
				cost[n2][n1] = 0;
			} else {
				cost[n1][n2] = Math.min(cost[n1][n2], c);
				cost[n2][n1] = Math.min(cost[n2][n1], c);
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cost[i][k] < INF && cost[k][j] < INF) {
						cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
					}

					if (cost2[i][k] < INF && cost2[k][j] < INF) {
						cost2[i][j] = Math.min(cost2[i][j], cost2[i][k] + cost2[k][j]);	
					}
				}
			}
		}

		int prev = -1;
		int nxt = 0;
		for (int i : list) {
			if (prev < 0) {
				prev = i;
				continue;
			}
			else nxt = i;
			cnt1 += cost[prev][nxt];
			cnt2 += cost2[prev][nxt];
		}

		cnt1 += R;

		if (cnt1 < cnt2) System.out.println("Yes");
		else System.out.println("No");
	}
}