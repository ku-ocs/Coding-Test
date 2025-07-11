import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz;
        LinkedList<Integer> list;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 0; i < N-1; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(stz.nextToken());
            int p2 = Integer.parseInt(stz.nextToken());

            list = map.getOrDefault(p1, new LinkedList<>());
            list.add(p2);
            map.put(p1, list);

            list = map.getOrDefault(p2, new LinkedList<>());
            list.add(p1);
            map.put(p2, list);
        }

        queue.offer(1);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i : map.get(p)) {
                if (parent[i] == 0) {
                    queue.offer(i);
                    parent[i] = p;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}