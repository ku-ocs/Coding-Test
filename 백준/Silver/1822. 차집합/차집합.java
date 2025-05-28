import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashSet<Integer> set1 = new HashSet<>();
    static HashSet<Integer> set2 = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            set1.add(Integer.parseInt(stz.nextToken()));
        }

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            set2.add(Integer.parseInt(stz.nextToken()));
        }
        for (int i : set2) {
            if (set1.contains(i)) set1.remove(i);
        }

        int[] arr1 = set1.stream().sorted().mapToInt(Integer::intValue).toArray();
        if(set1.size() > 0) {
            System.out.println(set1.size());
            for (int i : arr1) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(0);
        }

        br.close();
    }
}