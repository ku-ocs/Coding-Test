import java.util.*;
import java.io.*;

public class Main {
	static int N, M, answer;
	static int[] heavier, lighter; // heavier - heavier[i] 숫자보다 무겁다, lighter - lighter[i] 숫자보다 가볍다.
	static boolean[] vis;
	static ArrayList<Integer>[] hList, lList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		heavier = new int[N+1];
		lighter = new int[N+1];
		hList = new ArrayList[N+1];
		lList = new ArrayList[N+1];

		for (int i = 0; i <= N; i++) {
			hList[i] = new ArrayList<>();
			lList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(stz.nextToken());
			int l = Integer.parseInt(stz.nextToken());
			hList[h].add(l);	// h 가 l 들보다 무거움.
			lList[l].add(h);	// l 가 h 들보다 가벼움.
		}
		
		int mid = N / 2 + 1;

		for (int i = 1; i <= N; i++) {
			vis = new boolean[N+1];
			int h = cntH(i);
			vis = new boolean[N+1];
			int l = cntL(i);
			if (h >= mid || l >= mid) {
				answer++;
			}
		}

		System.out.println(answer);

		br.close();
	}

	public static int cntH(int i) {
		if (vis[i]) return heavier[i];
		vis[i] = true;
		int cnt = 0;
		for (int n : hList[i]) {
			if(vis[n]) continue;
			cnt++;
			cnt += cntH(n);
		}
		heavier[i] = cnt;
		return heavier[i];
	}

	public static int cntL(int i) {
		if (vis[i]) return lighter[i];
		vis[i] = true;
		int cnt = 0;
		for (int n : lList[i]) {
			if(vis[n]) continue;
			cnt++;
			cnt += cntL(n);
		}
		lighter[i] = cnt;
		return lighter[i];
	}
}