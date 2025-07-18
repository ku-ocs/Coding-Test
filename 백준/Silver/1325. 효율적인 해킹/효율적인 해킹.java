import java.util.*;
import java.io.*;

public class Main {
    static int N, M, cnt;
    static boolean[] vis;
    static ArrayList<Integer>[] lineList;
    static Queue<Integer> queue = new LinkedList<>();
    static TreeMap<Integer, LinkedList<Integer>> answerMap = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        lineList = new ArrayList[N+1];
        vis = new boolean[N+1];
        LinkedList<Integer> list;

        for (int i = 0; i <= N; i++) {
            lineList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            // e 가 s 를 신뢰한다 ( s 를 해킹하면 e 를 해킹할 수 있다. )
            int e = Integer.parseInt(stz.nextToken());
            int s = Integer.parseInt(stz.nextToken());
            lineList[s].add(e);
        }
        
        for (int i = 1; i <= N; i++) {
            bfs(i);
            list = answerMap.getOrDefault(cnt, new LinkedList<>());
            list.add(i);
            answerMap.put(cnt, list);
        }
        for (int i : answerMap.get(answerMap.lastKey())) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static void bfs(int s) {
        init();
        queue.offer(s);
        vis[s] = true;
        cnt++;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : lineList[n]) {
                if (vis[i]) continue;
                queue.offer(i);
                vis[i] = true;
                cnt++;
            }
        }
    }

    public static void init() {
        cnt = 0;
        queue.clear();
        Arrays.fill(vis, false);
    }
}