import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		N = Integer.parseInt(br.readLine());

		// root 노드 생성
		Node root = new Node();

		// 트리 구성하기
		while(N-- > 0) {
			stz = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(stz.nextToken());

			// 현재 노드를 root 로 지정
			Node cur = root;
			while(T-- > 0) {
				String food = stz.nextToken();

				// 현재 노드에 food 를 key 로 하는 자녀 노드 입력
				cur.child.putIfAbsent(food, new Node());

				// 자녀 노드를 현재 노드로 변경
				cur = cur.child.get(food);
			}
		}

		// root 노드 부터 탐색 시작 및 depth 0 으로 지정
		dfs(root, 0);

		bw.flush();
		bw.close();
		br.close();
	}

	// child의 자료구조를 가진 node 클래스
	static class Node {

		// 사전순으로 정렬하기 위한 TreeMap 클래스
		TreeMap<String, Node> child = new TreeMap<>();
	}

	// treeMap 을 통해 사전순으로 정렬된 자녀순서대로 탐색
	// 자녀의 자녀들을 탐색 -- 자녀가 없다면 탐색종료
	static void dfs(Node node, int depth) throws IOException {
		for (String key : node.child.keySet()) {
			bw.write("--".repeat(depth) + key + "\n");
			dfs(node.child.get(key), depth+1);
		}
	}
}

/*
4
2 KIWI BANANA
2 KIWI APPLE
2 APPLE APPLE
3 APPLE BANANA KIWI
*/