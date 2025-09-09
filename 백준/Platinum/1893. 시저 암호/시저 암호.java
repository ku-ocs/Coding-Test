import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int T;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String orderString = br.readLine();
			String origin = br.readLine();
			String password = br.readLine();
			String answer = getString(orderString, origin, password);
			bw.write(answer + "\n");
		}
		bw.flush();
		br.close();
	}

	public static int[] getpi(String s) {
		int[] pi = new int[s.length()];
		int j = 0;
		for (int i = 1; i < s.length(); i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j-1];
			}

			if (s.charAt(i) == s.charAt(j)) {
				pi[i] = ++j;
			}
		}

		return pi;
	}

	public static String getString(String orderString, String origin, String password) {
		char[] order = orderString.toCharArray();
		int len = orderString.length();

		// shift 는 0 부터 순서 마지막까지
		// shiftString 은 origin 의 글자 각각 order 와 비교하여 같으면 shift 한 글자로 대체
		// shiftString 에 대한 pi 함수 구하고 password 와 비교

		// i 는 shift 간격
		for (int i = 0; i < len; i++) {
			// 각 shift 마다 새로운 String 구하기
			StringBuilder shiftString = new StringBuilder();

			// j 는 origin 의 각 글자들
			for (int j = 0; j < origin.length(); j++) {

				// k 는 order 의 idx
				// 대체되는 글자의 idx 는 (i + k) % len
				for (int k = 0; k < len; k++) {
					if (origin.charAt(j) == order[k]) {
						int idx = (i + k) % len;
						shiftString.append(order[idx]);
					}
				}
			}

			// shiftString 과 password 로 문제 조건에 해당하는 값 찾기 - 알맞으면 shift 를 queue 에 입력
			if (checkSol(shiftString.toString(), password)) {
				queue.offer(i);
			}
		}

		// queue 크기에 따라 값 생성 및 반환
		StringBuilder sb = new StringBuilder();
		if (queue.isEmpty()) {
			sb.append("no solution");	
		} else if (queue.size() == 1) {
			sb.append("unique: ").append(queue.poll());
		} else {
			sb.append("ambiguous: ");
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
		}
		return sb.toString();
	}

	public static boolean checkSol(String shiftString, String password) {
		int[] pi = getpi(shiftString);
		int j = 0;
		int cnt = 0;

		for (int i = 0; i < password.length(); i++) {
			while (j > 0 && shiftString.charAt(j) != password.charAt(i)) {
				j = pi[j-1];
			}

			if (shiftString.charAt(j) == password.charAt(i)) {
				j++;
			}

			if (j == shiftString.length()) {
				cnt++;
				j = pi[j-1];
			}
		}

		if (cnt == 1) {
			return true;
		} 
		
		return false;
	}
}
