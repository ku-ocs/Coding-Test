import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long N, numA, priceA, numB, priceB, answer = Long.MAX_VALUE;
    static boolean change;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(stz.nextToken());
        numA = Long.parseLong(stz.nextToken());
        priceA = Long.parseLong(stz.nextToken());
        numB = Long.parseLong(stz.nextToken());
        priceB = Long.parseLong(stz.nextToken());

        // A 를 가성비 좋게 만들기
        if (priceA * numB > priceB * numA ||
                (priceA * numB == priceB * numA && numA > numB)) {
            change = true;
        }

        if (change) {
            long tempNum = numA;
            long tempPrice = priceA;
            numA = numB;
            priceA = priceB;
            numB = tempNum;
            priceB = tempPrice;
        }

        long gcd = gcd(numA, numB);
        // max 는 LCM 에서 numB 를 나눈 값
        long max = numA / gcd;

        // bCnt * numB 를 넘어가는 것은 가성비가 떨어지는 행동임
        // 따라서, max 로 루프를 제한
        for (long bCnt = 0; bCnt <= max; bCnt++) {
            long cost = 0;
            cost += bCnt*priceB;

            long remain = N - bCnt*numB;
            if (remain > 0) {
                long aCnt = (remain + numA -1) / numA;
                cost += aCnt*priceA;
            }

            answer = Math.min(answer, cost);
        }

        System.out.println(answer);
    }

    public static long gcd(long n1, long n2) {
        if (n1 % n2 == 0) return n2;
        else return gcd(n2, n1%n2);
    }
}
