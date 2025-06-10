import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        // K 의 자릿수 찾기. - 10의 자리인지... 100의 자리인지...
        long len = 0;   // 갱신용 len
        long digit = 1; // 자릿수의 길이
        long cnt = 9;   // 1의 자리 - 9개 / 10의 자리 - 90개 ...
        while (K > len + digit * cnt) {
            len += digit * cnt;  // K 가 1의 자리 수보다 크면 1인 자리 갯수 더하기, 10의 자리 수면 10인 자리 갯수 더하기 ...
            digit++;            // 자릿수의 길이 ++
            cnt *= 10;          // cnt 증가
        }

        // K 가 해당하는 자릿수의 첫 시작 수 - s
        long s = (long) Math.pow(10, digit-1);
        // K 가 해당하는 자릿수에서 K 가 해당하는 수가 s 로부터 몇 번째 수인지.
        long numIndex = (K - len - 1) / digit;
        // K 가 해당하는 수에서 K가 해당하는 자릿수가 몇 번째 자리인지.
        long charIndex = (K - len - 1) % digit;
        // K 가 해당하는 수 찾기
        long number = s + numIndex;

        // K 가 해당하는 수가 N 보다 크면 -1 출력
        if (number > N) System.out.println(-1);
        // K 가 해당하는 수가 N 보다 작으면 해당하는 수의 해당하는 자릿수 출력
        else System.out.println((number+"").charAt((int) charIndex));
    }
}
