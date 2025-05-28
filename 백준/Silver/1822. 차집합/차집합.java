import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static TreeSet<Integer> set1 = new TreeSet<>();
    static HashSet<Integer> set2 = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        set1.removeAll(set2);
        
        if (set1.isEmpty()) {
            System.out.println(0);
        } else {
            bw.write(set1.size() + "\n");
            for (int i : set1) {
                bw.write(i + " ");
            }
            bw.flush();
        }

        br.close();
    }
}