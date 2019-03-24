public class DivideConquer_Excercise {

    public static int i;

    public static void main(String[] arg){
        /*
        for(int i = 1; i <= 100; i++){

            System.out.println("FastSum[" + i + "] - " + fastSum(i));
        }*/


//        String inpt1 = "xbwxwbbwb";

//        System.out.println(reverseQuadTree(inpt1));

        //배열 곱셈
        int[] a = {1,2,3,4,5,6};
        int[] b = {3,4,5,6};
        int[] c = multiply(a,b);

        print(c);


    }

    private static int fastSum(int n){

        if(n == 1) return n;
        if(n%2 == 1) return fastSum(n-1) + n;

        return  fastSum(n/2) * 2 + n*n/4;
    }

    public static String reverseQuadTree(String inpt){

        char c = inpt.charAt(i);
        i++;

        if(c == 'w' || c == 'b') return c +"";

        String leftUpper  = reverseQuadTree(inpt);
        String rightUpper = reverseQuadTree(inpt);
        String leftLower  = reverseQuadTree(inpt);
        String rightLower = reverseQuadTree(inpt);

        return "x" + leftLower + rightLower + leftUpper + rightUpper;

    }

    public static int[] multiply(int[] a, int[] b){

        int[] res = new int[a.length + b.length];

        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < a.length; j++){
                res[res.length - 1 - i - j] += a[a.length - 1 - j]*b[b.length - 1 - i];
            }
        }

        nomalize(res);
        return res;
    }

    public static void nomalize(int[] a){

        for(int i = a.length - 1; i>0; i--){
            a[i-1] += a[i] / 10;
            a[i] = a[i] % 10;
        }
    }

    public static void print(int[] n){

        for(int i = 0; i < n.length; i++){
            System.out.print(n[i]);
        }

        System.out.println("");
    }

    public static int[] karatsuba(int[] a, int[] b){

        int an = a.length; int bn = b.length;

        if(an < bn) karatsuba(b, a);

        if(an == 0 || bn == 0) return new int[0];

        int half = an / 2;

        int[] a1 = arrayMove(a, 0, half);
        int[] a0 = arrayMove(a, half+1, a.length - 1);

        int[] b1 = arrayMove(b, 0, min(b.length-1,half));
        int[] b0 = arrayMove(b, min(b.length -1, half) + 1, b.length - 1);

        int[] z1 = karatsuba(a1, b1);
        int[] z3 = karatsuba(a0, b0);
        int[] z2 =

        return null;
    }

    public static int[] arrayMove(int[] a, int fr, int to){
        int n = to - fr;
        if(n < 0) return new int[0];
        int[] res = new int[n+1];

        int k = 0;
        for(int i = fr; i <= to; i++){
            res[k] = a[i];
            k++;
        }

        return res;

    }

    public static int min(int a, int b){
        if(a > b) return b; else return a;
    }

    public static int[] addTo(int[] a, int[] b){

        int an = a.length; int bn = b.length;

        if(an < bn) addTo(b, a);

        int[] res = new int[an+1];


        return null;




    }
}
