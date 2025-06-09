import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static long answer;
    static int[] arrN, arrM;
    static ArrayList<Integer> listN, listM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(stz.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(stz.nextToken());
        }

        listN = new ArrayList<>();
        listM = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int sumN = arrN[i];
            listN.add(sumN);
            for (int j = i+1; j < N; j++) {
                sumN += arrN[j];
                listN.add(sumN);
            }
        }

        for (int i = 0; i < M; i++) {
            int sumM = arrM[i];
            listM.add(sumM);
            for (int j = i+1; j < M; j++) {
                sumM += arrM[j];
                listM.add(sumM);
            }
        }

        Collections.sort(listM);

        arrM = listM.stream().mapToInt(Integer::intValue).toArray();

        for (int i : listN) {
            int l = lower(i);
            int u = upper(i);

            answer += l-u;
        }

        System.out.println(answer);
    }

    public static int lower(int i) {
        int s = 0;
        int e = arrM.length-1;
        while (s <= e) {
            int m = (s+e) / 2;
            if (i + arrM[m] > T) e = m-1;
            else s = m+1;
        }
        return s;
    }

    public static int upper(int i) {
        int s = 0;
        int e = arrM.length-1;
        while (s <= e) {
            int m = (s+e) / 2;
            if (i + arrM[m] >= T) e = m-1;
            else s = m+1;
        }
        return s;
    }
}
