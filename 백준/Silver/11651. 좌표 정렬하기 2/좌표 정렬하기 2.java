import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr, temp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        temp = new int[N][2];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());

            arr[i] = new int[] {x, y};
        }

        divide(0, N-1);

        for(int[] arr : arr) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public static void divide(int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            divide(s, mid);
            divide(mid+1, e);
            mergeSort(s, e);
        }
    }

    public static void mergeSort(int s, int e) {
        if(e - s < 1) {
            return;
        }

        int idx = s;
        int mid = (s + e) / 2;
        int left = s;
        int right = mid + 1;

        for (int i = s; i <= mid; i++) {
            temp[idx++] = arr[i];
        }


        int tempIdx = s;
        while(left <= mid && right <= e) {
            if(temp[left][1] < arr[right][1] ) {
                arr[tempIdx++] = temp[left++];
            } else if(temp[left][1] > arr[right][1]) {
                arr[tempIdx++] = arr[right++];
            } else {
                if (temp[left][0] < arr[right][0]) {
                    arr[tempIdx++] = temp[left++];
                } else {
                    arr[tempIdx++] = arr[right++];
                }
            }
        }

        while(left <= mid) {
            arr[tempIdx++] = temp[left++];
        }

        while(right <= e) {
            arr[tempIdx++] = arr[right++];
        }
    }
}