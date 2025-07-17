import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] length;
    static ArrayList<int[]>[] lineList;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        lineList = new ArrayList[N+1];
        length = new int[N+1];

        for (int i = 1; i <= N; i++) {
            lineList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());
            int l = Integer.parseInt(stz.nextToken());
            lineList[s].add(new int[] {e, l});
            lineList[e].add(new int[] {s, l});
        }

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());
            bw.write(getLength(s, e) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getLength(int start, int end) {
        init();
        queue.offer(new int[] {start, 0});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int n1 = arr[0];
            int l1 = arr[1];
            for (int[] lArr : lineList[n1]) {
                int n2 = lArr[0];
                int l2 = lArr[1];
                int tL = l1 + l2;
                if (n2 == start) continue;
                if (length[n2] != 0 && length[n2] <= tL) continue;
                length[n2] = tL;
                queue.offer(new int[] {n2, tL});
            }
        }

        return length[end];
    }

    public static void init() {
        Arrays.fill(length, 0);
        queue.clear();
    }
}