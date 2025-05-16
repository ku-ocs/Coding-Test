import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            Cube cube = new Cube();

            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < t; j++) {
                String[] s = stz.nextToken().split("");
                String pos = s[0];
                String dir = s[1];

                if (pos.equals("L")) {
                    if (dir.equals("+")) {
                        cube.clockWiseL();
                    } else {
                        cube.counterClockWiseL();
                    }
                } else if (pos.equals("R")) {
                    if (dir.equals("+")) {
                        cube.clockWiseR();
                    } else {
                        cube.counterClockWiseR();
                    }
                } else if (pos.equals("F")) {
                    if (dir.equals("+")) {
                        cube.clockWiseF();
                    } else {
                        cube.counterClockWiseF();
                    }
                } else if (pos.equals("B")) {
                    if (dir.equals("+")) {
                        cube.clockWiseB();
                    } else {
                        cube.counterClockWiseB();
                    }
                } else if (pos.equals("U")) {
                    if (dir.equals("+")) {
                        cube.clockWiseU();
                    } else {
                        cube.counterClockWiseU();
                    }
                } else {
                    if (dir.equals("+")) {
                        cube.clockWiseD();
                    } else {
                        cube.counterClockWiseD();
                    }
                }
            }
            cube.getU();
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static class Cube {
        private String[][] U = new String[3][3];
        private String[][] D = new String[3][3];
        private String[][] F = new String[3][3];
        private String[][] B = new String[3][3];
        private String[][] L = new String[3][3];
        private String[][] R = new String[3][3];

        Cube() {
            for (int i = 0; i < 3; i++) {
                Arrays.fill(U[i], "w");
                Arrays.fill(D[i], "y");
                Arrays.fill(F[i], "r");
                Arrays.fill(B[i], "o");
                Arrays.fill(L[i], "g");
                Arrays.fill(R[i], "b");
            }
        }

        public void clockWiseU() {
            String temp1 = F[0][0];
            String temp2 = F[0][1];
            String temp3 = F[0][2];
            this.F[0][0] = this.R[0][0];
            this.F[0][1] = this.R[0][1];
            this.F[0][2] = this.R[0][2];
            this.R[0][0] = this.B[0][0];
            this.R[0][1] = this.B[0][1];
            this.R[0][2] = this.B[0][2];
            this.B[0][0] = this.L[0][0];
            this.B[0][1] = this.L[0][1];
            this.B[0][2] = this.L[0][2];
            this.L[0][0] = temp1;
            this.L[0][1] = temp2;
            this.L[0][2] = temp3;
            rotate(this.U);
        }

        public void counterClockWiseU() {
            clockWiseU();
            clockWiseU();
            clockWiseU();
        }

        public void clockWiseD() {
            String temp1 = F[2][0];
            String temp2 = F[2][1];
            String temp3 = F[2][2];
            this.F[2][0] = this.L[2][0];
            this.F[2][1] = this.L[2][1];
            this.F[2][2] = this.L[2][2];
            this.L[2][0] = this.B[2][0];
            this.L[2][1] = this.B[2][1];
            this.L[2][2] = this.B[2][2];
            this.B[2][0] = this.R[2][0];
            this.B[2][1] = this.R[2][1];
            this.B[2][2] = this.R[2][2];
            this.R[2][0] = temp1;
            this.R[2][1] = temp2;
            this.R[2][2] = temp3;
            rotate(this.D);
        }

        public void counterClockWiseD() {
            clockWiseD();
            clockWiseD();
            clockWiseD();
        }

        public void clockWiseF() {
            String temp1 = U[2][0];
            String temp2 = U[2][1];
            String temp3 = U[2][2];
            this.U[2][2] = this.L[0][2];
            this.U[2][1] = this.L[1][2];
            this.U[2][0] = this.L[2][2];
            this.L[0][2] = this.D[0][0];
            this.L[1][2] = this.D[0][1];
            this.L[2][2] = this.D[0][2];
            this.D[0][2] = this.R[0][0];
            this.D[0][1] = this.R[1][0];
            this.D[0][0] = this.R[2][0];
            this.R[0][0] = temp1;
            this.R[1][0] = temp2;
            this.R[2][0] = temp3;
            rotate(this.F);
        }

        public void counterClockWiseF() {
            clockWiseF();
            clockWiseF();
            clockWiseF();
        }

        public void clockWiseB() {
            String temp1 = U[0][0];
            String temp2 = U[0][1];
            String temp3 = U[0][2];
            this.U[0][0] = this.R[0][2];
            this.U[0][1] = this.R[1][2];
            this.U[0][2] = this.R[2][2];
            this.R[2][2] = this.D[2][0];
            this.R[1][2] = this.D[2][1];
            this.R[0][2] = this.D[2][2];
            this.D[2][0] = this.L[0][0];
            this.D[2][1] = this.L[1][0];
            this.D[2][2] = this.L[2][0];
            this.L[2][0] = temp1;
            this.L[1][0] = temp2;
            this.L[0][0] = temp3;
            rotate(this.B);
        }

        public void counterClockWiseB() {
            clockWiseB();
            clockWiseB();
            clockWiseB();
        }

        public void clockWiseL() {
            String temp1 = U[0][0];
            String temp2 = U[1][0];
            String temp3 = U[2][0];
            this.U[2][0] = this.B[0][2];
            this.U[1][0] = this.B[1][2];
            this.U[0][0] = this.B[2][2];
            this.B[2][2] = this.D[0][0];
            this.B[1][2] = this.D[1][0];
            this.B[0][2] = this.D[2][0];
            this.D[0][0] = this.F[0][0];
            this.D[1][0] = this.F[1][0];
            this.D[2][0] = this.F[2][0];
            this.F[0][0] = temp1;
            this.F[1][0] = temp2;
            this.F[2][0] = temp3;
            rotate(this.L);
        }

        public void counterClockWiseL() {
            clockWiseL();
            clockWiseL();
            clockWiseL();
        }

        public void clockWiseR() {
            String temp1 = U[0][2];
            String temp2 = U[1][2];
            String temp3 = U[2][2];
            this.U[0][2] = this.F[0][2];
            this.U[1][2] = this.F[1][2];
            this.U[2][2] = this.F[2][2];
            this.F[0][2] = this.D[0][2];
            this.F[1][2] = this.D[1][2];
            this.F[2][2] = this.D[2][2];
            this.D[2][2] = this.B[0][0];
            this.D[1][2] = this.B[1][0];
            this.D[0][2] = this.B[2][0];
            this.B[2][0] = temp1;
            this.B[1][0] = temp2;
            this.B[0][0] = temp3;
            rotate(this.R);
        }

        public void counterClockWiseR() {
            clockWiseR();
            clockWiseR();
            clockWiseR();
        }

        public void rotate(String[][] pos) {
            String temp1 = pos[0][1];
            String temp2 = pos[0][2];

            pos[0][1] = pos[1][0];
            pos[0][2] = pos[0][0];
            pos[0][0] = pos[2][0];
            pos[1][0] = pos[2][1];
            pos[2][1] = pos[1][2];
            pos[2][0] = pos[2][2];
            pos[1][2] = temp1;
            pos[2][2] = temp2;
        }

        public void getU() throws IOException{
            for (String[] upArr : U) {
                for (String s : upArr) {
                    bw.write(s);
                }
                bw.write("\n");
            }
        }
    }
}
