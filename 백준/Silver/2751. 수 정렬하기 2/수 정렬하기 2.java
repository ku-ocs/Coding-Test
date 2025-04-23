import java.io.*;

public class Main {
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(0, n-1);

        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void divide(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            divide(start, mid);
            divide(mid+1, end);
            mergeSort(start, end);
        }
    }

    public static void mergeSort(int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int tempIdx = start;
        int Idx = mid+1;

        while (tempIdx <= mid && Idx <= end) {
            if (temp[tempIdx] > arr[Idx]) {
                arr[start++] = arr[Idx++];
            } else {
                arr[start++] = temp[tempIdx++];
            }
        }

        while(tempIdx <= mid) {
            arr[start++] = temp[tempIdx++];
        }

        while (Idx <= end) {
            arr[start++] = arr[Idx++];
        }
    }
}