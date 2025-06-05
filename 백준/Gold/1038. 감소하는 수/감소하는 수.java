import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());


        if (N <= 10) {
            System.out.println(N);
            return;
        }

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i <= 10; i++) {
            bt(i, "", 10);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    public static void bt(int length, String answer, int num) {
        if (answer.length() == length) {
            list.add(Long.parseLong(answer));
            return;
        }

        int max = num-1;

        for (int i = max; i >= 0; i--) {
            answer += i;
            bt(length, answer, i);
            answer = answer.substring(0, answer.length()-1);
        }
    }
}