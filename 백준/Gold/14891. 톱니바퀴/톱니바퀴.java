import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static P p1, p2, p3, p4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        char[] l1 = br.readLine().toCharArray();
        char[] l2 = br.readLine().toCharArray();
        char[] l3 = br.readLine().toCharArray();
        char[] l4 = br.readLine().toCharArray();

        p1 = new P(l1);
        p2 = new P(l2);
        p3 = new P(l3);
        p4 = new P(l4);

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(stz.nextToken());
            int dir = Integer.parseInt(stz.nextToken());

            rotate(p, dir, true, true);
        }

        if(p1.getPoint()) {
            answer += 1;
        }
        if(p2.getPoint()) {
            answer += 2;
        }
        if(p3.getPoint()) {
            answer += 4;
        }
        if(p4.getPoint()) {
            answer += 8;
        }

        System.out.println(answer);
        br.close();
    }


    public static void rotate(int p, int dir, boolean leftChain, boolean rightChain) {
        int opDir = -(dir);
        boolean checkLeft;
        boolean checkRight;

        if (p == 1) {
            checkRight = p1.checkRight(p2);
            p1.roll(dir);

            if ( rightChain && checkRight) {
                rotate(2, opDir, false, true);
            }

        } else if (p == 2) {
            checkLeft = p2.checkLeft(p1);
            checkRight = p2.checkRight(p3);
            p2.roll(dir);

            if (leftChain && checkLeft) {
                rotate(1, opDir, true, false);
            }

            if (rightChain && checkRight) {
                rotate(3, opDir, false, true);
            }

        } else if (p == 3) {
            checkLeft = p3.checkLeft(p2);
            checkRight = p3.checkRight(p4);
            p3.roll(dir);

            if ( leftChain && checkLeft) {
                rotate(2, opDir, true, false);
            }

            if (rightChain && checkRight) {
                rotate(4, opDir, false, true);
            }

        } else {
            checkLeft = p4.checkLeft(p3);
            p4.roll(dir);

            if(leftChain && checkLeft) {
                rotate(3, opDir, true, false);
            }
        }
    }

    public static class P {
        private int e1;
        private int e2;
        private int e3;
        private int e4;
        private int e5;
        private int e6;
        private int e7;
        private int e8;

        P (int e1, int e2, int e3, int e4, int e5, int e6, int e7, int e8) {
            this.e1 = e1;
            this.e2 = e2;
            this.e3 = e3;
            this.e4 = e4;
            this.e5 = e5;
            this.e6 = e6;
            this.e7 = e7;
            this.e8 = e8;
        }

        P (char[] cArr) {
            this.e1 = cArr[0] - '0';
            this.e2 = cArr[1] - '0';
            this.e3 = cArr[2] - '0';
            this.e4 = cArr[3] - '0';
            this.e5 = cArr[4] - '0';
            this.e6 = cArr[5] - '0';
            this.e7 = cArr[6] - '0';
            this.e8 = cArr[7] - '0';
        }

        public void roll(int dir) {
            if (dir == 1) {
                int temp = this.e8;
                this.e8 = this.e7;
                this.e7 = this.e6;
                this.e6 = this.e5;
                this.e5 = this.e4;
                this.e4 = this.e3;
                this.e3 = this.e2;
                this.e2 = this.e1;
                this.e1 = temp;
            } else {
                int temp = this.e1;
                this.e1 = this.e2;
                this.e2 = this.e3;
                this.e3 = this.e4;
                this.e4 = this.e5;
                this.e5 = this.e6;
                this.e6 = this.e7;
                this.e7 = this.e8;
                this.e8 = temp;
            }
        }

        public boolean checkLeft(P p) {
            return this.e7 != p.e3;
        }

        public boolean checkRight(P p) {
            return this.e3 != p.e7;
        }

        public boolean getPoint() {
            return this.e1 == 1;
        }
    }
}