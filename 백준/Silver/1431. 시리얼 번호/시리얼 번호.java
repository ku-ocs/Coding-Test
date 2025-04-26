import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Guitar[] guitars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        guitars = new Guitar[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = new Guitar(br.readLine());
        }

        Arrays.sort(guitars);
        for (Guitar g : guitars) {
            bw.write(g.serial+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Guitar implements Comparable{
        String serial;
        int length;
        int sum = 0;

        Guitar(String serial) {
            this.serial = serial;
            this.length = serial.length();
            for (char c : serial.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += (c - '0');
                }
            }
        }

        @Override
        public int compareTo(Object obj) {
            Guitar other = (Guitar) obj;
            if (this.length != other.length) {
                return this.length - other.length;
            } else {
                if(this.sum != other.sum) {
                    return this.sum - other.sum;
                } else {
                    for (int i = 0; i < this.length; i++) {
                        int comp = this.serial.charAt(i) - other.serial.charAt(i);
                        if (comp != 0 ){
                            return comp;
                        }
                    }
                }
            }
            return 0;
        }
    }
}