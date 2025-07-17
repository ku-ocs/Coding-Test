import java.util.*;
import java.io.*;

public class Main {
    static int N, M, minLength;
    static ArrayList<int[]>[] lineList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        lineList = new ArrayList[N+1];

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
            minLength = Integer.MAX_VALUE;
            getLength(s, 0, e, 0);
            bw.write(minLength + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void getLength(int start, int p, int end, int length) {
        for(int[] arr : lineList[start]) {
            int e = arr[0];
            int l = arr[1];
            if (e == p) continue;
            if (e == end) {
                minLength = Math.min(minLength, length + l);
            } else {
                getLength(e, start, end, length+l);
            }
        }
    }
}