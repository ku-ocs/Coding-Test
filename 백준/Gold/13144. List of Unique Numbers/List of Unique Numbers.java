import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        int s = 0;
        int e = 0;

        while (s != N) {
            if (e < N && !set.contains(arr[e])) {
                set.add(arr[e++]);
                continue;
            }
            answer += e - s;
            set.remove(arr[s++]);
        }

        System.out.println(answer);
    }
}