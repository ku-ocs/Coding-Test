import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();

        int[] iArr = new int[26];

        int answer = 0;

        for(char c : chArr1) {
            iArr[c - 'a']++;
        }

        for(char c : chArr2) {
            iArr[c - 'a']--;
        }

        for (int i : iArr) {
            answer += Math.abs(i);
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}