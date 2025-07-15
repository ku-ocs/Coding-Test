import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] homeworkArr = new int[n][2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(stz.nextToken());
            int cup = Integer.parseInt(stz.nextToken());
            homeworkArr[i] = new int[] {time, cup};
        }
        
        Arrays.sort(homeworkArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] arr : homeworkArr) {
            int time = arr[0];
            int cup = arr[1];
            boolean delete = false;
            if (pq.size() >= time) delete = true;
            pq.offer(cup);
            answer += cup;
            if (delete) answer -= pq.poll();
        }

        System.out.println(answer);
    }
}