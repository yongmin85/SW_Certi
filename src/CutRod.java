public class CutRod {

    final static int[] L = {1,5,8,9,17,17,17,20,24,11};
    static int P;
    public static void main(String[] arg)throws Exception{


        int s = CutRod(10);

        System.out.println(s);
    }

    public static int CutRod(int n){

        if(n == 0) return 0;
        int p = 0;
        for(int i = 1; i <= n; i++){
            int t = L[i-1] + CutRod(n-i);
            p = t > p ? t : p;
        }

        return p;

    }
}
