import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static Integer[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        arr1 = new Integer[N];
        arr2 = new Integer[N];

        // Integer 배열의 초기값은 null 이므로 정렬을 위해 fill 을 이용해서 0으로 미리 채워두기
        Arrays.fill(arr1, 0);
        Arrays.fill(arr2, 0);
        int idx1 = 0;
        int idx2 = 0;

        for (int i = 0 ; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(stz.nextToken());

            // 값에 따라 배열을 둘로 나누기
            if (num >= 1) {
                arr1[idx1++] = num;
            } else {
                arr2[idx2++] = num;
            }
        }

        // 양수 - 내림차순 정렬
        Arrays.sort(arr1, Comparator.reverseOrder());

        // 음수 + 0 - 오름차순 정렬
        Arrays.sort(arr2);

        for (int i = 1; i < idx1; i += 2) {
            int num1 = arr1[i];
            int num2 = arr1[i-1];
            if (num1 == 1) {
                answer += num1 + num2;
            } else {
                answer += (num1 * num2);
            }
        }

        if (idx1 % 2 == 1) {
            answer += arr1[idx1-1];
        }

        for (int i = 1; i < idx2; i += 2) {
            int num1 = arr2[i];
            int num2 = arr2[i-1];
            answer += (num1 * num2);
        }

        if (idx2 % 2 == 1) {
            answer += arr2[idx2-1];
        }


        bw.write(answer+"");
        bw.flush();

        br.close();
        bw.close();
    }
}