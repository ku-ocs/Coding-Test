import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, idx;
    static long[] arr;
    static String[] sArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sArr = br.readLine().split(" ");
        StringBuffer sb;

        N = Integer.parseInt(sArr[0]);
        arr = new long[N];

        for (int i = 1; i < sArr.length; i++) {
            sb = new StringBuffer(sArr[i]);
            arr[idx++] = Integer.parseInt(sb.reverse().toString());
        }

        while(true) {
            if (idx >= N) break;
            String line = br.readLine();
            if(line.isBlank()) continue;
            sArr = line.split(" ");
            for (String s : sArr) {
                sb = new StringBuffer(s);
                arr[idx++] = Long.parseLong(sb.reverse().toString());
            }
        }

        Arrays.sort(arr);

        for (long i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}