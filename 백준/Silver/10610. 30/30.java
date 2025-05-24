import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        if(!num.contains("0")) {
            System.out.println(-1);
            return;
        }

        String[] sNums = num.split("");
        if (Arrays.stream(sNums).mapToInt(Integer::parseInt).sum() % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Integer[] iNums = Arrays.stream(sNums).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Arrays.sort(iNums, Collections.reverseOrder());
        
        for (Integer i : iNums) answer += i;
        
        System.out.println(answer);
    }
}