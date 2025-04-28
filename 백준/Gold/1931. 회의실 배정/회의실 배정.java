import java.io.*;
import java.util.*;

public class Main {
    static int N, t, answer;
    static List<int[]> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());

            list.add(new int[] {e, s}); // 끝나는시간 순으로 정렬 - 그리디
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int [] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (int[] arr : list) {
            if (arr[1] >= t) {
                t = arr[0];
                answer++;
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }
}