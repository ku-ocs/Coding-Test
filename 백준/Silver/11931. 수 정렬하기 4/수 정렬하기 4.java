import java.io.*;

public class Main {
    static int N;
    static int[] arr, tempArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tempArr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(0, N-1);

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
        int tempIdx = start;
        for (int i = start; i <= mid; i++) {
            tempArr[tempIdx++] = arr[i];
        }

        int left = start;
        int right = mid + 1;
        int idx = start;

        while(left <= mid && right <= end) {
            if (tempArr[left] > arr[right]) {
                arr[idx++] = tempArr[left++];
            } else {
                arr[idx++] = arr[right++];
            }
        }

        while (left <= mid) {
            arr[idx++] = tempArr[left++];
        }

        while (right <= end) {
            arr[idx++] = arr[right++];
        }
    }
}