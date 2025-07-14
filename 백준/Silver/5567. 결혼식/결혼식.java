import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n+1];
        int mDepth = 2;
        int answer = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(stz.nextToken());
            int n2 = Integer.parseInt(stz.nextToken());

            ArrayList<Integer> list;

            list = map.get(n1);
            list.add(n2);
            map.put(n1, list);

            list = map.get(n2);
            list.add(n1);
            map.put(n2, list);
        }

        queue.offer(new int[] {1, 0});
        check[1] = true;

        while (!queue.isEmpty()) {
            int[] find = queue.poll();
            int num = find[0];
            int depth = find[1];

            if (depth >= mDepth) continue;
            for (int nxt : map.get(num)) {
                if (check[nxt]) continue;
                check[nxt] = true;
                queue.offer(new int[] {nxt, depth + 1});
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}