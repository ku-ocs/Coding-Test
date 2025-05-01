import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());

        for (int i = 0 ; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int day = Integer.parseInt(stz.nextToken());
            arr = new int[day];
            answer = 0;

            stz = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < day; j++) {
                arr[j] = Integer.parseInt(stz.nextToken());
            }

            int temp = arr[day-1];
            for (int j = arr.length-2; j >= 0; j--) {
                int m = arr[j];
                if (temp >= arr[j]) {
                    answer += temp - m;
                } else {
                    temp = m;
                }
            }

            bw.write(answer+"\n");
        }


        br.close();
        bw.close();
    }
}