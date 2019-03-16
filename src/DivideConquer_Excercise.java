public class DivideConquer_Excercise {

    public static void main(String[] arg){

        for(int i = 1; i <= 100; i++){

            System.out.println("FastSum[" + i + "] - " + fastSum(i));
        }



    }

    private static int fastSum(int n){

        if(n == 1) return n;
        if(n%2 == 1) return fastSum(n-1) + n;

        return  fastSum(n/2) * 2 + n*n/4;
    }
}
