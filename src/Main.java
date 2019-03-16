import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int TC = 0;
    static int P  = 0;
    static int A  = 0;
    static int D  = 0;
    static ArrayList<char[][]> P_BOX;
    static char[][] A_PNL;
    static StringTokenizer st1;
    static StringTokenizer st2;
    static boolean[] chk;
    static String ANS_SAVE;
    static long cnt;
    static boolean flg;
    public static void main(String[] args) throws Exception{

        FileInputStream fis = new FileInputStream("input.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        //테스트 케이스
        TC = Integer.parseInt(br.readLine());

        long FR, TO;

        FR = System.currentTimeMillis();

        for(int i = 0; i < TC; i++){
            //판 갯수
            P = Integer.parseInt(br.readLine());
            P_BOX = new ArrayList<char[][]>();

            for(int j = 0; j < P; j++){
                char[][] PNL = new char[8][8];
                for(int k = 0; k < 8; k++){
                    PNL[k] = br.readLine().toCharArray();
                }
                P_BOX.add(PNL);
            }

            A = Integer.parseInt(br.readLine());


            A_PNL = new char[8][8];
            String RESULT = "#"+(i+1) +"";
            for(int j = 0; j < A; j++){

                for(int k = 0; k < 8; k++){
                    A_PNL[k] = br.readLine().toCharArray();
                }
                FR = System.currentTimeMillis();
                findSolution();

                RESULT += " " + ANS_SAVE;
                TO = System.currentTimeMillis();

                System.out.println("구동시간 : " + (TO - FR) + "(밀리초)" + " : " + cnt);

            }

            System.out.println(RESULT.trim());

        }

//        TO = System.currentTimeMillis();
//
//        System.out.println("구동시간 : " + (TO - FR) + "(밀리초)");
    }

    static void findSolution(){

        char[][] B_PNL = new char[8][8];
        init_Panel(B_PNL);
        D = 3;
        chk = new boolean[P];
        ANS_SAVE = null;
        cnt = 0;
        Matrix(B_PNL, 0, "");

    }

    static void Matrix(char[][] B, int depth, String ANS){

//        System.out.println(depth + ":" + ANS);
//        printMatrix(B);
        if(depth > D){
            return;
        }

        char[][] T_PNL;
        for(int i = 0; i < P; i++){

            if(chk[i] == true) continue;
            T_PNL = copyMatrix(P_BOX.get(i));

            chk[i] = true;
            int NN = chkCycle(T_PNL);
            for(int j = 0; j < NN; j++){

                char[][] B1 = putMatrix(B, T_PNL);

                if(compareMatrix(B1)){
                    if(compareMatrix2(B1)){
                        String tt = (depth+1) + " " + (i+1) + " " + ANS;
                        ANS_SAVE = chkAns(ANS_SAVE,tt.trim());
                        D = depth;
                        break;
                    }else{
                        Matrix(B1, depth+1, (i+1) + " " + ANS);
                        rotate_Matrix(T_PNL);
                    }

                }else{
                    rotate_Matrix(T_PNL);
                    continue;
                }

            }

            chk[i] = false;

        }

    }

    public static void init_Panel(char[][] p){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                p[i][j] = '.';
            }
        }
    }

    public static String chkAns(String a, String b){
        if(a == null) return b;
        if(b == null) return a;
        String[] A = a.split(" ");
        String[] B = b.split(" ");
        int n = A.length < B.length ? A.length : B.length;

        int i1, i2;
        for(int i = 0; i < n; i++){
            i1 = Integer.parseInt(A[i]);
            i2 = Integer.parseInt(B[i]);

            if(i1 == i2) continue;
            if(i1 < i2) return a;
            else return b;
        }

        return a;
    }

    public static void rotate_Matrix(char[][] m){

        int n = m.length;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                char tmp;
                tmp = m[i][j];
                m[i][j] = m[n-1-j][i];
                m[n-1-j][i] = m[n-1-i][n-1-j];
                m[n-1-i][n-1-j] = m[j][n-1-i];
                m[j][n-1-i] = tmp;
            }
        }
    }

    public static boolean compareMatrix(char[][] p){

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if('.' != p[i][j] && p[i][j] != A_PNL[i][j]) return false;
            }
        }

        return true;
    }
    public static boolean compareMatrix2(char[][] p){

        char t;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                t = '.' == p[i][j] ? 'W' : p[i][j];
                if(t != A_PNL[i][j]) return false;
            }
        }

        return true;
    }
    public static char[][] putMatrix(char[][] T, char[][] S){
        int n = T.length;

        char[][] R = new char[8][8];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                R[i][j] = '.' == T[i][j] ? S[i][j] : T[i][j];
            }
        }

        return R;

    }
    public static void printMatrix(char[][] m){

        int n = m.length;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){

                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("");
    }

    public static char[][] copyMatrix(char[][] m){
        char[][] t = new char[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                t[i][j] = m[i][j];
            }
        }

        return t;
    }

//    public static boolean chkMatrix(char[][] m){
//        int o = 0;
//
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 8; j++){
//                if(A_PNL[i][j].equals(m[i][j])) o++;
//                if(o > 0) return true;
//            }
//        }
//        return false;
//    }

    public static int chkCycle(char[][] m){
        char[][] T = copyMatrix(m);

        //90도
        rotate_Matrix(T);

        if(compareMatrix3(m,T)){
            return 1;
        }
        //180도
        rotate_Matrix(T);
        if(compareMatrix3(m,T)){
            return 2;
        }

        return 4;

    }

    public static boolean compareMatrix3(char[][] a, char[][] b){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}
