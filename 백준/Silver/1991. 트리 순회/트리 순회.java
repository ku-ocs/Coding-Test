import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            String s1 = stz.nextToken();
            String s2 = stz.nextToken();
            String s3 = stz.nextToken();

            int n1 = s1.equals(".") ? 0 : s1.charAt(0) - 65;
            int n2 = s2.equals(".") ? 0 : s2.charAt(0) - 65;
            int n3 = s3.equals(".") ? 0 : s3.charAt(0) - 65;

            arr[n1] = new int[] {n2, n3};
        }

        front(0);
        bw.write("\n");
        mid(0);
        bw.write("\n");
        back(0);

        bw.flush();
        bw.close();
        br.close();
    }



    public static void front(int i) throws IOException{
        char c = (char) (byte) (i + 65);
        bw.write(c);

        if (arr[i][0] != 0) {
            front(arr[i][0]);
        }

        if (arr[i][1] != 0) {
            front(arr[i][1]);
        }
    }

    public static void mid(int i) throws IOException {
        if (arr[i][0] != 0) {
            mid(arr[i][0]);
        }

        char c = (char) (byte) (i + 65);
        bw.write(c);

        if (arr[i][1] != 0) {
            mid(arr[i][1]);
        }
    }

    public static void back(int i) throws IOException {
        if (arr[i][0] != 0) {
            back(arr[i][0]);
        }

        if (arr[i][1] != 0) {
            back(arr[i][1]);
        }

        char c = (char) (byte) (i + 65);
        bw.write(c);
    }
}