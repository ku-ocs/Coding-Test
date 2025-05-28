import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B);

        List<Integer> result = new ArrayList<>();
        for (int i : A) {
            if (!binarySearch(B, i)) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            bw.write("0");
        } else {
            Collections.sort(result);
            bw.write(result.size() + "\n");
            for (int x : result) {
                bw.write(x + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length;
        while (s < e) {
            int m = (s + e) / 2;
            if (arr[m] == target) return true;
            else if (arr[m] > target) e = m;
            else s = m+1;
        }
        return false;
    }
}