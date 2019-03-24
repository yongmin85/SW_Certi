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

    public static int[] karatsuba(int[] a, int b){




        return null;
    }
}
