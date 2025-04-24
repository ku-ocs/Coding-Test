import java.io.*;

public class Main {
    static int N;
    static int[] arr = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num+1000000]++;
        }

        for (int i = 0; i < arr.length; i++) {
            int cnt = arr[i];
            int num = i - 1000000;
            for (int j = 0; j < cnt; j++) {
                bw.write(num + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}