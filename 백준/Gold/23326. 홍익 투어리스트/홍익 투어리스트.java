import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static TreeSet<Integer> set = new TreeSet<>();
    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        Q = Integer.parseInt(stz.nextToken());

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(stz.nextToken()) == 1) {
                set.add(i+1);
            }
        }

        int loc = 1;
        for (int i = 0; i < Q; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(stz.nextToken());
            if (order == 3) {
                if (set.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(calDistance(loc) + "\n");
                }
            } else if (order == 2) {
                int move = Integer.parseInt(stz.nextToken());
                loc = (loc + move - 1) % N + 1;
            } else {
                int place = Integer.parseInt(stz.nextToken());
                if (set.contains(place)) {
                    set.remove(place);
                } else {
                    set.add(place);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int calDistance(int loc) {
        Integer nxt = set.ceiling(loc);
        if (nxt == null) {
             return N - (loc - set.first());
        }
        return nxt - loc;
    }
}
