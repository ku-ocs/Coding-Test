import java.util.*;
import java.io.*;

public class Main { 
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		arr = new int[N+1];
		Arrays.fill(arr, -1);

		for (int i = 0; i < M; i++) {
			stz = new StringTokenizer(br.readLine(), " ");
			int order = Integer.parseInt(stz.nextToken());
			int n1 = Integer.parseInt(stz.nextToken());
			int n2 = Integer.parseInt(stz.nextToken());
			if (order == 0) union(n1, n2);
			else {
				if (find(n1) == find(n2)) bw.write("YES\n");
				else bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

	// 경로 압축 적용
	public static int find(int n) {
		if (arr[n] < 0) return n;
		else return arr[n] = find(arr[n]);
	}

	// union by rank 적용
	public static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 == n2) return false;
        // n1 과 n2 의 랭크는 음수의 절댓값으로 표현되고 있으므로
        // n2 < n1 의 의미는 n2 가 더 큰 rank 를 가지고 있다는 뜻
        // 큰 rank를 작은 rank의 root로 쓴다.
		if (arr[n2] < arr[n1]) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		arr[n1]--;
		arr[n2] = n1;
		return true;
	}
}